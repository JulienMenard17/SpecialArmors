package ca.sharkmenard.specialarmors.effects;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import ca.sharkmenard.specialarmors.ArmorEffectType;
import ca.sharkmenard.specialarmors.ArmorType;
import ca.sharkmenard.specialarmors.EventEffect;

public class ScytheDamage implements EventEffect{

	@Override
	public void applyEffect(Player p, ArmorEffectType eType, ArrayList<ArmorType> piecesList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEffect(Player p, ArmorEffectType eType, ArrayList<ArmorType> piecesList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void applyEvent(Event event) {
		if(event instanceof EntityDamageByEntityEvent) {
			EntityDamageByEntityEvent e = (EntityDamageByEntityEvent) event;
			if(e.getDamager() instanceof Player) {
				if(e.getDamage() <= 1)
				e.setDamage(12.0D);
				else
					e.setDamage(14.5D);

			}
		}
		
	}

}
