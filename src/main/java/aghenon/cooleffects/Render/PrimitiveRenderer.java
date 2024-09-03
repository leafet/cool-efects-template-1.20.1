package aghenon.cooleffects.Render;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderContext;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.client.render.*;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;

public class PrimitiveRenderer {

    public static void DrawCube(float centerX, float centerY, float centerZ, float sideLen, int argbColor) {

        WorldRenderEvents.LAST.register(drawContext ->{

            float[] i1 = {centerX + sideLen / 2, centerY + sideLen / 2, centerZ - sideLen / 2};
            float[] i2 = {centerX - sideLen / 2, centerY + sideLen / 2, centerZ - sideLen / 2};
            float[] i3 = {centerX + sideLen / 2, centerY + sideLen / 2, centerZ + sideLen / 2};
            float[] i4 = {centerX - sideLen / 2, centerY + sideLen / 2, centerZ + sideLen / 2};
            float[] i5 = {centerX + sideLen / 2, centerY - sideLen / 2, centerZ - sideLen / 2};
            float[] i6 = {centerX - sideLen / 2, centerY - sideLen / 2, centerZ - sideLen / 2};
            float[] i7 = {centerX - sideLen / 2, centerY - sideLen / 2, centerZ + sideLen / 2};
            float[] i8 = {centerX + sideLen / 2, centerY - sideLen / 2, centerZ + sideLen / 2};

            Vec3d camera_pos = drawContext.camera().getPos();

            Matrix4f transformationMatrix = drawContext.matrixStack().peek().getPositionMatrix();

            Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder buffer = tessellator.getBuffer();

            buffer.begin(VertexFormat.DrawMode.TRIANGLE_STRIP, VertexFormats.POSITION_COLOR);

            buffer.vertex(transformationMatrix, i1[0] - (float)camera_pos.x, i1[1] - (float)camera_pos.y, i1[2] - (float)camera_pos.z).color(argbColor).next();
            buffer.vertex(transformationMatrix, i2[0] - (float)camera_pos.x, i2[1] - (float)camera_pos.y, i2[2] - (float)camera_pos.z).color(argbColor).next();
            buffer.vertex(transformationMatrix, i5[0] - (float)camera_pos.x, i5[1] - (float)camera_pos.y, i5[2] - (float)camera_pos.z).color(argbColor).next();
            buffer.vertex(transformationMatrix, i6[0] - (float)camera_pos.x, i6[1] - (float)camera_pos.y, i6[2] - (float)camera_pos.z).color(argbColor).next();
            buffer.vertex(transformationMatrix, i7[0] - (float)camera_pos.x, i7[1] - (float)camera_pos.y, i7[2] - (float)camera_pos.z).color(argbColor).next();
            buffer.vertex(transformationMatrix, i2[0] - (float)camera_pos.x, i2[1] - (float)camera_pos.y, i2[2] - (float)camera_pos.z).color(argbColor).next();
            buffer.vertex(transformationMatrix, i4[0] - (float)camera_pos.x, i4[1] - (float)camera_pos.y, i4[2] - (float)camera_pos.z).color(argbColor).next();
            buffer.vertex(transformationMatrix, i1[0] - (float)camera_pos.x, i1[1] - (float)camera_pos.y, i1[2] - (float)camera_pos.z).color(argbColor).next();
            buffer.vertex(transformationMatrix, i3[0] - (float)camera_pos.x, i3[1] - (float)camera_pos.y, i3[2] - (float)camera_pos.z).color(argbColor).next();
            buffer.vertex(transformationMatrix, i5[0] - (float)camera_pos.x, i5[1] - (float)camera_pos.y, i5[2] - (float)camera_pos.z).color(argbColor).next();
            buffer.vertex(transformationMatrix, i8[0] - (float)camera_pos.x, i8[1] - (float)camera_pos.y, i8[2] - (float)camera_pos.z).color(argbColor).next();
            buffer.vertex(transformationMatrix, i7[0] - (float)camera_pos.x, i7[1] - (float)camera_pos.y, i7[2] - (float)camera_pos.z).color(argbColor).next();
            buffer.vertex(transformationMatrix, i3[0] - (float)camera_pos.x, i3[1] - (float)camera_pos.y, i3[2] - (float)camera_pos.z).color(argbColor).next();
            buffer.vertex(transformationMatrix, i4[0] - (float)camera_pos.x, i4[1] - (float)camera_pos.y, i4[2] - (float)camera_pos.z).color(argbColor).next();

            RenderSystem.setShader(GameRenderer::getPositionColorProgram);
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            RenderSystem.enableBlend();
            RenderSystem.disableCull();
            RenderSystem.disableDepthTest();

            tessellator.draw();
        });
    }
}
