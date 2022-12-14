package me.praenyth.mods.minecartcrashes;

import me.praenyth.mods.minecartcrashes.config.ConfigFile;
import me.praenyth.mods.minecartcrashes.gamerule.MinecartGamerules;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class MinecartCrashes implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("Minecart Collisions");

    public static File configFile;
    public static ConfigFile config;

    @Override
    public void onInitialize() {
        MinecartGamerules.registerGamerules();

        configFile = FabricLoader.getInstance().getConfigDir().resolve("minecartcrashes.json").toFile();
        config = ConfigFile.loadConfigFile(configFile);

        config.saveConfigFile(configFile);

        LOGGER.info("Ok mod starting!!!!!!!");
    }

    public static float velocityMultiplier(double velocity) {
        return (float) ((velocity - 0.4) / 2);
    }

    public static float velocitySubtractor(double velocity) {
        return (float) (-(Math.pow(0.995, velocity)) + 1);
    }

}
