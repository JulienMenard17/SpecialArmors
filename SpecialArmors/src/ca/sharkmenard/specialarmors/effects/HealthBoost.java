package ca.sharkmenard.specialarmors.effects;

import java.util.ArrayList;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import ca.sharkmenard.specialarmors.ArmorEffectType;
import ca.sharkmenard.specialarmors.ArmorType;
import ca.sharkmenard.specialarmors.Effect;
import net.minecraft.server.v1_8_R3.AttributeInstance;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.GenericAttributes;

public class HealthBoost implements Effect {
	
	@Override
	public void applyEffect(Player p, ArmorEffectType eType, ArrayList<ArmorType> piecesList) {
		EntityPlayer player = (EntityPlayer)((CraftPlayer) p).getHandle();
		AttributeInstance attribute = player.getAttributeInstance(GenericAttributes.maxHealth);
		for(int i = 0; i < piecesList.size(); i++) {
			if(piecesList.get(i) != null) {
				attribute.setValue(p.getMaxHealth() + 2.0D);
			}
		}
	}

	@Override
	public void removeEffect(Player p, ArmorEffectType eType, ArrayList<ArmorType> piecesList) {
		EntityPlayer player = (EntityPlayer)((CraftPlayer) p).getHandle();
		AttributeInstance attribute = player.getAttributeInstance(GenericAttributes.maxHealth);
		for(int i = 0; i < piecesList.size(); i = i + 1) {
			if(piecesList.get(i) != null && p.getMaxHealth() > 2.0D) {
				attribute.setValue(p.getMaxHealth() - 2.0D);
			}
		}
	}
	

}
