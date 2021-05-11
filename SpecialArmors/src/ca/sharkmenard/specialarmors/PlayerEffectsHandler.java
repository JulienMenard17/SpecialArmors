package ca.sharkmenard.specialarmors;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class PlayerEffectsHandler {
	
	private ArrayList<PlayerEffects> playersEffectsList;
	
	public PlayerEffectsHandler() {
		playersEffectsList = new ArrayList<PlayerEffects>();
	}
	
	public ArrayList<PlayerEffects> getList() {
		return playersEffectsList;
	}
	
	public PlayerEffects addPlayerEffect(PlayerEffects playerEffects) {
		PlayerEffects pes = null;
		ArrayList<ArmorEffect> aeList = new ArrayList<ArmorEffect>();
		for(PlayerEffects pe : playersEffectsList) {
			if(pe.getPlayer().equals(playerEffects.getPlayer())) {
				pes = pe;
				aeList.addAll(playerEffects.getPlayerEffects());
			}
			
		}
		if(pes == null) {
			playersEffectsList.add(playerEffects);
			givePlayerEffect(playerEffects.getPlayer(), playerEffects.getPlayerEffects());

			return playerEffects;
		}else {
			for(ArmorEffect ae : aeList) {
				if(!pes.getPlayerEffects().contains(ae)) {
					pes.addArmorEffect(ae);
					givePlayerEffect(pes.getPlayer(), ae);
				}
			}
			return pes;
		}
	}
	public PlayerEffects updatePlayerEffect(PlayerEffects playerEffects) {
		PlayerEffects pes = null;
		ArrayList<ArmorEffect> aeList = new ArrayList<ArmorEffect>();
		for(PlayerEffects pe : playersEffectsList) {
			if(pe.getPlayer().getUniqueId().equals(playerEffects.getPlayer().getUniqueId())) {
				pes = pe;
				aeList.addAll(playerEffects.getPlayerEffects());
			}
		}
		if(pes == null) {
			playersEffectsList.add(playerEffects);

			return playerEffects;
		}else {
			for(ArmorEffect ae : aeList) {
				if(!pes.getPlayerEffects().contains(ae)) {
					pes.addArmorEffect(ae);
				}
			}
			return pes;
		}
	}
	
	public void removePlayerEffect(PlayerEffects playerEffects) {
		playersEffectsList.remove(playerEffects);
	}
	
	public void removePlayer(Player p) {
		for(PlayerEffects playerEffects : playersEffectsList) {
			if(playerEffects.getPlayer().equals(p)) {
				removePlayerEffect(playerEffects);
			}
		}
	}
	
	public void removePlayerEffect(Player p, ArmorEffect eType ){
		for(PlayerEffects playerEffects : playersEffectsList) {
			if(playerEffects.getPlayer().equals(p)) {
				playerEffects.removeArmorEffect(eType);
				break;
			}
		}
	}
	
	
	public PlayerEffects getPlayerEffects(Player p){
		for(PlayerEffects playerEffects : playersEffectsList) {
			if(playerEffects.getPlayer().equals(p)) {
				return playerEffects;
			}
		}
		return null;
	}
	
	private void givePlayerEffect(Player p, ArrayList<ArmorEffect> aeList) {
		for(ArmorEffect ae : aeList) {
			givePlayerEffect(p, ae);
		}
	}
	
	private void givePlayerEffect(Player p, ArmorEffect ae) {
		for(ArmorEffectType eType : ae.getEffectsList()) {
			eType.giveEffect(p, eType, ae.getPiecesType());
		}
	}

}
