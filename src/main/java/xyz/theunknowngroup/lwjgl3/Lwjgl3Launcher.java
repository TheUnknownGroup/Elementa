package xyz.theunknowngroup.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import xyz.theunknowngroup.ElementaMain;
public class Lwjgl3Launcher {

    public static int WI = 854;
    public static int HE = 480;

    public static void main(String[] args) {
        if (StartupHelper.startNewJVM()) return; // This handles macOS support and helps on Windows.
        createApplication();
    }
    private static Lwjgl3Application createApplication() {
        return new Lwjgl3Application(new ElementaMain(), getDefault());
    }

    private static Lwjgl3ApplicationConfiguration getDefault() {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("Elementa");
        config.useVsync(true);
        config.setForegroundFPS(Lwjgl3ApplicationConfiguration.getDisplayMode().refreshRate + 1);
        config.setWindowedMode(WI, HE);
        config.setWindowIcon("icon.png");
        config.setResizable(true);
        return config;
    }
}
