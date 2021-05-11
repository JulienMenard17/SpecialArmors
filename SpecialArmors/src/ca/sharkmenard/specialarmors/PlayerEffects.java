package ca.sharkmenard.specialarmors;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class PlayerEffects {
	
	private ArrayList<ArmorEffect> playerEffects;
	private Player p;
	
	public PlayerEffects(Player p, ArmorEffect eType) {
		playerEffects = new ArrayList<ArmorEffect>();
		playerEffects.add(eType);
		this.p = p;
		Main.getPlayerEffectsHandler().addPlayerEffect(this);
	}
	public PlayerEffects(Player p, ArmorEffect eType, boolean isForReload) {
		playerEffects = new ArrayList<ArmorEffect>();
		playerEffects.add(eType);
		this.p = p;
		if(!isForReload) {
			Main.getPlayerEffectsHandler().addPlayerEffect(this);
		}else {
			Main.getPlayerEffectsHandler().updatePlayerEffect(this);
		}
	}
	
	
	public PlayerEffects(Player pl, ArrayList<ArmorEffect> eType) {
		this.p = pl;
		playerEffects = new ArrayList<ArmorEffect>(eType);
		Main.getPlayerEffectsHandler().addPlayerEffect(this);
	}
	
	public Player getPlayer() {
		return p;
	}
	
	public void addArmorEffect(ArmorEffect eType) {
		if(!playerEffects.contains(eType)) {
		playerEffects.add(eType);
		}
	}
	
	public void removeArmorEffect(ArmorEffect eType) {
		if(playerEffects.contains(eType)) {
			playerEffects.remove(eType);
			
		}
		if(playerEffects.isEmpty()) {
			Main.getPlayerEffectsHandler().removePlayerEffect(this);
		}
	}
	
	public ArrayList<ArmorEffect> getPlayerEffects() {
		return playerEffects;
	}
		
}
