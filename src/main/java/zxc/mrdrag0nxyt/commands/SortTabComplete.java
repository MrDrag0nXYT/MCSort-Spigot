package zxc.mrdrag0nxyt.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public class SortTabComplete implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length == 1){
            return List.of(
                    "heap",
                    "help",
                    "selection",
                    "shell"
            );
        }

        if(strings.length >= 2 && strings[0] != "help"){
            return List.of(
                    "0",
                    "1",
                    "2",
                    "3",
                    "4",
                    "5",
                    "6",
                    "7",
                    "8",
                    "9"
            );
        }
        return null;
    }
}
