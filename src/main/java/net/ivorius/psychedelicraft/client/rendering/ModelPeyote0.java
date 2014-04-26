/*
 *  Copyright (c) 2014, Lukas Tenbrink.
 *  * http://lukas.axxim.net
 */

// Date: 29.07.2013 22:45:09
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package net.ivorius.psychedelicraft.client.rendering;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPeyote0 extends ModelBase
{
    //fields
    ModelRenderer shape1;

    public ModelPeyote0()
    {
        textureWidth = 32;
        textureHeight = 32;

        shape1 = new ModelRenderer(this, 0, 0);
        shape1.addBox(-1F, -1.5F, -1F, 2, 2, 2);
        shape1.setRotationPoint(0F, 24F, 0F);
        shape1.setTextureSize(32, 32);
        shape1.mirror = true;
        setRotation(shape1, 0.0371786F, 0.2230717F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        shape1.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
