package minefantasy.mfr.init;

import minefantasy.mfr.item.AdvancedFuelHandlerMF;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;



public class OreDictListMFR {

	public static void registerOreDictEntries() {
		OreDictionary.registerOre("copper_ore", BlockListMFR.COPPER_ORE);
		OreDictionary.registerOre("tin_ore", BlockListMFR.TIN_ORE);
		OreDictionary.registerOre("silver_ore", BlockListMFR.SILVER_ORE);
		OreDictionary.registerOre("mythic_ore", BlockListMFR.MYTHIC_ORE);
		OreDictionary.registerOre("kaolinite_ore", BlockListMFR.KAOLINITE_ORE);
		OreDictionary.registerOre("borax_ore", BlockListMFR.NITRE_ORE);
		OreDictionary.registerOre("sulfur_ore", BlockListMFR.SULFUR_ORE);
		OreDictionary.registerOre("borax_ore", BlockListMFR.BORAX_ORE);
		OreDictionary.registerOre("tungsten_ore", BlockListMFR.TUNGSTEN_ORE);
		OreDictionary.registerOre("clay_ore", BlockListMFR.CLAY_ORE);
		OreDictionary.registerOre("coal_rich_ore", BlockListMFR.COAL_RICH_ORE);

		OreDictionary.registerOre("cobblestone", new ItemStack(BlockListMFR.LIMESTONE, 1, 1));
		OreDictionary.registerOre("stone", new ItemStack(BlockListMFR.LIMESTONE, 1, 0));
		OreDictionary.registerOre("limestone", new ItemStack(BlockListMFR.LIMESTONE, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("cobblestone", new ItemStack(BlockListMFR.COBBLE_BRICK, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("cobblestone", new ItemStack(BlockListMFR.COBBLE_PAVEMENT, 1, OreDictionary.WILDCARD_VALUE));

		OreDictionary.registerOre("block_glass", new ItemStack(BlockListMFR.WINDOW, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("block_glass", new ItemStack(BlockListMFR.FRAMED_GLASS, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("pane_glass", new ItemStack(BlockListMFR.WINDOW_PANE, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("pane_glass", new ItemStack(BlockListMFR.FRAMED_GLASS_PANE, 1, OreDictionary.WILDCARD_VALUE));

		OreDictionary.registerOre("planks_oak_wood", new ItemStack(Blocks.PLANKS, 1, 0));
		OreDictionary.registerOre("planks_spruce_wood", new ItemStack(Blocks.PLANKS, 1, 1));
		OreDictionary.registerOre("planks_birch_wood", new ItemStack(Blocks.PLANKS, 1, 2));
		OreDictionary.registerOre("planks_jungle_wood", new ItemStack(Blocks.PLANKS, 1, 3));
		OreDictionary.registerOre("planks_acacia_wood", new ItemStack(Blocks.PLANKS, 1, 4));
		OreDictionary.registerOre("planks_dark_oak_wood", new ItemStack(Blocks.PLANKS, 1, 5));

		OreDictionary.registerOre("planks_ironbark_wood", BlockListMFR.IRONBARK_PLANKS);
		OreDictionary.registerOre("planks_ebony_wood", BlockListMFR.EBONY_PLANKS);
		OreDictionary.registerOre("planks_yew_wood", BlockListMFR.YEW_PLANKS);
		OreDictionary.registerOre("planks_ironbark_wood", BlockListMFR.IRONBARK_PLANKS);
		OreDictionary.registerOre("planks_ebony_wood", BlockListMFR.EBONY_PLANKS);
		OreDictionary.registerOre("planks_yew_wood", BlockListMFR.YEW_PLANKS);

		for (ItemStack plank : OreDictionary.getOres("plank_wood")) {
			if (plank.getItem().getClass().getName().contains("block_wooden_device")) {
				if (plank.getUnlocalizedName().equalsIgnoreCase("tile.blockWoodenDevice.6")) {
					OreDictionary.registerOre("planks_greatwood_wood", plank);
				}
				if (plank.getUnlocalizedName().equalsIgnoreCase("tile.blockWoodenDevice.7")) {
					OreDictionary.registerOre("planks_silverwood_wood", plank);
				}
			}
		}

		OreDictionary.registerOre("copper_ingot", ComponentListMFR.COPPER_INGOT);
		OreDictionary.registerOre("tin_ingot", ComponentListMFR.TIN_INGOT);
		OreDictionary.registerOre("bronze_ingot", ComponentListMFR.BRONZE_INGOT);
		OreDictionary.registerOre("pig_iron_ingot", ComponentListMFR.PIG_IRON_INGOT);
		OreDictionary.registerOre("steel_ingot", ComponentListMFR.STEEL_INGOT);
		OreDictionary.registerOre("encrusted_ingot", ComponentListMFR.ENCRUSTED_INGOT);
		OreDictionary.registerOre("black_steel_ingot", ComponentListMFR.BLACK_STEEL_INGOT);
		OreDictionary.registerOre("silver_ingot", ComponentListMFR.SILVER_INGOT);
		OreDictionary.registerOre("red_steel_ingot", ComponentListMFR.RED_STEEL_INGOT);
		OreDictionary.registerOre("blue_steel_ingot", ComponentListMFR.BLUE_STEEL_INGOT);
		OreDictionary.registerOre("adamantium_ingot", ComponentListMFR.ADAMANTIUM_INGOT);
		OreDictionary.registerOre("mithril_ingot", ComponentListMFR.MITHRIL_INGOT);
		OreDictionary.registerOre("ignotumite_ingot", ComponentListMFR.IGNOTUMITE_INGOT);
		OreDictionary.registerOre("mithium_ingot", ComponentListMFR.MITHIUM_INGOT);
		OreDictionary.registerOre("ender_ingot", ComponentListMFR.ENDER_INGOT);
		OreDictionary.registerOre("tungsten_ingot", ComponentListMFR.TUNGSTEN_INGOT);
		OreDictionary.registerOre("obsidian_ingot", ComponentListMFR.OBSIDIAN_INGOT);
		OreDictionary.registerOre("composite_alloy_ingot", ComponentListMFR.COMPOSITE_ALLOY_INGOT);
		OreDictionary.registerOre("iron_ingot", Items.IRON_INGOT);
		OreDictionary.registerOre("gold_ingot", Items.GOLD_INGOT);

		String meatRaw = "raw_meat";
		String cookedMeat = "cooked_meat";
		OreDictionary.registerOre(cookedMeat, Items.COOKED_BEEF);
		OreDictionary.registerOre(cookedMeat, Items.COOKED_CHICKEN);
		OreDictionary.registerOre(cookedMeat, Items.COOKED_PORKCHOP);
		OreDictionary.registerOre(cookedMeat, FoodListMFR.WOLF_COOKED);
		OreDictionary.registerOre(cookedMeat, FoodListMFR.HORSE_COOKED);
		OreDictionary.registerOre(cookedMeat, Items.COOKED_FISH);
		OreDictionary.registerOre(cookedMeat, new ItemStack(Items.COOKED_FISH, 1, 1));
		addOreD("listAllporkcooked", cookedMeat);
		addOreD("listAllmuttoncooked", cookedMeat);
		addOreD("listAllbeefcooked", cookedMeat);
		addOreD("listAllchickencooked", cookedMeat);
		addOreD("listAllfishcooked", cookedMeat);

		OreDictionary.registerOre(meatRaw, FoodListMFR.GUTS);
		OreDictionary.registerOre(meatRaw, Items.BEEF);
		OreDictionary.registerOre(meatRaw, Items.CHICKEN);
		OreDictionary.registerOre(meatRaw, Items.PORKCHOP);
		OreDictionary.registerOre(meatRaw, FoodListMFR.WOLF_RAW);
		OreDictionary.registerOre(meatRaw, FoodListMFR.HORSE_RAW);
		OreDictionary.registerOre(meatRaw, Items.FISH);
		OreDictionary.registerOre(meatRaw, new ItemStack(Items.FISH, 1, 1));
		addOreD("listAllporkraw", meatRaw);
		addOreD("listAllmuttonraw", meatRaw);
		addOreD("listAllbeefraw", meatRaw);
		addOreD("listAllchickenraw", meatRaw);
		addOreD("listAllfishraw", meatRaw);

		AdvancedFuelHandlerMF.registerItems();

	}

	private static void addOreD(String list, String mfList) {
		for (ItemStack stack : OreDictionary.getOres(list)) {
			OreDictionary.registerOre(mfList, stack);
		}
	}
}
