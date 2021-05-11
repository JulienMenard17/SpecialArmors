package ca.sharkmenard.specialarmors.effects;

import java.util.ArrayList;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import ca.sharkmenard.specialarmors.ArmorEffectType;
import ca.sharkmenard.specialarmors.ArmorType;
import ca.sharkmenard.specialarmors.EventEffect;

public class MobsProtection implements EventEffect {

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
			Entity ent = (Entity) e.getEntity();
			switch (ent.getType()) {
			case BLAZE:
			case CAVE_SPIDER:
			case SPIDER:
			case CREEPER:
			case ENDER_DRAGON:
			case ENDERMAN:
			case ENDERMITE:
			case GHAST:
			case GUARDIAN:
			case MAGMA_CUBE:
			case SILVERFISH:
			case SKELETON:
			case SLIME:
			case WITCH:
			case WITHER:
			case ZOMBIE:
			case PIG_ZOMBIE:
			case WOLF:
			case SQUID:
			case IRON_GOLEM:
			case SNOWMAN:
				e.setDamage(e.getDamage() + 1.0D);
			default:
				break;
			}
		}
	}

}
