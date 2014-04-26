/*
 *  Copyright (c) 2014, Lukas Tenbrink.
 *  * http://lukas.axxim.net
 */

package net.ivorius.psychedelicraft.client.rendering;

import net.ivorius.psychedelicraft.entities.DrugHelper;
import net.ivorius.psychedelicraft.ivToolkit.IvDepthBuffer;
import net.ivorius.psychedelicraft.ivToolkit.IvShaderInstance3D;
import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.Logger;

/**
 * Created by lukas on 26.02.14.
 */
public class ShaderShadows extends IvShaderInstance3D implements ShaderWorld
{
    public IvDepthBuffer depthBuffer;

    public ShaderShadows(Logger logger)
    {
        super(logger);

        Minecraft mc = Minecraft.getMinecraft();

        int pixels = getShadowPixels();
        depthBuffer = new IvDepthBuffer(pixels, pixels, logger);
    }

    @Override
    public void trySettingUpShader(String vertexShaderFile, String fragmentShaderFile)
    {
        super.trySettingUpShader(vertexShaderFile, fragmentShaderFile);

        depthBuffer.allocate();
    }

    @Override
    public boolean activate(float partialTicks, float ticks)
    {
        if (depthBuffer.isAllocated() && useShader())
        {
            int pixels = getShadowPixels();
            depthBuffer.setSize(pixels, pixels);

            Minecraft mc = Minecraft.getMinecraft();
            DrugHelper drugHelper = DrugHelper.getDrugHelper(mc.thePlayer);

            setUniformFloats("ticks", ticks);
            setUniformInts("worldTime", (int) mc.theWorld.getWorldTime());

            setTexture2DEnabled(true);
            setUniformFloats("playerPos", (float) mc.thePlayer.posX, (float) mc.thePlayer.posY, (float) mc.thePlayer.posZ);
            setUniformFloats("depthMultiplier", 1.0f);
            setUniformFloats("pixelSize", 1.0f / depthBuffer.getTextureWidth(), 1.0f / depthBuffer.getTextureHeight());
            setUniformInts("useScreenTexCoords", 0);
            setOverrideColor(null);

            depthBuffer.setParentFB(mc.getFramebuffer() != null ? mc.getFramebuffer().framebufferObject : 0);
            depthBuffer.bind();
            depthBuffer.bindTextureForDestination();

            return true;
        }

        return false;
    }

    @Override
    public void deactivate()
    {
        if (isShaderActive())
        {
            depthBuffer.unbind();
        }

        stopUsingShader();
    }

    @Override
    public void setTexture2DEnabled(boolean enabled)
    {
        setUniformInts("texture2DEnabled", enabled ? 1 : 0);
    }

    @Override
    public void setLightmapEnabled(boolean enabled)
    {

    }

    @Override
    public void setBlendFunc(int func)
    {

    }

    @Override
    public void setOverrideColor(float[] color)
    {
        if (color != null)
        {
            setUniformFloats("overrideColor", color);
        }
        else
        {
            setUniformFloats("overrideColor", 1F, 1F, 1F, 1F);
        }
    }

    @Override
    public void setGLLightEnabled(boolean enabled)
    {

    }

    @Override
    public void setGLLight(int number, float x, float y, float z, float strength, float specular)
    {

    }

    @Override
    public void setGLLightAmbient(float strength)
    {

    }

    @Override
    public void setFogMode(int mode)
    {

    }

    @Override
    public void setFogEnabled(boolean enabled)
    {

    }

    @Override
    public void setDepthMultiplier(float depthMultiplier)
    {

    }

    @Override
    public void setUseScreenTexCoords(boolean enabled)
    {

    }

    @Override
    public void setPixelSize(float pixelWidth, float pixelHeight)
    {

    }

    @Override
    public void setProjectShadows(boolean projectShadows)
    {
        // Do something? :/
    }

    public static int getShadowPixels()
    {
        return Minecraft.getMinecraft().gameSettings.renderDistanceChunks * DrugShaderHelper.shadowPixelsPerChunk;
    }
}
