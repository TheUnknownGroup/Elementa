package xyz.theunknowngroup.window;

import org.lwjgl.system.MemoryStack;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import static org.lwjgl.glfw.GLFWImage.*;
import static org.lwjgl.glfw.GLFW.glfwSetWindowIcon;
import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.stb.STBImage.*;

public class WindowIcon {
    public static void setWindowIcon(long window, String path) {
        try (MemoryStack stack = stackPush()) {
            IntBuffer width = stack.mallocInt(1);
            IntBuffer height = stack.mallocInt(1);
            IntBuffer channels = stack.mallocInt(1);

            ByteBuffer image = stbi_load(path, width, height, channels, 4);
            if (image == null) {
                throw new RuntimeException("Failed to load icon: " + stbi_failure_reason());
            }

            Buffer icons = calloc(1);
            icons.position(0);
            icons.get(0).set(width.get(0), height.get(0), image);
            glfwSetWindowIcon(window, icons);

            stbi_image_free(image);
            icons.free();
        }
    }
}
