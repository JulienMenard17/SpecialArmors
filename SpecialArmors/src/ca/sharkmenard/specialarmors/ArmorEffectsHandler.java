package ca.sharkmenard.specialarmors;

import java.util.ArrayList;

public class ArmorEffectsHandler {
	
	private ArrayList<ArmorEffect> armorList;
	
	
	public ArmorEffectsHandler() {
		armorList = new ArrayList<ArmorEffect>();
	}
	
	public ArrayList<ArmorEffect> getArmorList() {
		return armorList;
	}
	
	public void addArmorToList(ArmorEffect armor) {
		armorList.add(armor);
	}
	

}
