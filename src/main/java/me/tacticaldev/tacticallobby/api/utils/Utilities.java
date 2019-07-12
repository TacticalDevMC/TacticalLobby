package me.tacticaldev.tacticallobby.api.utils;

import me.tacticaldev.tacticallobby.TacticalLobby;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Utilities {

    public static int getRandomInteger(int lower, int upper) {
        return new Random().nextInt((upper - lower) + 1) + lower;
    }

    public static String locationToString(Location location) {
        if (location == null) return "";
        return (location.getWorld().getName() + "%" + location.getX() + "%" + location.getY() + "%" + location.getZ() + "%" + location.getYaw() + "%" + location.getPitch());
    }

    public static Location locationFromString(String string) {
        if (string.equalsIgnoreCase("")) return null;
        String[] s = string.split("%");
        if (Bukkit.getWorld(s[0]) != null)
            return new Location(Bukkit.getWorld(s[0]), Double.valueOf(s[1]), Double.valueOf(s[2]), Double.valueOf(s[3]), Float.valueOf(s[4]), Float.valueOf(s[5]));
        return null;
    }

    public static Location roundLocation(Location location) {
        return new Location(location.getWorld(), location.getBlockX(), location.getBlockY(), location.getBlockZ(), location.getYaw(), location.getPitch()).add(0.500, 0, 0.500);
    }

    public static ItemStack createItemStack(Material material, String displayname, String lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemmeta = item.getItemMeta();
        itemmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayname));
        ArrayList<String> itemlore = new ArrayList<String>();
        itemlore.add(ChatColor.translateAlternateColorCodes('&', lore));
        itemmeta.setLore(itemlore);
        item.setItemMeta(itemmeta);
        return item;
    }

    public static ItemStack createItemStack(ItemStack newItem, String displayname, String lore) {
        ItemStack item = new ItemStack(newItem);
        ItemMeta itemmeta = item.getItemMeta();
        itemmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayname));
        ArrayList<String> itemlore = new ArrayList<String>();
        itemlore.add(ChatColor.translateAlternateColorCodes('&', lore));
        itemmeta.setLore(itemlore);
        item.setItemMeta(itemmeta);
        return item;
    }

    public static ItemStack createItemStack(Material material, String displayname, List<String> lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemmeta = item.getItemMeta();
        itemmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayname));
        List<String> itemlore = lore;
        itemmeta.setLore(itemlore);
        item.setItemMeta(itemmeta);
        return item;
    }

    public static ItemStack createItemStack(ItemStack newItem, String displayname, List<String> lore) {
        ItemStack item = new ItemStack(newItem);
        ItemMeta itemmeta = item.getItemMeta();
        itemmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayname));
        List<String> itemlore = lore;
        itemmeta.setLore(itemlore);
        item.setItemMeta(itemmeta);
        return item;
    }

    public static boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static boolean isUUID(String string) {
        try {
            UUID.fromString(string);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static ItemStack addGlow(ItemStack item) {
        item.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }

    public static int genPage(int currentpage, String value) {
        if (value.equalsIgnoreCase("UP")) {
            return (currentpage + 1);
        } else if (value.equalsIgnoreCase("DOWN")) {
            if ((currentpage - 1) >= 1) {
                return (currentpage - 1);
            } else {
                return currentpage;
            }
        } else {
            return currentpage;
        }
    }

    public static void executeCommand(Player p, List<String> commands) {
        for (String s : commands) {
            String msg = s.replaceAll("%name%", p.getName().replaceAll("%uuid%", p.getUniqueId().toString()));
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), msg);
        }
    }

    public static ItemStack createPageSwitch(int currentPage, int page) {
        ItemBuilder builder = new ItemBuilder(new ItemStack(Material.INK_SAC, 1, (byte) 8), "&aPage #" + page);

        if (page == currentPage) {
            builder.addEnchantment(Enchantment.DURABILITY, 1);
            builder.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        return builder.build();
    }

    public static String getVersionFormat() {
        String a = TacticalLobby.getInstance().getServer().getClass().getPackage().getName();
        return a.substring(a.lastIndexOf('.') + 1);
    }
}
