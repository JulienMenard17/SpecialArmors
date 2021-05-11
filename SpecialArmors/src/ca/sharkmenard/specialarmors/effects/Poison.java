package ca.sharkmenard.specialarmors.effects;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import ca.sharkmenard.specialarmors.ArmorEffectType;
import ca.sharkmenard.specialarmors.ArmorType;
import ca.sharkmenard.specialarmors.EffectPoisonRunnable;
import ca.sharkmenard.specialarmors.EventEffect;

public class Poison implements EventEffect{

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
				Player p = (Player) e.getDamager();
				if(e.getEntity() instanceof LivingEntity) {
					LivingEntity entity = (LivingEntity) e.getEntity();
					entity.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 10, 0));
					new EffectPoisonRunnable(e.getEntity(), p);
				}
			}
		}
	}
}
