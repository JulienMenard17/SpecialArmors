package ca.sharkmenard.specialarmors;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public interface Effect {
	
	void applyEffect(Player p, ArmorEffectType eType, ArrayList<ArmorType> piecesList);
	
	void removeEffect(Player p, ArmorEffectType eType, ArrayList<ArmorType> piecesList);

}
