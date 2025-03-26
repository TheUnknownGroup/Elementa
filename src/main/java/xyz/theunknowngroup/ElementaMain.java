package xyz.theunknowngroup;

import static org.lwjgl.opengl.GL.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.stackPush;

import org.lwjgl.glfw.GLFWImage;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class ElementaMain {
    // Icon
    private long window;
    private String i = "C:\\Users\\kaylo\\repos\\theunknowngroup\\mcdevelopment\\elementa\\build\\resources\\main\\icon.png";
    public void run(){
        init();
        setWindowIcon();
        loop();
        glfwDestroyWindow(window);
        glfwTerminate();
    }

    public void setWindowIcon() {
        try (MemoryStack stack = stackPush()) {
            IntBuffer width = stack.mallocInt(1);
            IntBuffer height = stack.mallocInt(1);
            IntBuffer channels = stack.mallocInt(1);

            ByteBuffer image = STBImage.stbi_load(i, width, height, channels, 4);
            if (image == null) {
                throw new RuntimeException("Failed to load icon: " + STBImage.stbi_failure_reason());
            }

            GLFWImage.Buffer icons = GLFWImage.malloc(1);
            icons.position(0).width(width.get(0)).height(height.get(0)).pixels(image);
            glfwSetWindowIcon(window, icons);

            STBImage.stbi_image_free(image);
        }
    }

    private void init() {
        if (!glfwInit()) {
            throw new IllegalStateException("Failed to initialize GLFW.");
        }
        window = glfwCreateWindow(854, 480, "Elementa", 0, 0);
        if (window == 0) {
            throw new RuntimeException("Failed to create window.");
        }
        glfwMakeContextCurrent(window);
        createCapabilities();
    }
    private void loop() {
        while (!glfwWindowShouldClose(window)) {
            glClearColor(73.0f/255.0f, 125.0f/255.0f, 120.0f/255.0f, 0.78f);
            glClear(GL_COLOR_BUFFER_BIT);

            glfwSwapBuffers(window);
            glfwPollEvents();
        }
    }

    public static void main(String[] args) {
        new ElementaMain().run();
    }
}