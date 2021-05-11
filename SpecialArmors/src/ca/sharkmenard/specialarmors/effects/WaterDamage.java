package ca.sharkmenard.specialarmors.effects;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import ca.sharkmenard.specialarmors.ArmorEffectType;
import ca.sharkmenard.specialarmors.ArmorType;
import ca.sharkmenard.specialarmors.Effect;

public class WaterDamage implements Effect {

	@Override
	public void applyEffect(Player p, ArmorEffectType eType, ArrayList<ArmorType> piecesList) {
		
		// Check EffectDamageRunnable for this Effect
		
		if(p.getLocation().getBlock().getType().equals(Material.STATIONARY_WATER) || p.getLocation().getBlock().getType().equals(Material.WATER))
			p.damage(2.0D);
	}

	@Override
	public void removeEffect(Player p, ArmorEffectType eType, ArrayList<ArmorType> piecesList) {
		
	}

}
