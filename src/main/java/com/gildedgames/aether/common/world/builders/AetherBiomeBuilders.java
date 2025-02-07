package com.gildedgames.aether.common.world.builders;

import com.gildedgames.aether.client.registry.AetherSoundEvents;
import com.gildedgames.aether.common.registry.AetherBlocks;
import com.gildedgames.aether.common.registry.AetherEntityTypes;
import com.gildedgames.aether.common.registry.worldgen.AetherBiomes;
import com.gildedgames.aether.common.registry.worldgen.AetherFeatures;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.sounds.Music;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class AetherBiomeBuilders {
    public static BiomeSource buildAetherBiomeSource(Registry<Biome> registry) {
        final Climate.Parameter FULL_RANGE = Climate.Parameter.span(-1.0F, 1.0F);

        return new MultiNoiseBiomeSource(new Climate.ParameterList<>(List.of(
                Pair.of(
                        new Climate.ParameterPoint(
                                FULL_RANGE,
                                FULL_RANGE,
                                FULL_RANGE,
                                FULL_RANGE,
                                FULL_RANGE,
                                Climate.Parameter.span(1.0F, 2.0F),
                                0
                        ), Holder.Reference.createStandAlone(registry, AetherBiomes.Keys.GOLDEN_FOREST)
                ),
                Pair.of(
                        new Climate.ParameterPoint(
                                FULL_RANGE,
                                FULL_RANGE,
                                FULL_RANGE,
                                FULL_RANGE,
                                FULL_RANGE,
                                Climate.Parameter.span(0.5F, 1.0F),
                                0
                        ), Holder.Reference.createStandAlone(registry, AetherBiomes.Keys.SKYROOT_FOREST)
                ),
                Pair.of(
                        new Climate.ParameterPoint(
                                FULL_RANGE,
                                FULL_RANGE,
                                FULL_RANGE,
                                FULL_RANGE,
                                FULL_RANGE,
                                Climate.Parameter.span(-0.1F, 0.5F),
                                0
                        ), Holder.Reference.createStandAlone(registry, AetherBiomes.Keys.SKYROOT_THICKET)
                ),
                Pair.of(
                        new Climate.ParameterPoint(
                                FULL_RANGE,
                                FULL_RANGE,
                                FULL_RANGE,
                                FULL_RANGE,
                                FULL_RANGE,
                                Climate.Parameter.span(-0.7F, -0.1F),
                                0
                        ), Holder.Reference.createStandAlone(registry, AetherBiomes.Keys.SKYROOT_FOREST)
                ),
                Pair.of(
                        new Climate.ParameterPoint(
                                FULL_RANGE,
                                FULL_RANGE,
                                FULL_RANGE,
                                FULL_RANGE,
                                FULL_RANGE,
                                Climate.Parameter.span(-2.0F, -0.7F),
                                0
                        ), Holder.Reference.createStandAlone(registry, AetherBiomes.Keys.SKYROOT_GROVE)
                )
        )));
    }

    public static Biome skyrootGroveBiome() {
        return makeDefaultBiome(new BiomeGenerationSettings.Builder()
                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AetherFeatures.PlacedFeatures.SKYROOT_GROVE_TREES_PLACED_FEATURE));
    }

    public static Biome skyrootForestBiome() {
        return makeDefaultBiome(new BiomeGenerationSettings.Builder()
                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AetherFeatures.PlacedFeatures.SKYROOT_FOREST_TREES_PLACED_FEATURE));
    }

    public static Biome skyrootThicketBiome() {
        return makeDefaultBiome(new BiomeGenerationSettings.Builder()
                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AetherFeatures.PlacedFeatures.SKYROOT_THICKET_TREES_PLACED_FEATURE));
    }

    public static Biome goldenForestBiome() {
        return makeDefaultBiome(new BiomeGenerationSettings.Builder()
                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AetherFeatures.PlacedFeatures.GOLDEN_FOREST_TREES_PLACED_FEATURE));
    }

    public static Biome makeDefaultBiome(BiomeGenerationSettings.Builder builder) {
        return fullDefinition(
                Biome.Precipitation.NONE,
                Biome.BiomeCategory.NONE,
                0.8F,
                0.0F,
                new BiomeSpecialEffects.Builder()
                        .fogColor(0x93_93_bc)
                        .skyColor(0xc0_c0_ff)
                        .waterColor(0x3f_76_e4)
                        .waterFogColor(0x05_05_33)
                        .grassColorOverride(0xb1_ff_cb)
                        .foliageColorOverride(0xb1_ff_cb)
                        .grassColorModifier(BiomeSpecialEffects.GrassColorModifier.NONE)
                        .backgroundMusic(new Music(AetherSoundEvents.MUSIC_AETHER.get(), 12000, 24000, true))
                        .build(),
                new MobSpawnSettings.Builder()
                        .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(AetherEntityTypes.WHIRLWIND.get(), 9, 2, 2))
                        .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(AetherEntityTypes.EVIL_WHIRLWIND.get(), 1, 2, 2))
                        .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(AetherEntityTypes.COCKATRICE.get(), 100, 4, 4))
                        .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(AetherEntityTypes.ZEPHYR.get(), 50, 1, 1))
                        .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(AetherEntityTypes.BLUE_SWET.get(), 15, 3, 4))
                        .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(AetherEntityTypes.GOLDEN_SWET.get(), 15, 3, 4))
                        .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(AetherEntityTypes.AECHOR_PLANT.get(), 29, 1, 1))
                        .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(AetherEntityTypes.PHYG.get(), 12, 4, 4))
                        .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(AetherEntityTypes.AERBUNNY.get(), 11, 3, 3))
                        .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(AetherEntityTypes.SHEEPUFF.get(), 10, 4, 4))
                        .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(AetherEntityTypes.MOA.get(), 10, 3, 3))
                        .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(AetherEntityTypes.FLYING_COW.get(), 10, 4, 4))
                        .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(AetherEntityTypes.AERWHALE.get(), 2, 1, 1))
                        .build(),
                builder
                        .addFeature(GenerationStep.Decoration.RAW_GENERATION, AetherFeatures.PlacedFeatures.QUICKSOIL_SHELF_PLACED_FEATURE)
                        .addFeature(GenerationStep.Decoration.LAKES, AetherFeatures.PlacedFeatures.WATER_LAKE_PLACED_FEATURE)
                        .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, AetherFeatures.PlacedFeatures.ORE_AETHER_DIRT_PLACED_FEATURE)
                        .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, AetherFeatures.PlacedFeatures.ORE_ICESTONE_PLACED_FEATURE)
                        .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, AetherFeatures.PlacedFeatures.ORE_AMBROSIUM_PLACED_FEATURE)
                        .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, AetherFeatures.PlacedFeatures.ORE_ZANITE_PLACED_FEATURE)
                        .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, AetherFeatures.PlacedFeatures.ORE_GRAVITITE_COMMON_PLACED_FEATURE)
                        .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, AetherFeatures.PlacedFeatures.ORE_GRAVITITE_DENSE_PLACED_FEATURE)
                        .addFeature(GenerationStep.Decoration.FLUID_SPRINGS, AetherFeatures.PlacedFeatures.WATER_SPRING_PLACED_FEATURE)
                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AetherFeatures.PlacedFeatures.GRASS_PATCH_PLACED_FEATURE)
                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AetherFeatures.PlacedFeatures.TALL_GRASS_PATCH_PLACED_FEATURE)
                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AetherFeatures.PlacedFeatures.HOLIDAY_TREE_PLACED_FEATURE)
                        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AetherFeatures.PlacedFeatures.FLOWER_PATCH_PLACED_FEATURE)
                        .addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, AetherFeatures.PlacedFeatures.CRYSTAL_ISLAND_PLACED_FEATURE)
                        .addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, AetherFeatures.PlacedFeatures.COLD_AERCLOUD_PLACED_FEATURE)
                        .addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, AetherFeatures.PlacedFeatures.BLUE_AERCLOUD_PLACED_FEATURE)
                        .addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, AetherFeatures.PlacedFeatures.GOLDEN_AERCLOUD_PLACED_FEATURE)
                        .addFeature(GenerationStep.Decoration.TOP_LAYER_MODIFICATION, AetherFeatures.PlacedFeatures.PINK_AERCLOUD_PLACED_FEATURE)
                        .build(),
                Biome.TemperatureModifier.NONE
        );
    }

    public static Biome fullDefinition(Biome.Precipitation precipitation, Biome.BiomeCategory category, float temperature, float downfall, BiomeSpecialEffects effects, MobSpawnSettings spawnSettings, BiomeGenerationSettings generationSettings, Biome.TemperatureModifier temperatureModifier) {
        return new Biome.BiomeBuilder()
                .precipitation(precipitation)
                .biomeCategory(category)
                .temperature(temperature)
                .downfall(downfall)
                .specialEffects(effects)
                .mobSpawnSettings(spawnSettings)
                .generationSettings(generationSettings)
                .temperatureAdjustment(temperatureModifier)
                .build();
    }
}