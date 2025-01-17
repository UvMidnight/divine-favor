package aurocosh.divinefavor.common.item.common

import aurocosh.divinefavor.common.block.common.ModBlocks
import aurocosh.divinefavor.common.config.common.ConfigSpell
import aurocosh.divinefavor.common.entity.minions.*
import aurocosh.divinefavor.common.item.spell_talismans.*
import aurocosh.divinefavor.common.item.spell_talismans.base.*
import aurocosh.divinefavor.common.item.spell_talismans.build.*
import aurocosh.divinefavor.common.item.spell_talismans.copy.SpellTalismanCopyArea
import aurocosh.divinefavor.common.item.spell_talismans.copy.SpellTalismanCopyBlocks
import aurocosh.divinefavor.common.item.spell_talismans.copy.SpellTalismanCopyCuboid
import aurocosh.divinefavor.common.item.spell_talismans.destroy.SpellTalismanDestroyCuboidRemotely
import aurocosh.divinefavor.common.item.spell_talismans.move.SpellTalismanPullSide
import aurocosh.divinefavor.common.item.spell_talismans.move.SpellTalismanPushSide
import aurocosh.divinefavor.common.item.spell_talismans.operations.SpellTalismanRedo
import aurocosh.divinefavor.common.item.spell_talismans.operations.SpellTalismanUndo
import aurocosh.divinefavor.common.item.spell_talismans.replace.SpellTalismanReplaceBlocks
import aurocosh.divinefavor.common.item.spell_talismans.replace.SpellTalismanReplaceCuboid
import aurocosh.divinefavor.common.item.spell_talismans.replace.SpellTalismanReplaceSide
import aurocosh.divinefavor.common.item.spell_talismans.replace.SpellTalismanReplaceSurface
import aurocosh.divinefavor.common.item.spell_talismans.sense.*
import aurocosh.divinefavor.common.item.spell_talismans.template.SpellTalismanBuildTemplate
import aurocosh.divinefavor.common.item.spell_talismans.template.SpellTalismanCrystallizeMemory
import aurocosh.divinefavor.common.item.spell_talismans.template_serialization.SpellTalismanDeserializeMemory
import aurocosh.divinefavor.common.item.spell_talismans.template_serialization.SpellTalismanSerializeMemory
import aurocosh.divinefavor.common.lib.extensions.isIce
import aurocosh.divinefavor.common.lib.extensions.isLava
import aurocosh.divinefavor.common.lib.extensions.isWater
import aurocosh.divinefavor.common.potions.common.ModPotions
import aurocosh.divinefavor.common.spirit.ModSpirits
import aurocosh.divinefavor.common.util.UtilPredicate
import net.minecraft.block.state.IBlockState
import net.minecraft.init.Blocks
import javax.vecmath.Color3f

object ModSpellTalismans {
    lateinit var armor_of_pacifist: ItemSpellTalisman
    lateinit var arrow_deflection: ItemSpellTalisman
    lateinit var arrow_throw_talisman: ItemSpellTalisman
    lateinit var bind_ice_arrows: ItemSpellTalisman
    lateinit var blade_of_grass: ItemSpellTalisman
    lateinit var blazing_palm: ItemSpellTalisman
    lateinit var blink: ItemSpellTalisman
    lateinit var blood_of_grass: ItemSpellTalisman
    lateinit var bonemeal: ItemSpellTalisman
    lateinit var build_column: ItemSpellTalisman
    lateinit var build_extrusion: ItemSpellTalisman
    lateinit var build_floor: ItemSpellTalisman
    lateinit var build_from_surface: ItemSpellTalisman
    lateinit var build_hollow_sphere: ItemSpellTalisman
    lateinit var build_horizontal_line: ItemSpellTalisman
    lateinit var build_sphere: ItemSpellTalisman
    lateinit var build_square_floor: ItemSpellTalisman
    lateinit var build_square_wall: ItemSpellTalisman
    lateinit var build_wall: ItemSpellTalisman
    lateinit var clock: ItemSpellTalisman
    lateinit var combustion: ItemSpellTalisman
    lateinit var consuming_fury: ItemSpellTalisman
    lateinit var crushing_palm: ItemSpellTalisman
    lateinit var crystalline_road: ItemSpellTalisman
    lateinit var distant_spark: ItemSpellTalisman
    lateinit var earthen_dive: ItemSpellTalisman
    lateinit var empower_axe: ItemSpellTalisman
    lateinit var empower_pickaxe: ItemSpellTalisman
    lateinit var escape_plan: ItemSpellTalisman
    lateinit var ethereal_flash: ItemSpellTalisman
    lateinit var ethereal_light: ItemSpellTalisman
    lateinit var evil_eye: ItemSpellTalisman
    lateinit var extreme_buoyancy: ItemSpellTalisman
    lateinit var fall_negation: ItemSpellTalisman
    lateinit var fins: ItemSpellTalisman
    lateinit var flood: ItemSpellTalisman
    lateinit var focused_fury: ItemSpellTalisman
    lateinit var follow: ItemSpellTalisman
    lateinit var frost_wave: ItemSpellTalisman
    lateinit var gills: ItemSpellTalisman
    lateinit var green_cycle: ItemSpellTalisman
    lateinit var ground_flow: ItemSpellTalisman
    lateinit var grudge: ItemSpellTalisman
    lateinit var harvest: ItemSpellTalisman
    lateinit var heat_wave: ItemSpellTalisman
    lateinit var hellisphere: ItemSpellTalisman
    lateinit var hovering: ItemSpellTalisman
    lateinit var ice_bubble: ItemSpellTalisman
    lateinit var ice_carving: ItemSpellTalisman
    lateinit var ice_surface: ItemSpellTalisman
    lateinit var ignition: ItemSpellTalisman
    lateinit var infernal_touch: ItemSpellTalisman
    lateinit var instant_dive: ItemSpellTalisman
    lateinit var invite_gem: ItemSpellTalisman
    lateinit var invite_pebble: ItemSpellTalisman
    lateinit var lake_thawing: ItemSpellTalisman
    lateinit var miners_focus: ItemSpellTalisman
    lateinit var mist_blade: ItemSpellTalisman
    lateinit var molten_skin: ItemSpellTalisman
    lateinit var nether_surge: ItemSpellTalisman
    lateinit var night_eye: ItemSpellTalisman
    lateinit var obsidian_bubble: ItemSpellTalisman
    lateinit var obsidian_road: ItemSpellTalisman
    lateinit var pearl_crumbs: ItemSpellTalisman
    lateinit var piercing_inferno: ItemSpellTalisman
    lateinit var ping: ItemSpellTalisman
    lateinit var place_block: ItemSpellTalisman
    lateinit var place_torch: ItemSpellTalisman
    lateinit var prismatic_eyes: ItemSpellTalisman
    lateinit var red_pulse: ItemSpellTalisman
    lateinit var red_signal: ItemSpellTalisman
    lateinit var remote_chest: ItemSpellTalisman
    lateinit var replace_blocks: ItemSpellTalisman
    lateinit var replace_cuboid: ItemSpellTalisman
    lateinit var replace_side: ItemSpellTalisman
    lateinit var replace_surface: ItemSpellTalisman
    lateinit var searing_pulse: ItemSpellTalisman
    lateinit var sense_block_approximate: ItemSpellTalisman
    lateinit var sense_block_close: ItemSpellTalisman
    lateinit var sense_block_precise: ItemSpellTalisman
    lateinit var sense_block_vague: ItemSpellTalisman
    lateinit var sense_cave: ItemSpellTalisman
    lateinit var sense_entity_all: ItemSpellTalisman
    lateinit var sense_entity_hostile: ItemSpellTalisman
    lateinit var sense_entity_passive: ItemSpellTalisman
    lateinit var sense_entity_player: ItemSpellTalisman
    lateinit var sense_lava: ItemSpellTalisman
    lateinit var sense_liquid: ItemSpellTalisman
    lateinit var sense_ore_approximate: ItemSpellTalisman
    lateinit var sense_ore_close: ItemSpellTalisman
    lateinit var sense_ore_precise: ItemSpellTalisman
    lateinit var sense_ore_vague: ItemSpellTalisman
    lateinit var sense_water: ItemSpellTalisman
    lateinit var small_fireball_throw: ItemSpellTalisman
    lateinit var snowball_throw: ItemSpellTalisman
    lateinit var spider_might: ItemSpellTalisman
    lateinit var starvation: ItemSpellTalisman
    lateinit var stone_fever: ItemSpellTalisman
    lateinit var stoneball_throw: ItemSpellTalisman
    lateinit var summon_creeper: ItemSpellTalisman
    lateinit var summon_husk: ItemSpellTalisman
    lateinit var summon_skeleton: ItemSpellTalisman
    lateinit var summon_stray: ItemSpellTalisman
    lateinit var summon_zombie: ItemSpellTalisman
    lateinit var surface_blink: ItemSpellTalisman
    lateinit var surface_shift: ItemSpellTalisman
    lateinit var target: ItemSpellTalisman
    lateinit var toadic_jump: ItemSpellTalisman
    lateinit var vitalize: ItemSpellTalisman
    lateinit var wall_slip: ItemSpellTalisman
    lateinit var warp: ItemSpellTalisman
    lateinit var warp_gem: ItemSpellTalisman
    lateinit var warp_pebble: ItemSpellTalisman
    lateinit var wild_sprint: ItemSpellTalisman
    lateinit var wind_step: ItemSpellTalisman
    lateinit var winter_breath: ItemSpellTalisman
    lateinit var wooden_punch: ItemSpellTalisman

    // New fields
    lateinit var create_water: ItemSpellTalisman
    lateinit var crystallize_experience: ItemSpellTalisman
    lateinit var destroy_cuboid_remotely: ItemSpellTalisman
    lateinit var redo: ItemSpellTalisman
    lateinit var build_cylinder: ItemSpellTalisman
    lateinit var undo: ItemSpellTalisman
    lateinit var deserialize_memory: ItemSpellTalisman
    lateinit var serialize_memory: ItemSpellTalisman
    lateinit var copy_cuboid: ItemSpellTalisman
    lateinit var copy_blocks: ItemSpellTalisman
    lateinit var crystalyze_memory: ItemSpellTalisman
    lateinit var build_template: ItemSpellTalisman
    lateinit var copy_area: ItemSpellTalisman
    lateinit var summon_blaze: ItemSpellTalisman
    lateinit var summon_cave_spider: ItemSpellTalisman
    lateinit var summon_spider: ItemSpellTalisman
    lateinit var rotten_might: ItemSpellTalisman
    lateinit var push_side: ItemSpellTalisman
    lateinit var pull_side: ItemSpellTalisman

    fun preInit() {
        // arbow
        arrow_throw_talisman = SpellTalismanArrowThrow("arrow_throw", ModSpirits.arbow, ConfigSpell.arrowThrow.favorCost, SpellOptions.ALL_CAST)

        // blizzrabi
        armor_of_pacifist = SpellTalismanModPotionToggle("armor_of_pacifist", ModSpirits.blizrabi, ConfigSpell.armorOfPacifist.favorCost, ModPotions.armor_of_pacifist)
        bind_ice_arrows = SpellTalismanBindIceArrows("bind_ice_arrows", ModSpirits.blizrabi, ConfigSpell.bindIceArrows.favorCost, SpellOptions.ALL_CAST)
        crystalline_road = SpellTalismanModPotion("crystalline_road", ModSpirits.blizrabi, ConfigSpell.crystallineRoad.favorCost, ModPotions.crystalline_road, ConfigSpell.crystallineRoad.duration)
        extreme_buoyancy = SpellTalismanModPotionToggle("extreme_buoyancy", ModSpirits.blizrabi, ConfigSpell.extremeBuoyancy.favorCost, ModPotions.extreme_buoyancy)
        fins = SpellTalismanModPotion("fins", ModSpirits.blizrabi, ConfigSpell.fins.favorCost, ModPotions.fins, ConfigSpell.fins.duration)
        flood = SpellTalismanFlood("flood", ModSpirits.blizrabi, ConfigSpell.flood.favorCost, SpellOptions.ALL_CAST)
        frost_wave = SpellTalismanFrostWave("frost_wave", ModSpirits.blizrabi, ConfigSpell.frostWave.favorCost, SpellOptions.ALL_CAST)
        gills = SpellTalismanModPotionToggle("gills", ModSpirits.blizrabi, ConfigSpell.gills.favorCost, ModPotions.gills)
        ice_bubble = SpellTalismanReplacmentBubble("ice_bubble", ModSpirits.blizrabi, ConfigSpell.iceBubble, Blocks.AIR, Blocks.ICE, UtilPredicate.or(IBlockState::isWater, IBlockState::isIce))
        ice_surface = SpellTalismanIceSurface("ice_surface", ModSpirits.blizrabi, ConfigSpell.iceSurface.favorCost, SpellOptions.ALL_CAST)
        instant_dive = SpellTalismanModPotionToggle("instant_dive", ModSpirits.blizrabi, ConfigSpell.instantDive.favorCost, ModPotions.instant_dive)
        lake_thawing = SpellTalismanLakeThawing("lake_thawing", ModSpirits.blizrabi, ConfigSpell.lakeThawing.favorCost, SpellOptions.ALL_CAST)
        obsidian_road = SpellTalismanModPotion("obsidian_road", ModSpirits.blizrabi, ConfigSpell.obsidianRoad.favorCost, ModPotions.obsidian_road, ConfigSpell.obsidianRoad.duration)
        snowball_throw = SpellTalismanSnowballThrow("snowball_throw", ModSpirits.blizrabi, ConfigSpell.snowballThrow.favorCost, SpellOptions.ALL_CAST)
        vitalize = SpellTalismanVitalize("vitalize", ModSpirits.blizrabi, ConfigSpell.vitalize.favorCost, SpellOptions.ALL_CAST)
        winter_breath = SpellTalismanWinterBreath("winter_breath", ModSpirits.blizrabi, ConfigSpell.winterBreath.favorCost, SpellOptions.ALL_CAST)
        create_water = SpellTalismanAirReplace("create_water", ModSpirits.blizrabi, ConfigSpell.createWater.favorCost, SpellOptions.ALL_CAST) { Blocks.WATER }
        crystallize_experience = SpellTalismanCrystallizeExperience("crystallize_experience", ModSpirits.blizrabi, ConfigSpell.crystallizeExperience.favorCost, SpellOptions.ALL_CAST)

        // endererer
        blink = SpellTalismanBlink("blink", ModSpirits.endererer, ConfigSpell.blink.favorCost, SpellOptions.ALL_CAST)
        earthen_dive = SpellTalismanEarthenDive("earthen_dive", ModSpirits.endererer, ConfigSpell.earthenDive.favorCost, SpellOptions.USE_CAST)
        escape_plan = SpellTalismanEscapePlan("escape_plan", ModSpirits.endererer, ConfigSpell.escapePlan.favorCost, SpellOptions.ALL_CAST)
        invite_gem = SpellTalismanInviteMarker("invite_gem", ModSpirits.endererer, ConfigSpell.inviteGem.favorCost, SpellOptions.ALL_CAST, ModItems.invite_gem)
        invite_pebble = SpellTalismanInviteMarker("invite_pebble", ModSpirits.endererer, ConfigSpell.invitePebble.favorCost, SpellOptions.ALL_CAST, ModItems.invite_pebble)
        pearl_crumbs = SpellTalismanPearlCrumbs("pearl_crumbs", ModSpirits.endererer, ConfigSpell.pearlCrumbs.favorCost, SpellOptions.ALL_CAST)
        remote_chest = SpellTalismanRemoteChest("remote_chest", ModSpirits.endererer, ConfigSpell.remoteChest.favorCost, SpellOptions.USE_CAST, ModItems.storage_pebble)
        surface_blink = SpellTalismanSurfaceBlink("surface_blink", ModSpirits.endererer, ConfigSpell.surfaceBlink.favorCost, SpellOptions.ALL_CAST_TRACE)
        surface_shift = SpellTalismanSurfaceShift("surface_shift", ModSpirits.endererer, ConfigSpell.surfaceShift.favorCost, SpellOptions.ALL_CAST)
        wall_slip = SpellTalismanWallSlip("wall_slip", ModSpirits.endererer, ConfigSpell.wallSlip.favorCost, SpellOptions.USE_CAST)
        warp = SpellTalismanWarp("warp", ModSpirits.endererer, ConfigSpell.warp.favorCost, SpellOptions.ALL_CAST)
        warp_gem = SpellTalismanWarpMarker("warp_gem", ModSpirits.endererer, ConfigSpell.warpGem.favorCost, SpellOptions.ALL_CAST, ModItems.warp_gem)
        warp_pebble = SpellTalismanWarpMarker("warp_pebble", ModSpirits.endererer, ConfigSpell.warpPebble.favorCost, SpellOptions.ALL_CAST, ModItems.warp_pebble)

        // loon
        evil_eye = SpellTalismanEvilEye("evil_eye", ModSpirits.loon, ConfigSpell.evilEye.favorCost, SpellOptions.ENTITY_CAST)
        follow = SpellTalismanFollow("follow", ModSpirits.loon, ConfigSpell.follow.favorCost, SpellOptions.RIGHT_CAST)
        night_eye = SpellTalismanModPotionToggle("night_eye", ModSpirits.loon, ConfigSpell.nightEye.favorCost, ModPotions.night_eye)
        prismatic_eyes = SpellTalismanModPotionToggle("prismatic_eyes", ModSpirits.loon, ConfigSpell.prismaticEyes.favorCost, ModPotions.prismatic_eyes)
        rotten_might = SpellTalismanModPotionToggle("rotten_might", ModSpirits.loon, ConfigSpell.rottenMight.favorCost, ModPotions.rotten_might, false, 1)
        spider_might = SpellTalismanModPotionToggle("spider_might", ModSpirits.loon, ConfigSpell.spider_might.favorCost, ModPotions.spider_might)
        summon_cave_spider = SpellTalismanSummonMinion("summon_cave_spider", ModSpirits.loon, ConfigSpell.summonCaveSpider.favorCost, SpellOptions.USE_CAST, EntityMinionCaveSpider::class.java)
        summon_creeper = SpellTalismanSummonMinion("summon_creeper", ModSpirits.loon, ConfigSpell.summonCreeper.favorCost, SpellOptions.USE_CAST, EntityMinionCreeper::class.java)
        summon_husk = SpellTalismanSummonMinion("summon_husk", ModSpirits.loon, ConfigSpell.summonHusk.favorCost, SpellOptions.USE_CAST, EntityMinionHusk::class.java)
        summon_skeleton = SpellTalismanSummonMinion("summon_skeleton", ModSpirits.loon, ConfigSpell.summonSkeleton.favorCost, SpellOptions.USE_CAST, EntityMinionSkeleton::class.java)
        summon_spider = SpellTalismanSummonMinion("summon_spider", ModSpirits.loon, ConfigSpell.summonSpider.favorCost, SpellOptions.USE_CAST, EntityMinionSpider::class.java)
        summon_stray = SpellTalismanSummonMinion("summon_stray", ModSpirits.loon, ConfigSpell.summonStray.favorCost, SpellOptions.USE_CAST, EntityMinionStray::class.java)
        summon_zombie = SpellTalismanSummonMinion("summon_zombie", ModSpirits.loon, ConfigSpell.summonZombie.favorCost, SpellOptions.USE_CAST, EntityMinionZombie::class.java)
        target = SpellTalismanTarget("target", ModSpirits.loon, 0, SpellOptions.ENTITY_CAST)

        // materia
        build_column = SpellTalismanBuildColumn("build_column", ModSpirits.materia)
        build_extrusion = SpellTalismanBuildExtrusion("build_extrusion", ModSpirits.materia)
        build_floor = SpellTalismanBuildFloor("build_floor", ModSpirits.materia)
        build_from_surface = SpellTalismanBuildFromSurface("build_from_surface", ModSpirits.materia)
        build_hollow_sphere = SpellTalismanBuildHollowSphere("build_hollow_sphere", ModSpirits.materia)
        build_horizontal_line = SpellTalismanBuildHorizontalLine("build_horizontal_line", ModSpirits.materia)
        build_sphere = SpellTalismanBuildSphere("build_sphere", ModSpirits.materia)
        build_square_floor = SpellTalismanBuildSquareFloor("build_square_floor", ModSpirits.materia)
        build_square_wall = SpellTalismanBuildSquareWall("build_square_wall", ModSpirits.materia)
        build_template = SpellTalismanBuildTemplate("build_template", ModSpirits.materia, SpellOptions.ALL_CAST)
        build_wall = SpellTalismanBuildWall("build_wall", ModSpirits.materia)
        copy_area = SpellTalismanCopyArea("copy_area", ModSpirits.materia, ConfigSpell.copyArea.favorCost)
        copy_blocks = SpellTalismanCopyBlocks("copy_blocks", ModSpirits.materia, ConfigSpell.copyBlocks.favorCost)
        copy_cuboid = SpellTalismanCopyCuboid("copy_cuboid", ModSpirits.materia, ConfigSpell.copyCuboid.favorCost)
        crystalyze_memory = SpellTalismanCrystallizeMemory("crystallize_memory", ModSpirits.materia, ConfigSpell.crystallizeMemory.favorCost, SpellOptions.ALL_CAST)
        deserialize_memory = SpellTalismanDeserializeMemory("deserialize_memory", ModSpirits.materia, ConfigSpell.deserializeMemory.favorCost, SpellOptions.ALL_CAST)
        place_block = SpellTalismanPlaceBlock("place_block", ModSpirits.materia, ConfigSpell.woodenPunch.favorCost, SpellOptions.ALL_CAST_TRACE)
        pull_side = SpellTalismanPullSide("pull_side", ModSpirits.materia, ConfigSpell.pullSide.favorCost, SpellOptions.ALL_CAST_TRACE)
        push_side = SpellTalismanPushSide("push_side", ModSpirits.materia, ConfigSpell.pushSide.favorCost, SpellOptions.ALL_CAST_TRACE)
        replace_blocks = SpellTalismanReplaceBlocks("replace_blocks", ModSpirits.materia)
        replace_cuboid = SpellTalismanReplaceCuboid("replace_cuboid", ModSpirits.materia)
        replace_side = SpellTalismanReplaceSide("replace_side", ModSpirits.materia)
        replace_surface = SpellTalismanReplaceSurface("replace_surface", ModSpirits.materia)
        serialize_memory = SpellTalismanSerializeMemory("serialize_memory", ModSpirits.materia, ConfigSpell.serializeMemory.favorCost, SpellOptions.ALL_CAST)
        redo = SpellTalismanRedo("redo", ModSpirits.materia, ConfigSpell.redo.favorCost, SpellOptions.ALL_CAST)
        build_cylinder = SpellTalismanBuildCylinder("build_cylinder", ModSpirits.materia)
        undo = SpellTalismanUndo("undo", ModSpirits.materia, ConfigSpell.undo.favorCost, SpellOptions.ALL_CAST)

        // neblaze
        blazing_palm = SpellTalismanBlazingPalm("blazing_palm", ModSpirits.neblaze, ConfigSpell.blazingPalm.favorCost, SpellOptions.ALL_CAST)
        combustion = SpellTalismanCombustion("combustion", ModSpirits.neblaze, ConfigSpell.combustion.favorCost, SpellOptions.USE_CAST)
        distant_spark = SpellTalismanIgnition("distant_spark", ModSpirits.neblaze, ConfigSpell.distantSpark.favorCost, SpellOptions.ALL_CAST_TRACE)
        heat_wave = SpellTalismanHeatWave("heat_wave", ModSpirits.neblaze, ConfigSpell.heatWave.favorCost, SpellOptions.ALL_CAST)
        hellisphere = SpellTalismanHellisphere("hellisphere", ModSpirits.neblaze, ConfigSpell.hellisphere.favorCost, SpellOptions.USE_CAST)
        ignition = SpellTalismanIgnition("ignition", ModSpirits.neblaze, ConfigSpell.ignition.favorCost, SpellOptions.USE_CAST)
        infernal_touch = SpellTalismanInfernalTouch("infernal_touch", ModSpirits.neblaze, 1, SpellOptions.USE_CAST)
        molten_skin = SpellTalismanMoltenSkin("molten_skin", ModSpirits.neblaze, ConfigSpell.moltenSkin.favorCost, SpellOptions.ALL_CAST)
        nether_surge = SpellTalismanNetherSurge("nether_surge", ModSpirits.neblaze, ConfigSpell.netherSurge.favorCost, SpellOptions.USE_CAST)
        obsidian_bubble = SpellTalismanReplacmentBubble("obsidian_bubble", ModSpirits.blizrabi, ConfigSpell.obsidianBubble, Blocks.AIR, Blocks.OBSIDIAN, UtilPredicate.or(IBlockState::isLava, { state: IBlockState -> state.block == Blocks.OBSIDIAN }))
        piercing_inferno = SpellTalismanPiercingInferno("piercing_inferno", ModSpirits.neblaze, ConfigSpell.piercingInferno.favorCost, SpellOptions.USE_CAST)
        searing_pulse = SpellTalismanSearingPulse("searing_pulse", ModSpirits.neblaze, ConfigSpell.searingPulse.favorCost, SpellOptions.USE_CAST)
        small_fireball_throw = SpellTalismanSmallFireballThrow("small_fireball_throw", ModSpirits.neblaze, ConfigSpell.smallFireballThrow.favorCost, SpellOptions.ALL_CAST)
        summon_blaze = SpellTalismanSummonMinion("summon_blaze", ModSpirits.neblaze, ConfigSpell.summonBlaze.favorCost, SpellOptions.USE_CAST, EntityMinionBlaze::class.java)
        destroy_cuboid_remotely = SpellTalismanDestroyCuboidRemotely("destroy_cuboid_remotely", ModSpirits.neblaze)

        // redwind
        arrow_deflection = SpellTalismanModPotion("arrow_deflection", ModSpirits.redwind, ConfigSpell.arrowDeflection.favorCost, ModPotions.arrow_deflection, ConfigSpell.arrowDeflection.duration)
        clock = SpellTalismanClock("clock", ModSpirits.redwind, ConfigSpell.clock.favorCost, SpellOptions.ALL_CAST)
        ethereal_flash = SpellTalismanAirReplace("ethereal_flash", ModSpirits.redwind, ConfigSpell.etherealFlash.favorCost, SpellOptions.ALL_CAST_TRACE) { ModBlocks.ethereal_flash }
        ethereal_light = SpellTalismanAirReplace("ethereal_light", ModSpirits.redwind, ConfigSpell.etherealLight.favorCost, SpellOptions.ALL_CAST_TRACE) { ModBlocks.ethereal_light }
        fall_negation = SpellTalismanModPotionCharge("fall_negation", ModSpirits.redwind, ConfigSpell.fallNegation.favorCost, ModPotions.fall_negation, ConfigSpell.fallNegation.charges)
        ground_flow = SpellTalismanModPotionToggle("ground_flow", ModSpirits.redwind, ConfigSpell.groundFlow.favorCost, ModPotions.ground_flow)
        hovering = SpellTalismanModPotionToggle("hovering", ModSpirits.redwind, ConfigSpell.groundFlow.favorCost, ModPotions.hovering)
        ping = SpellTalismanPing("ping", ModSpirits.redwind, ConfigSpell.ping.favorCost, SpellOptions.TRACE_ONLY_CAST)
        red_pulse = SpellTalismanAirReplace("red_pulse", ModSpirits.redwind, ConfigSpell.redPulse.favorCost, SpellOptions.ALL_CAST_TRACE) { ModBlocks.red_pulse }
        red_signal = SpellTalismanAirReplace("red_signal", ModSpirits.redwind, ConfigSpell.redSignal.favorCost, SpellOptions.ALL_CAST_TRACE) { ModBlocks.red_signal }
        toadic_jump = SpellTalismanModPotionToggle("toadic_jump", ModSpirits.redwind, ConfigSpell.toadicJump.favorCost, ModPotions.toadic_jump, true)
        wild_sprint = SpellTalismanModPotion("wild_sprint", ModSpirits.redwind, ConfigSpell.wildSprint.favorCost, ModPotions.wild_charge, ConfigSpell.wildSprint.activationDelay)
        wind_step = SpellTalismanWindStep("wind_step", ModSpirits.redwind, ConfigSpell.windStep.favorCost, SpellOptions.ALL_CAST)
        place_torch = SpellTalismanPlaceTorch("place_torch", ModSpirits.redwind, ConfigSpell.placeTorch.favorCost, SpellOptions.TRACE_ONLY_CAST)

        // romol
        crushing_palm = SpellTalismanModPotionToggle("crushing_palm", ModSpirits.romol, ConfigSpell.crushingPalm.favorCost, ModPotions.crushing_palm)
        empower_axe = SpellTalismanModPotion("empower_axe", ModSpirits.romol, ConfigSpell.empowerAxe.favorCost, ModPotions.empower_axe, ConfigSpell.empowerAxe.duration)
        empower_pickaxe = SpellTalismanModPotion("empower_pickaxe", ModSpirits.romol, ConfigSpell.empowerPickaxe.favorCost, ModPotions.empower_pickaxe, ConfigSpell.empowerPickaxe.duration)
        green_cycle = SpellTalismanGreenCycle("green_cycle", ModSpirits.romol, ConfigSpell.greenCycle.favorCost, SpellOptions.ALL_CAST)
        harvest = SpellTalismanHarvest("harvest", ModSpirits.romol, ConfigSpell.harvest.favorCost, SpellOptions.ALL_CAST)
        miners_focus = SpellTalismanMinersFocus("miners_focus", ModSpirits.romol, ConfigSpell.minersFocus.favorCost, SpellOptions.ALL_CAST)
        sense_block_approximate = SpellTalismanSenseInSphereHeld("sense_block_approximate", ModSpirits.romol, SpellOptions.RIGHT_CAST, Color3f(0.7f, 0.7f, 0f), ConfigSpell.senseBlockApproximate)
        sense_block_close = SpellTalismanSenseInSphereHeld("sense_block_close", ModSpirits.romol, SpellOptions.RIGHT_CAST, Color3f(0f, 0f, 0.7f), ConfigSpell.senseBlockClose)
        sense_block_precise = SpellTalismanSenseInSphereHeld("sense_block_precise", ModSpirits.romol, SpellOptions.RIGHT_CAST, Color3f(0.7f, 0f, 0f), ConfigSpell.senseBlockPrecise)
        sense_block_vague = SpellTalismanSenseInSphereHeld("sense_block_vague", ModSpirits.romol, SpellOptions.RIGHT_CAST, Color3f(0f, 0.7f, 0f), ConfigSpell.senseBlockVague)
        sense_cave = SpellTalismanSenseFloodFill("sense_cave", ModSpirits.romol, SpellOptions.USE_CAST, Color3f(0f, 0.2f, 0.9f), ConfigSpell.senseWater, SenseBlockPredicate.AIR, 500, 32)
        sense_lava = SpellTalismanSenseInSphereType("sense_lava", ModSpirits.romol, SpellOptions.RIGHT_CAST, Color3f(0.9f, 0.2f, 0f), ConfigSpell.senseLava, SenseBlockPredicate.LAVA)
        sense_liquid = SpellTalismanSenseInSphereType("sense_liquid", ModSpirits.romol, SpellOptions.RIGHT_CAST, Color3f(0.7f, 0.2f, 0.7f), ConfigSpell.senseLiquid, SenseBlockPredicate.LIQUID)
        sense_ore_approximate = SpellTalismanSenseInSphereType("sense_ore_approximate", ModSpirits.romol, SpellOptions.RIGHT_CAST, Color3f(0.7f, 0.7f, 0f), ConfigSpell.senseOreApproximate, SenseBlockPredicate.ORE)
        sense_ore_close = SpellTalismanSenseInSphereType("sense_ore_close", ModSpirits.romol, SpellOptions.RIGHT_CAST, Color3f(0f, 0f, 0.7f), ConfigSpell.senseOreClose, SenseBlockPredicate.ORE)
        sense_ore_precise = SpellTalismanSenseInSphereType("sense_ore_precise", ModSpirits.romol, SpellOptions.RIGHT_CAST, Color3f(0.7f, 0f, 0f), ConfigSpell.senseOrePrecise, SenseBlockPredicate.ORE)
        sense_ore_vague = SpellTalismanSenseInSphereType("sense_ore_vague", ModSpirits.romol, SpellOptions.RIGHT_CAST, Color3f(0f, 0.7f, 0f), ConfigSpell.senseOreVague, SenseBlockPredicate.ORE)
        sense_water = SpellTalismanSenseInSphereType("sense_water", ModSpirits.romol, SpellOptions.RIGHT_CAST, Color3f(0f, 0.2f, 0.9f), ConfigSpell.senseWater, SenseBlockPredicate.WATER)
        stone_fever = SpellTalismanModPotion("stone_fever", ModSpirits.romol, ConfigSpell.stoneFever.favorCost, ModPotions.stone_fever, ConfigSpell.stoneFever.duration)
        stoneball_throw = SpellTalismanStoneballThrow("stoneball_throw", ModSpirits.romol, ConfigSpell.stoneballThrow.favorCost, SpellOptions.ALL_CAST)
        wooden_punch = SpellTalismanModPotionToggle("wooden_punch", ModSpirits.romol, ConfigSpell.woodenPunch.favorCost, ModPotions.wooden_punch)

        // squarefury
        consuming_fury = SpellTalismanModPotion("consuming_fury", ModSpirits.squarefury, ConfigSpell.consumingFury.favorCost, ModPotions.consuming_fury, ConfigSpell.consumingFury.duration)
        focused_fury = SpellTalismanModPotion("focused_fury", ModSpirits.squarefury, ConfigSpell.focusedFury.favorCost, ModPotions.focused_fury, ConfigSpell.focusedFury.duration)
        grudge = SpellTalismanGrudge("grudge", ModSpirits.squarefury, ConfigSpell.grudge.favorCost, SpellOptions.ALL_CAST)
        mist_blade = SpellTalismanModPotionToggle("mist_blade", ModSpirits.squarefury, ConfigSpell.mistBlade.favorCost, ModPotions.mist_blade)
        sense_entity_passive = SpellTalismanSenseEntities("sense_entity_passive", ModSpirits.squarefury, SpellOptions.RIGHT_CAST, Color3f(0f, 0.2f, 0.9f), ConfigSpell.senseEntityPassive, SenseEntitiesPredicate.PASSIVE)
        sense_entity_hostile = SpellTalismanSenseEntities("sense_entity_hostile", ModSpirits.squarefury, SpellOptions.RIGHT_CAST, Color3f(0.9f, 0f, 0.2f), ConfigSpell.senseEntityHostile, SenseEntitiesPredicate.HOSTILE)
        sense_entity_player = SpellTalismanSenseEntities("sense_entity_player", ModSpirits.squarefury, SpellOptions.RIGHT_CAST, Color3f(0f, 0.9f, 0.2f), ConfigSpell.senseEntityPlayer, SenseEntitiesPredicate.PLAYERS)
        sense_entity_all = SpellTalismanSenseEntities("sense_entity_all", ModSpirits.squarefury, SpellOptions.RIGHT_CAST, Color3f(0.7f, 0.7f, 0f), ConfigSpell.senseEntityAll, SenseEntitiesPredicate.ALL)

        // timber
        blade_of_grass = SpellTalismanBladeOfGrass("blade_of_grass", ModSpirits.timber, ConfigSpell.bladeOfGrass.favorCost, SpellOptions.ALL_CAST)
        blood_of_grass = SpellTalismanBloodOfGrass("blood_of_grass", ModSpirits.timber, ConfigSpell.bloodOfGrass.favorCost, SpellOptions.ALL_CAST)
        bonemeal = SpellTalismanBonemeal("bonemeal", ModSpirits.timber, ConfigSpell.bonemeal.favorCost, SpellOptions.USE_CAST)
        starvation = SpellTalismanModPotion("starvation", ModSpirits.timber, ConfigSpell.starvation.favorCost, ModPotions.starvation, ConfigSpell.starvation.duration)

        // New instances
    }

    fun init() {}
}