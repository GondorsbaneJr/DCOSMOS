package scattered_omega.dcosmos.Handlers;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;

import org.bukkit.entity.Player;

import java.util.Objects;

public class DCOSMOS_GUI implements org.bukkit.event.Listener {
    public DCOSMOS_GUI(scattered_omega.dcosmos.Dcosmos plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onJoin(org.bukkit.event.player.PlayerJoinEvent event) {
        if (event.getPlayer().hasPermission("dcosmetics.use")) {
            event.getPlayer().sendMessage("§c[§aDCometicsS§c] §2Do /dcosmetics to open the GUI! if you have the right perms");
        }else{
            event.getPlayer().sendMessage("§c[§aDCometicsS§c] §4Lmao you don't have the perms to use this plugin ask the owner on how to get acces to this plugin");
        }

    }
    @EventHandler
    public void onCommand(org.bukkit.event.player.PlayerCommandPreprocessEvent event) {
        Player player = (Player) event;
        if (player.hasPermission("dcosmetics.use")) {
            player.sendMessage("§c[§aDCometicsS§c] §2Cool you don't got that skill issue Enjoy these awesome death messages!");
            player.openInventory(Bukkit.createInventory(null, 9, "§a§lDcosmetics"));
            //items in gui
            player.getInventory().setItem(0, new org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND_SWORD));
            //item with certain lore and name
            player.getInventory().setItem(1, new org.bukkit.inventory.ItemStack(org.bukkit.Material.NETHERITE_SWORD));

        } else {
            player.sendMessage("§c[§aDCometicsS§c] §4L BOZO You lack the required permissions! Skill issue tbh");
        }
    }
    @EventHandler
    //changes death messages via a gui menu
    public void onPlayerDeath(org.bukkit.event.entity.PlayerDeathEvent event) {
        Player player = (Player) event;
        if (player.hasPermission("dcosmetics.use") && Objects.equals(player.getInventory().getItem(0), new org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND_SWORD))
        ) {
            event.setDeathMessage("§c[§aDCometicsS§c] §2" + player.getName() + " §4was DOMED by. Skill issue tbh §2" + Objects.requireNonNull(player.getKiller()).getName());
        } else {
            event.setDeathMessage("§c[§aDCometicsS§c] §2" + player.getName() + " §4was killed by §2" + Objects.requireNonNull(player.getKiller()).getName());

        }
        if (player.hasPermission("dcosmetics.use.premium") && Objects.equals(player.getInventory().getItem(1), new org.bukkit.inventory.ItemStack(org.bukkit.Material.NETHERITE_SWORD))
        ) {
            event.setDeathMessage("§c[§aDCometicsS§c] §2" + player.getName() + " §4was DOMED by. Skill issue tbh §2" + player.getKiller().getName());
        } else {
            event.setDeathMessage("§c[§aDCometicsS§c] §2" + player.getName() + " §4was killed by §2" + player.getKiller().getName());

        }
    }
}
