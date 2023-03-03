// Package: scattered_omega.dcosmos
package scattered_omega.dcosmos;
// Imports
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Level;
import org.bukkit.Bukkit;
// Main Class
public class Dcosmos extends JavaPlugin {
    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        super.onEnable();
        Bukkit.getLogger().log(Level.INFO, "DCosmetics actually loaded somehow like im questioning how it loaded rn");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
        this.getLogger().log(Level.INFO, sender.getName() + " did the command " + command.getName() + " Hopefully it worked and their was now issues :)");
        for (String arg : args) {
            getLogger().log(Level.INFO, arg);
        }
        return true;
        //return super.onCommand(sender, command, label, args);
    }


}
