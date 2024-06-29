package ch.neo.neosuppp;

import ch.neo.neosuppp.CMD.AddSupporter;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.UUID;

public final class Main extends JavaPlugin
{

    @Override
    public void onEnable()
    {
        // Plugin startup logic
        Objects.requireNonNull(getCommand("neosupp")).setExecutor(new AddSupporter());

        Properties properties = new Properties();
        System.out.println("Try to load data.properties:");

        try {
            properties.load(new FileInputStream("data.properties"));
            System.out.println("Loaded successfully ("+properties.stringPropertyNames().size()+")");
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        for (String key : properties.stringPropertyNames()) {
            SuppManager.supporter.put(UUID.fromString(key), properties.get(key).toString());
        }
    }

    @Override
    public void onDisable()
    {
        // Plugin shutdown logic

        Properties properties = new Properties();

        for (Map.Entry<UUID, String> entry : SuppManager.supporter.entrySet())
        {
            properties.put(entry.getKey().toString(), entry.getValue());
        }

        try
        {
            properties.store(new FileOutputStream("data.properties"), null);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
