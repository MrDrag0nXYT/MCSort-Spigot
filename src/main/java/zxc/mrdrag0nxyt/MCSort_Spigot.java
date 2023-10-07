package zxc.mrdrag0nxyt;

import org.bukkit.plugin.java.JavaPlugin;
import zxc.mrdrag0nxyt.commands.SortCommand;
import zxc.mrdrag0nxyt.commands.SortTabComplete;

public final class MCSort_Spigot extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("sort").setExecutor(new SortCommand());
        getCommand("sort").setTabCompleter(new SortTabComplete());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
