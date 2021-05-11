package ca.sharkmenard.specialarmors;

import org.bukkit.inventory.ItemStack;





public enum ArmorType
{
  HELMET(0), BODY(1), LEGGINGS(2), BOOTS(3), WEAPON(-1);
  
  private final int slot;

  
  ArmorType(int slot) { this.slot = slot; }







  
  public static final ArmorType matchType(ItemStack itemStack) {
    if (itemStack == null) return null; 
    switch (itemStack.getType()) {
      case SKULL:
      case PUMPKIN:
      case LEATHER_HELMET:
      case CHAINMAIL_HELMET:
      case IRON_HELMET:
      case DIAMOND_HELMET:
      case GOLD_HELMET:
        return HELMET;
      case LEATHER_CHESTPLATE:
      case CHAINMAIL_CHESTPLATE:
      case IRON_CHESTPLATE:
      case DIAMOND_CHESTPLATE:
      case GOLD_CHESTPLATE:
        return BODY;
      case LEATHER_LEGGINGS:
      case CHAINMAIL_LEGGINGS:
      case IRON_LEGGINGS:
      case DIAMOND_LEGGINGS:
      case GOLD_LEGGINGS:
        return LEGGINGS;
      case LEATHER_BOOTS:
      case CHAINMAIL_BOOTS:
      case IRON_BOOTS:
      case DIAMOND_BOOTS:
      case GOLD_BOOTS:
        return BOOTS;
      case WOOD_SWORD:
      case STONE_SWORD:
      case IRON_SWORD:
      case GOLD_SWORD:
      case DIAMOND_SWORD:
      case BOW:
      case IRON_HOE:
      case IRON_AXE:
    	  return WEAPON;
	default:
		return null;
    } 
  }


  
  public int getSlot() { return this.slot; }
}
