package com.gildedgames.aether.core.network.packet.server;

import com.gildedgames.aether.common.entity.NpcDialogue;
import com.gildedgames.aether.core.network.AetherPacket;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

/**
 * This packet is sent to the server whenever the player chooses an important action in the NPC dialogue.
 */
public record NpcPlayerInteractPacket(int entityID, byte interactionID) implements AetherPacket {
    @Override
    public void encode(FriendlyByteBuf buf) {
        buf.writeInt(entityID);
        buf.writeByte(interactionID);
    }

    public static NpcPlayerInteractPacket decode(FriendlyByteBuf buf) {
        return new NpcPlayerInteractPacket(buf.readInt(), buf.readByte());
    }

    @Override
    public boolean handle(Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> execute(context.get().getSender()));
        return true;
    }

    public void execute(Player player) {
        if (player != null && player.getServer() != null && player.level.getEntity(this.entityID) instanceof NpcDialogue npc) {
            npc.handleNpcInteraction(player, this.interactionID);
        }
    }
}
