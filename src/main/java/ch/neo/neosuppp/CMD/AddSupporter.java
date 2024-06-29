package ch.neo.neosuppp.CMD;

import ch.neo.neosuppp.SuppManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AddSupporter implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (command.getName().equalsIgnoreCase("neosupp"))
        {
            Player p = (Player)sender;

            if(p.isOp())
            {
                if(args.length == 0)
                {
                    p.sendMessage("§4§lUsage: /neosupp <add | remove> <player>");
                    return true;
                }
                if(args.length == 2)
                {
                    String arg1 = args[0];
                        if(arg1.equalsIgnoreCase( "add"))
                        {
                            String target= args[1];
                            Player tgt = Bukkit.getPlayer(target);

                            if(SuppManager.isSupporter(tgt))
                            {
                                p.sendMessage("§6§lThis person already has the supporter permission");
                            }
                            else
                            {
                                SuppManager.supporter.put(tgt.getUniqueId(), "SUPPORTER");
                            }
                        }
                        if(arg1.equalsIgnoreCase( "remove"))
                        {
                            String target= args[1];
                            Player tgt = Bukkit.getPlayer(target);
                            if(SuppManager.isSupporter(tgt))
                            {

                                SuppManager.supporter.remove(tgt.getUniqueId(), "SUPPORTER");
                            }
                            else
                            {
                                p.sendMessage("§6§lThis person is not a supporter");
                            }
                        }
                }
                if(args.length == 1)
                {
                    String arg1 = args[0];
                    if(arg1.equalsIgnoreCase( "duty"))
                    {
                        if(SuppManager.isSupporter(p))
                        {
                            if(SuppManager.isOnDuty(p))
                            {
                                SuppManager.duty.remove(p.getUniqueId());
                                p.sendMessage("§6§lyou got removed from supporter duty");
                            }else
                            {
                                SuppManager.duty.put(p.getUniqueId(), "DUTY");
                                p.sendMessage("§6§lyou are now on support duty");
                            }
                        }
                    }
                }
            }else
            {
                p.sendMessage("§4§lyou are not allowed to do that");
            }
        }
        return false;
    }
}
