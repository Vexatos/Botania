/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [Feb 18, 2014, 10:18:36 PM (GMT)]
 */
package vazkii.botania.client.render.tile;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import vazkii.botania.client.lib.LibResources;
import vazkii.botania.client.model.ModelPylon;

public class RenderTilePylon extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(LibResources.MODEL_PYLON);
	ModelPylon model = new ModelPylon();

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d0, double d1, double d2, float pticks) {
		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		int worldTime = (int) (tileentity.worldObj == null ? 0 : tileentity.worldObj.getTotalWorldTime());
		
		if(tileentity != null)
			worldTime += new Random(tileentity.xCoord ^ tileentity.yCoord ^ tileentity.zCoord).nextInt(360);
		
		GL11.glTranslated(d0 + 0.5, d1 + 2.2, d2 + 0.5);
		GL11.glScalef(1F, -1.5F, -1F);
		
		int light = 15728880;
		int lightmapX = light % 65536;
		int lightmapY = light / 65536;
		
		GL11.glPushMatrix();
		GL11.glRotatef(worldTime * 1.5F, 0F, 1F, 0F);
		model.renderRing();
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslated(0D, Math.sin((double) worldTime / 20D) / 17.5, 0D);
		GL11.glRotatef(-worldTime, 0F, 1F, 0F);
		GL11.glDisable(GL11.GL_CULL_FACE);
		model.renderCrystal();

		GL11.glColor4f(1F, 1F, 1F, 1F);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, lightmapX, lightmapY);
		double alpha = Math.sin((double) worldTime / 20D) / 2D + 0.5;
		GL11.glColor4d(1D, 1D, 1D, alpha + 0.183F);
		GL11.glScalef(1.1F, 1.1F, 1.1F);
		GL11.glTranslatef(0F, -0.09F, 0F);
		model.renderCrystal();

		GL11.glPopMatrix();
		
		GL11.glScalef(1F, -1.5F, -1F);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
	}


}