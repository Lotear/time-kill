package com.github.lotear.timekill;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.function.Consumer;
import java.util.logging.Logger;

public class ConfigReloader implements Runnable
{
    private final File file;

    private final Consumer<ConfigurationSection> loader;

    private final Logger logger;

    private long lastModified;

    public ConfigReloader(File file, Consumer<ConfigurationSection> loader, Logger logger)
    {
        this.file = file;
        this.lastModified = file.lastModified();
        this.loader = loader;
        this.logger = logger;
    }

    @Override
    public void run()
    {
        long last = file.lastModified();

        if (this.lastModified != last)
        {
            this.lastModified = last;

            if (file.exists())
            {
                YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
                loader.accept(config);
                logger.info("Config reloaded!");
            }
            else
            {
                logger.info("Config file deleted!");
            }
        }
    }
}
