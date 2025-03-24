package xyz.theunknowngroup.window;

import org.lwjgl.glfw.GLFWImage;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.glfw.GLFW.glfwSetWindowIcon;
import static org.lwjgl.system.MemoryStack.stackPush;

public class WindowIcon {
    public static void setWindowIcon(long window, String path) {
        try (MemoryStack stack = stackPush()) {
            IntBuffer width = stack.mallocInt(1);
            IntBuffer height = stack.mallocInt(1);
            IntBuffer channels = stack.mallocInt(1);

            ByteBuffer image = STBImage.stbi_load(path, width, height, channels, 4);
            if (image == null) {
                throw new RuntimeException("Failed to load icon: " + STBImage.stbi_failure_reason());
            }

            GLFWImage.Buffer icons = GLFWImage.malloc(1);
            icons.position(0).width(width.get(0)).height(height.get(0)).pixels(image);
            glfwSetWindowIcon(window, icons);

            STBImage.stbi_image_free(image);
        }
    }

}
