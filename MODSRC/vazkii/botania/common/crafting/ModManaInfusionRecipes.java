/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [Jan 30, 2014, 6:10:48 PM (GMT)]
 */
package vazkii.botania.common.crafting;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.recipe.RecipeManaInfusion;
import vazkii.botania.common.item.ModItems;
import vazkii.botania.common.lib.LibOreDict;

public final class ModManaInfusionRecipes {

	public static List<RecipeManaInfusion> manaPetalRecipes;
	public static RecipeManaInfusion manasteelRecipe;
	public static RecipeManaInfusion manaPearlRecipe;
	public static RecipeManaInfusion manaDiamondRecipe;
	
	public static void init() {
		manaPetalRecipes = new ArrayList();
		for(int i = 0; i < 16; i++)
			manaPetalRecipes.add(BotaniaAPI.registerManaInfusionRecipe(new ItemStack(ModItems.manaPetal, 1, i), LibOreDict.PETAL[i], 1000));

		manasteelRecipe = BotaniaAPI.registerManaInfusionRecipe(new ItemStack(ModItems.manaResource, 1, 0), "ingotIron", 5000);
		manaPearlRecipe = BotaniaAPI.registerManaInfusionRecipe(new ItemStack(ModItems.manaResource, 1, 1), new ItemStack(Item.enderPearl), 10000);
		manaDiamondRecipe = BotaniaAPI.registerManaInfusionRecipe(new ItemStack(ModItems.manaResource, 1, 2), "gemDiamond", 25000);

	}

}
