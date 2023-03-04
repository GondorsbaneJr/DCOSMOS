package scattered_omega.dcosmos.Handlers;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;

import java.util.Collections;
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
        if (player.hasPermission("dcosmos.use")) {
            player.sendMessage("§c[§aDCometicsS§c] §2Cool you don't got that skill issue Enjoy these awesome death messages!");
            player.openInventory(Bukkit.createInventory(null, 9, "§a§lDcosmetics"));
            //items in gui
            player.getInventory().setItem(0, new org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND_SWORD));
            player.getInventory().getItem(0).getItemMeta().setDisplayName("§a§lSomone got Domed");
            player.getInventory().getItem(0).getItemMeta().setLore(Collections.singletonList("§a§lThis death message says 'you got domed by (player name) with (player weapon). Skill issue tbh' "));
            //item with certain lore and name
            if (player.hasPermission("dcosmos.premium")) {
                player.getInventory().setItem(1, new org.bukkit.inventory.ItemStack(org.bukkit.Material.NETHERITE_SWORD));
                player.getInventory().getItem(1).getItemMeta().setDisplayName("§a§lPremium Death Message");
                player.getInventory().getItem(1).getItemMeta().setLore(Collections.singletonList("§a§lThis death message says"));
            }else{

                player.sendMessage("§c[§aDCometicsS§c] §4Lmao you don't have the perms to use this death message ask the owner on how to get acces to this death message");
            }
        } else {
            player.sendMessage("§c[§aDCometicsS§c] §4L BOZO You lack the required permissions! Skill issue tbh");
        }
    }

    @EventHandler
    //without getName coz if doesn't work
    public void onInventoryClick(org.bukkit.event.inventory.InventoryClickEvent event) {
        Player player = (Player) event;
        if (event.getInventory().equals("§a§lDcosmetics")) {
            if (event.getCurrentItem().getType().equals(org.bukkit.Material.DIAMOND_SWORD)) {
                player.sendMessage("§c[§aDCometicsS§c] §2You have enabled the §a§lSomone got Domed Death Message");
                player.getInventory().setItem(0, new org.bukkit.inventory.ItemStack(org.bukkit.Material.DIAMOND_SWORD));
            }
            if (event.getCurrentItem().getType().equals(org.bukkit.Material.NETHERITE_SWORD)) {
                player.sendMessage("§c[§aDCometicsS§c] §2You have enabled the §a§lPremium Death Message");
                player.getInventory().setItem(1, new org.bukkit.inventory.ItemStack(org.bukkit.Material.NETHERITE_SWORD));
            }
        }
    }

    @EventHandler
    //changes death messages via a gui menu
    public void onPlayerDeath(org.bukkit.event.entity.PlayerDeathEvent event) {
        Player player = (Player) event;
        //grabs what item they selected in command gui
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
