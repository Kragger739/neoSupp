package ch.neo.neosuppp.CMD;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class reportPlayer implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        Player p = (Player)sender;
        if (command.getName().equalsIgnoreCase("report"))
        {
            if(args.length == 0)
            {
                p.sendMessage("§4§lUsage: /report <player> <reason>");
            }
            if(args.length == 2)
            {
                //Report Player Function
            }


        }
        return false;
    }
}
