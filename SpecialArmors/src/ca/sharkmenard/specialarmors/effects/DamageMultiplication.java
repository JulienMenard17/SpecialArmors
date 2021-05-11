package ca.sharkmenard.specialarmors.effects;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import ca.sharkmenard.specialarmors.ArmorEffectType;
import ca.sharkmenard.specialarmors.ArmorType;
import ca.sharkmenard.specialarmors.EventEffect;

public class DamageMultiplication implements EventEffect {

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
			if(e.getEntity() instanceof Player) {
				@SuppressWarnings("unused")
				Player p = (Player) e.getEntity();
				e.setDamage(e.getDamage() + 1.0D);
			}
		}		
	}

}
