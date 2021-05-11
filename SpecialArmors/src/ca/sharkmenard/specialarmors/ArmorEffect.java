package ca.sharkmenard.specialarmors;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;

public class ArmorEffect {
	
	
	private String armorName;
	private ArrayList<ItemStack> gear;
	private ArrayList<ArmorEffectType> effectsList;
	private ArrayList<ArmorType> piecesType;
	private boolean hasHelmet;
	private boolean hasBody;
	private boolean hasLeggings;
	private boolean hasBoots;
	private boolean hasWeapon;
	

	public ArmorEffect(ArrayList<ItemStack> gearPieces, ArrayList<ArmorEffectType> listEffects, String armorName) {
		this.armorName = armorName;
		gear = new ArrayList<ItemStack>();
		effectsList = new ArrayList<ArmorEffectType>(listEffects);
		piecesType = new ArrayList<ArmorType>();
		for(ItemStack itemStack : gearPieces) {
			if(!hasHelmet && ArmorType.matchType(itemStack).equals(ArmorType.HELMET)) {
				hasHelmet = true;
				gear.add(itemStack);
			}
		}
		if(!hasHelmet) {
			gear.add(null);
		}else {
			piecesType.add(ArmorType.HELMET);
		}
		for(ItemStack itemStack : gearPieces) {
			if(!hasBody && ArmorType.matchType(itemStack).equals(ArmorType.BODY)) {
				hasBody = true;
				gear.add(itemStack);
			}
		}
		if(!hasBody) {
			gear.add(null);
		}else {
			piecesType.add(ArmorType.BODY);
		}
		for(ItemStack itemStack : gearPieces) {
			if(!hasLeggings && ArmorType.matchType(itemStack).equals(ArmorType.LEGGINGS)) {
				hasLeggings = true;
				gear.add(itemStack);
			}
		}
		if(!hasLeggings) {
			gear.add(null);
		}else {
			piecesType.add(ArmorType.LEGGINGS);
		}
		for(ItemStack itemStack : gearPieces) {
			if(!hasBoots && ArmorType.matchType(itemStack).equals(ArmorType.BOOTS)) {
				hasBoots = true;
				gear.add(itemStack);
			}
		}
		if(!hasBoots) {
			gear.add(null);
		}else {
			piecesType.add(ArmorType.BOOTS);
		}
		for(ItemStack itemStack : gearPieces) {
			if(!hasWeapon && ArmorType.matchType(itemStack).equals(ArmorType.WEAPON)) {
				hasWeapon = true;
				gear.add(itemStack);
			}
		}
		if(!hasWeapon) {
			gear.add(null);
		}else {
			piecesType.add(ArmorType.WEAPON);
		}
		Main.getArmorHandler().addArmorToList(this);
	}
	
	public ArrayList<ItemStack> getGearToList() {
		return gear;
	}
	
	public ArrayList<ArmorType> getPiecesType(){
		return piecesType;
 	}
	
	public boolean hasGearPiece(ArmorType armorType) {
		switch (armorType) {
		case HELMET:
			return hasHelmet;
		case BODY:
			return hasBody;
		case LEGGINGS:
			return hasLeggings;
		case BOOTS:
			return hasBoots;
		case WEAPON:
			return hasWeapon;
		}
		return false;
	}
	
	public ItemStack getGearPiece(ArmorType armorType) {
		switch (armorType) {
		case HELMET:
			return gear.get(0);
		case BODY:
			return gear.get(1);
		case LEGGINGS:
			return gear.get(2);
		case BOOTS:
			return gear.get(3);
		case WEAPON:
			return gear.get(4);
		}
		return null;
	}
	
	public ArrayList<ArmorEffectType> getEffectsList() {
		return effectsList;
	}
	
	public String getArmorName() {
		return armorName;
	}

}
