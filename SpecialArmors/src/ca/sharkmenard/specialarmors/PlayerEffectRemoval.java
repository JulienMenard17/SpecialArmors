package ca.sharkmenard.specialarmors;

public class PlayerEffectRemoval {
	
	private PlayerEffects playerEffects;
	private ArmorEffect armorEffect;
	
	
	public PlayerEffectRemoval(PlayerEffects pe, ArmorEffect ae) {
		playerEffects = pe;
		armorEffect = ae;
	}
	
	public PlayerEffects getPlayerEffects() {
		return playerEffects;
	}
	
	public ArmorEffect getArmorEffect() {
		return armorEffect;
	}

}
