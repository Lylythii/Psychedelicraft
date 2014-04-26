/*
 *  Copyright (c) 2014, Lukas Tenbrink.
 *  * http://lukas.axxim.net
 */

// Date: 29.07.2013 22:50:40
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package net.ivorius.psychedelicraft.client.rendering;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPeyote1 extends ModelBase
{
    //fields
    ModelRenderer peyote1;
    ModelRenderer peyote2;
    ModelRenderer peyote3;
    ModelRenderer peyote4;

    public ModelPeyote1()
    {
        textureWidth = 64;
        textureHeight = 32;

        peyote1 = new ModelRenderer(this, 0, 0);
        peyote1.addBox(-2F, -2F, -2F, 3, 3, 3);
        peyote1.setRotationPoint(0F, 24F, 0F);
        peyote1.setTextureSize(64, 32);
        peyote1.mirror = true;
        setRotation(peyote1, 0.0371786F, 0.1487144F, 0F);
        peyote2 = new ModelRenderer(this, 0, 7);
        peyote2.addBox(0F, -1F, -1.5F, 2, 2, 2);
        peyote2.setRotationPoint(1F, 24F, 0F);
        peyote2.setTextureSize(64, 32);
        peyote2.mirror = true;
        setRotation(peyote2, 0.1858931F, -0.2230717F, 0F);
        peyote3 = new ModelRenderer(this, 0, 12);
        peyote3.addBox(0F, -1.5F, 0F, 2, 2, 2);
        peyote3.setRotationPoint(0F, 24F, 1F);
        peyote3.setTextureSize(64, 32);
        peyote3.mirror = true;
        setRotation(peyote3, -0.2230717F, 0.3346075F, 0F);
        peyote4 = new ModelRenderer(this, 0, 17);
        peyote4.addBox(1F, 0F, 1F, 1, 1, 1);
        peyote4.setRotationPoint(0F, 23F, 0F);
        peyote4.setTextureSize(64, 32);
        peyote4.mirror = true;
        setRotation(peyote4, 0F, -0.8551081F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        peyote1.render(f5);
        peyote2.render(f5);
        peyote3.render(f5);
        peyote4.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
