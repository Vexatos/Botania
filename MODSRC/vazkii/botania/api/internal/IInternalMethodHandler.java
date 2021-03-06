/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [Jan 14, 2014, 6:34:34 PM (GMT)]
 */
package vazkii.botania.api.internal;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.Icon;
import vazkii.botania.api.lexicon.LexiconPage;
import vazkii.botania.api.recipe.RecipeManaInfusion;
import vazkii.botania.api.recipe.RecipePetals;
import vazkii.botania.api.recipe.RecipeRuneAltar;

/**
 * Any methods that refer to internal methods in Botania are here.
 * This is defaulted to a dummy handler, whose methods do nothing.
 * This handler is set to a proper one on PreInit. Make sure to
 * make your mod load after Botania if you have any intention of
 * doing anythign with this on PreInit.
 */
public interface IInternalMethodHandler {

	public LexiconPage textPage(String key);

	public LexiconPage imagePage(String key, String resource);

	public LexiconPage craftingRecipesPage(String key, List<IRecipe> recipes);

	public LexiconPage craftingRecipePage(String key, IRecipe recipe);

	public LexiconPage petalRecipesPage(String key, List<RecipePetals> recipes);

	public LexiconPage petalRecipePage(String key, RecipePetals recipe);

	public LexiconPage runeRecipesPage(String key, List<RecipeRuneAltar> recipes);

	public LexiconPage runeRecipePage(String key, RecipeRuneAltar recipe);

	public LexiconPage manaInfusionRecipesPage(String key, List<RecipeManaInfusion> recipes);

	public LexiconPage manaInfusionRecipePage(String key, RecipeManaInfusion recipe);

	public ItemStack getSubTileAsStack(String subTile);

	public Icon getSubTileIconForName(String name);

}
