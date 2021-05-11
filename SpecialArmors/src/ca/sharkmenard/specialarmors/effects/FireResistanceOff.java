package ca.sharkmenard.specialarmors.effects;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffectType;

import ca.sharkmenard.specialarmors.ArmorEffectType;
import ca.sharkmenard.specialarmors.ArmorType;
import ca.sharkmenard.specialarmors.EventEffect;

public class FireResistanceOff implements EventEffect{

	@Override
	public void applyEffect(Player p, ArmorEffectType eType, ArrayList<ArmorType> piecesList) {
		if(p.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)) {
			p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
		}
	}

	@Override
	public void removeEffect(Player p, ArmorEffectType eType, ArrayList<ArmorType> piecesList) {
		
	}

	@Override
	public void applyEvent(Event event) {
		if(event instanceof PlayerCommandPreprocessEvent) {
			PlayerCommandPreprocessEvent e = (PlayerCommandPreprocessEvent) event;
			if(!e.isCancelled()) {
				Player p = e.getPlayer();
					p.sendMessage(ChatColor.RED + "Erreur: Des pièces d'équipements vous empêchent d'éteindre le feu !");
					e.setCancelled(true);
			}
		}
		if(event instanceof PlayerItemConsumeEvent) {
			PlayerItemConsumeEvent e = (PlayerItemConsumeEvent) event;
			if(!e.isCancelled()) {
				Player p = e.getPlayer();
				if(e.getItem().getType().equals(Material.POTION)) {
					@SuppressWarnings("deprecation")
					byte data = e.getItem().getData().getData();
					if(data == (byte) 8227 || data == (byte) 8259) {
						e.setCancelled(true);
						p.sendMessage(ChatColor.RED + "Des pièces d'équipements vous empêchent de consommer ce type de potion !");
					}
				}
			}
		}
	}

}
