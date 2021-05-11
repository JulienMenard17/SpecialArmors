package ca.sharkmenard.specialarmors;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

import com.codingforcookies.armorequip.ArmorEquipEvent;

public class ArmorEquipListener implements Listener {
	
	@EventHandler
	public void onEquip(ArmorEquipEvent e) {
		Player p = e.getPlayer();
		ItemStack gear = e.getNewArmorPiece();
		ArrayList<ItemStack> armor1 = new ArrayList<ItemStack>();
		EntityEquipment item = p.getEquipment();
		if(gear != null && !gear.getType().equals(Material.AIR)) {
			if(ArmorType.matchType(gear).equals(ArmorType.HELMET)) {
				armor1.add(gear);
				armor1.add(item.getChestplate());
				armor1.add(item.getLeggings());
				armor1.add(item.getBoots());
				armor1.add(e.getPlayer().getItemInHand());
			}
			if(ArmorType.matchType(gear).equals(ArmorType.BODY)) {
				armor1.add(item.getHelmet());
				armor1.add(gear);
				armor1.add(item.getLeggings());
				armor1.add(item.getBoots());
				armor1.add(e.getPlayer().getItemInHand());
			}
			if(ArmorType.matchType(gear).equals(ArmorType.LEGGINGS)) {
				armor1.add(item.getHelmet());
				armor1.add(item.getChestplate());
				armor1.add(gear);
				armor1.add(item.getBoots());
				armor1.add(e.getPlayer().getItemInHand());
			}
			if(ArmorType.matchType(gear).equals(ArmorType.BOOTS)) {
				armor1.add(item.getHelmet());
				armor1.add(item.getChestplate());
				armor1.add(item.getLeggings());
				armor1.add(gear);
				armor1.add(e.getPlayer().getItemInHand());
			}
			for(ArmorEffect armor : Main.getArmorHandler().getArmorList()) {
				int pieces = 0;
				for(ArmorType aType  : armor.getPiecesType()) {
					int slot = aType.getSlot();
					if(slot == -1) {
						if(Main.matchItem(armor.getGearPiece(aType),armor1.get(4))) {
							pieces++;
						}									
					}else {
						if(Main.matchItem(armor.getGearPiece(aType),armor1.get(0))) {
							pieces++;
						}
						if(Main.matchItem(armor.getGearPiece(aType),armor1.get(1))) {
							pieces++;
						}
						if(Main.matchItem(armor.getGearPiece(aType),armor1.get(2))) {
							pieces++;
						}
						if(Main.matchItem(armor.getGearPiece(aType),armor1.get(3))) {
							pieces++;
						}
					}
				}

				if(armor.getPiecesType().size() == pieces) {
					new PlayerEffects(p, armor);
				}

			}
		}

	}
	
	@EventHandler
	public void heldItemSwitch(PlayerItemHeldEvent e) {
		Player p = e.getPlayer();
		ItemStack gear = e.getPlayer().getInventory().getItem(e.getNewSlot());
		ArrayList<ItemStack> armor1 = new ArrayList<ItemStack>();
		EntityEquipment item = p.getEquipment();
		if(gear != null && !gear.getType().equals(Material.AIR)) {
			armor1.add(item.getHelmet());
			armor1.add(item.getChestplate());
			armor1.add(item.getLeggings());
			armor1.add(item.getBoots());
			armor1.add(gear);
			for(ArmorEffect armor : Main.getArmorHandler().getArmorList()) {
				int pieces = 0;
				for(ArmorType aType  : armor.getPiecesType()) {
					int slot = aType.getSlot();
					if(slot == -1) {
						if(Main.matchItem(armor.getGearPiece(aType),armor1.get(4))) {
							pieces++;
						}									
					}else {
						if(Main.matchItem(armor.getGearPiece(aType),armor1.get(0))) {
							pieces++;
						}
						if(Main.matchItem(armor.getGearPiece(aType),armor1.get(1))) {
							pieces++;
						}
						if(Main.matchItem(armor.getGearPiece(aType),armor1.get(2))) {
							pieces++;
						}
						if(Main.matchItem(armor.getGearPiece(aType),armor1.get(3))) {
							pieces++;
						}
					}
				}
				if(armor.getPiecesType().size() == pieces) {
					new PlayerEffects(p, armor);
				}
			}
		}
	}

}
