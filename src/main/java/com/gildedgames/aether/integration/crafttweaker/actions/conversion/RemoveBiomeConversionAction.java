package com.gildedgames.aether.integration.crafttweaker.actions.conversion;

//import com.blamejared.crafttweaker.api.actions.IRuntimeAction;
//import com.gildedgames.aether.common.item.materials.util.ISwetBallConversion;
//import net.minecraft.world.level.block.Block;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.resources.ResourceLocation;
//
//public class RemoveBiomeConversionAction implements IRuntimeAction
//{
//    private final ResourceLocation resourceLocation;
//    private final Block block;
//    private final BlockState blockState;
//
//    public RemoveBiomeConversionAction(ResourceLocation resourceLocation, Block block, BlockState blockState) {
//        this.resourceLocation = resourceLocation;
//        this.block = block;
//        this.blockState = blockState;
//    }
//
//    @Override
//    public void apply() {
//        ISwetBallConversion.removeBiomeConversion(this.resourceLocation, () -> this.block, () -> this.blockState);
//    }
//
//    @Override
//    public String describe() {
//        return "Making block " + this.block.getRegistryName() + " in biome " + this.resourceLocation + " no longer convertable with Swet Balls into " + this.blockState.getBlock().getRegistryName();
//    }
//}
