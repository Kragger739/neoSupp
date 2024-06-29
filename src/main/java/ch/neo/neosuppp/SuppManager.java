package ch.neo.neosuppp;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SuppManager
{
    public static final Map<UUID, String> supporter = new HashMap<>();
    public static final Map<UUID, String> duty = new HashMap<>();

    public static boolean isSupporter(Player p)
    {
        if( p.hasPermission("neosupp.support") || supporter.containsKey(p.getUniqueId()))
        {
            return true;
        }
        else
        {
            //p.sendMessage("Keine Berechtigung");
        }
        return false;
    }
    public static boolean isOnDuty(Player p)
    {

        if(duty.containsKey(p.getUniqueId()))
        {
            return true;
        }else
        {
            return false;
        }
    }
}
