package xyz.theunknowngroup;

import static org.lwjgl.opengl.GL.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

import xyz.theunknowngroup.window.WindowIcon;

public class ElementaMain {
    // Icon
    private static long window;
    private static String i = "C:\\Users\\kaylo\\repos\\theunknowngroup\\mcdevelopment\\elementa\\build\\resources\\main\\icon.png";
    public static void run(){
        init();
        WindowIcon.setWindowIcon(window, i);
        loop();
        glfwDestroyWindow(window);
        glfwTerminate();
    }

    private static void init() {
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
    private static void loop() {
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