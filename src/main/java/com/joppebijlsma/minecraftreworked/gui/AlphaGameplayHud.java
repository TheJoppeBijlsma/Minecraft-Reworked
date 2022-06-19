package com.joppebijlsma.minecraftreworked.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.util.Identifier;

public class AlphaGameplayHud {

    public static void AlphaGameplayHudEvent() {
        HudRenderCallback.EVENT.register((matrixStack, tickDelta) -> {
            Identifier TEXTURE = new Identifier("minecraftreworked:textures/gui/alpha_gameplay.png");

            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.setShaderColor(1.0f,1.0f,1.0f,1.0f);
            RenderSystem.setShaderTexture(0, TEXTURE);

            //i = x and j = y
            int i = 5;
            int j = 5;

            DrawableHelper.drawTexture(matrixStack, i, j, 1, 0, 0, 64, 36,64, 36);
        });
    }
}
