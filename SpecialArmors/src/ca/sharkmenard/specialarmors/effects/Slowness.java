package ca.sharkmenard.specialarmors.effects;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import ca.sharkmenard.specialarmors.ArmorEffectType;
import ca.sharkmenard.specialarmors.ArmorType;
import ca.sharkmenard.specialarmors.Effect;

public class Slowness implements Effect{

	@Override
	public void applyEffect(Player p, ArmorEffectType eType, ArrayList<ArmorType> piecesList) {
		for(int i = 0; i < piecesList.size(); i++) {
			if(piecesList.get(i) != null) {
				p.setWalkSpeed(p.getWalkSpeed() - 0.01F);
			}
		}
	}

	@Override
	public void removeEffect(Player p, ArmorEffectType eType, ArrayList<ArmorType> piecesList) {
		for(int i = 0; i < piecesList.size(); i = i + 1) {
			if(piecesList.get(i) != null) {
				p.setWalkSpeed(p.getWalkSpeed() + 0.01F);

		/*		AttributeInstance attribute = player.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED);
				double speed = attribute.getValue();
				speed+= 0.02D;
				attribute.setValue(speed);
		*/	
			}
		}
	}

}
