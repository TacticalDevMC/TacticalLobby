package me.tacticaldev.tacticallobby.api.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ItemBuilder {

    private ItemStack stack;
    private ItemMeta meta;

    public ItemBuilder(ItemStack stack) {
        this.stack = stack;
        this.meta = this.stack.getItemMeta();
    }

    public ItemBuilder(ItemStack stack, String displayname) {
        this.stack = stack;
        this.meta = this.stack.getItemMeta();
        setDisplayName(displayname);
    }

    public ItemBuilder(Material material) {
        this.stack = new ItemStack(material);
        this.meta = this.stack.getItemMeta();
    }

    public ItemBuilder(Material material, String displayname) {
        this.stack = new ItemStack(material);
        this.meta = this.stack.getItemMeta();
        setDisplayName(displayname);
    }

    public ItemBuilder setDisplayName(String displayName) {
        this.meta.setDisplayName(Chat.color(displayName));
        return this;
    }

    public ItemBuilder setDurability(short durability) {
        this.stack.setDurability(durability);
        return this;
    }

    public ItemBuilder setMaterial(Material material) {
        this.stack.setType(material);
        return this;
    }

    public ItemBuilder setAmount(int amount) {
        this.stack.setAmount(amount);
        return this;
    }

    public ItemBuilder addToLore(String lore) {
        ArrayList<String> loreList = this.meta.getLore() == null ? new ArrayList() : (ArrayList) this.meta.getLore();
        loreList.add(Chat.color(lore));
        this.meta.setLore(loreList);
        return this;
    }

    public ItemBuilder removeFromLore(String lore) {
        ArrayList<String> loreList = new ArrayList();
        for (String s : this.meta.getLore()) {
            if (!s.equals(Chat.color(lore))) {
                loreList.add(Chat.color(s));
            }
        }
        this.meta.setLore(loreList);
        return this;
    }

    public ItemBuilder setLore(String... lore) {

        ArrayList<String> normal = new ArrayList<>();
        for (String s : lore) normal.add(Chat.color(s));

        this.meta.setLore(normal);
        return this;
    }

    public ItemBuilder setLore(ArrayList<String> lore) {

        ArrayList<String> normal = new ArrayList<>();
        for (String s : lore) normal.add(Chat.color(s));

        this.meta.setLore(normal);
        return this;
    }

    public ItemBuilder removeLore() {
        this.meta.setLore(null);
        return this;
    }

    public ItemBuilder addEnchantment(Enchantment enchantment, int level) {
        this.meta.addEnchant(enchantment, level, true);
        return this;
    }

    public ItemBuilder removeEnchantments() {
        for (Enchantment enchantment : this.meta.getEnchants().keySet()) {
            this.meta.removeEnchant(enchantment);
        }
        return this;
    }

    public ItemBuilder addItemFlags(ItemFlag... flag) {
        this.meta.addItemFlags(flag);
        return this;
    }

    public ItemBuilder removeItemFlags(ItemFlag... flags) {
        this.meta.removeItemFlags(flags);
        return this;
    }

    public ItemStack build() {
        this.stack.setItemMeta(this.meta);
        return this.stack;
    }
}
