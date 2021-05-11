package ca.sharkmenard.specialarmors.effects;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Guardian;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Horse.Variant;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Pig;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Rabbit;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Skeleton.SkeletonType;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Snowman;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Zombie;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;

import ca.sharkmenard.specialarmors.ArmorEffect;
import ca.sharkmenard.specialarmors.ArmorEffectType;
import ca.sharkmenard.specialarmors.ArmorType;
import ca.sharkmenard.specialarmors.EventEffect;
import ca.sharkmenard.specialarmors.Main;
import ca.sharkmenard.specialarmors.PlayerEffects;

public class LootingIncrease implements EventEffect {
	
	private int lootingEffect;
	private ArrayList<ItemStack> drops;


	@Override
	public void applyEffect(Player p, ArmorEffectType eType, ArrayList<ArmorType> piecesList) {
		
	}

	@Override
	public void removeEffect(Player p, ArmorEffectType eType, ArrayList<ArmorType> piecesList) {
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void applyEvent(Event event) {
		lootingEffect = 0;
		drops = new ArrayList<ItemStack>();
		if(event instanceof EntityDeathEvent) {
			EntityDeathEvent e = (EntityDeathEvent) event;
			Player p = e.getEntity().getKiller();
			e.getDrops().clear();
			Entity ent = e.getEntity();
			for(PlayerEffects pe : Main.getPlayerEffectsHandler().getList()) {
				if(pe.getPlayer().equals(p))
					for(ArmorEffect ae : pe.getPlayerEffects())
						for(ArmorEffectType eType : ae.getEffectsList())
							if(eType.equals(ArmorEffectType.LOOTING_INCREASE))
								lootingEffect++;
			}
			if(p.getItemInHand() != null && p.getItemInHand().hasItemMeta() && p.getItemInHand().getItemMeta().hasEnchants() && p.getItemInHand().getItemMeta().hasEnchant(Enchantment.LOOT_BONUS_MOBS)) {
				lootingEffect += p.getItemInHand().getItemMeta().getEnchantLevel(Enchantment.LOOT_BONUS_MOBS);
			}
		// Animals
			// Pig
			if(ent instanceof Pig) {
				Pig pig = (Pig) ent;
				if(ent.getFireTicks() != -1) {
					addLoot(new ItemStack(Material.GRILLED_PORK), 3, false);
				}else {
					addLoot(new ItemStack(Material.PORK), 3, false);
				}
				if(pig.hasSaddle())
					addDirectLoot(new ItemStack(Material.SADDLE));
			}
			// Chicken
			if(ent instanceof Chicken) {
				if(ent.getFireTicks() != -1) {
					addLoot(new ItemStack(Material.COOKED_CHICKEN), 1, false);
				}else {
					addLoot(new ItemStack(Material.RAW_CHICKEN), 1, false);
				}
				addLoot(new ItemStack(Material.FEATHER), 2, true);
			}
			// Cow
			if(ent instanceof Cow || ent instanceof MushroomCow) {
				if(ent.getFireTicks() != -1) {
					addLoot(new ItemStack(Material.COOKED_BEEF), 3 , false);
				}else {
					addLoot(new ItemStack(Material.RAW_BEEF), 3 , false);
				}
				addLoot(new ItemStack(Material.LEATHER), 2, true);
			}
			// Cat
			if(ent instanceof Ocelot) {
				Ocelot ocelot = (Ocelot) ent;
				if(ocelot.isTamed()) {
					addLoot(new ItemStack(Material.STRING), 2, true);
				}
			}
			// Horse Donkey Mule Undead_Horse Skeletal_Horse 
			if(ent instanceof Horse) {
				Horse horse = (Horse) ent;
				if(horse.getVariant().equals(Variant.DONKEY) || horse.getVariant().equals(Variant.MULE)) {
					addLoot(new ItemStack(Material.LEATHER), 2, true);
					if(horse.isCarryingChest())
						addDirectLoot(new ItemStack(Material.CHEST));
					for(ItemStack item : horse.getInventory().getContents()) 
						if(item != null && !item.getType().equals(Material.AIR))
							addDirectLoot(item);
				}else if(horse.getVariant().equals(Variant.HORSE)){
					addLoot(new ItemStack(Material.LEATHER), 2, true);
					for(ItemStack item : horse.getInventory().getContents())
						if(item != null && !item.getType().equals(Material.AIR))
							addDirectLoot(item);
				}else if(horse.getVariant().equals(Variant.SKELETON_HORSE)){
					addLoot(new ItemStack(Material.BONE), 2, true);
					for(ItemStack item : horse.getInventory().getContents())
						if(item != null && !item.getType().equals(Material.AIR))
							addDirectLoot(item);
				}else if(horse.getVariant().equals(Variant.UNDEAD_HORSE)){
					addLoot(new ItemStack(Material.ROTTEN_FLESH), 2, true);
					for(ItemStack item : horse.getInventory().getContents())
						if(item != null && !item.getType().equals(Material.AIR))
							addDirectLoot(item);
				}
			}
			// Rabbit
			if(ent instanceof Rabbit) {
				if(ent.getFireTicks() != -1) {
					addLoot(new ItemStack(Material.COOKED_RABBIT), 1, true);
				}else {
					addLoot(new ItemStack(Material.RABBIT), 1, true);

				}
				addLoot(new ItemStack(Material.RABBIT_HIDE), 1, true);
				addRareLoot(new ItemStack(Material.RABBIT_FOOT), 10);
			}
			// Sheep
			if(ent instanceof Sheep) {
				Sheep sheep = (Sheep) ent;
				if(!sheep.isSheared()) {
					addDirectLoot(new ItemStack(Material.WOOL, 1, (byte) sheep.getColor().getWoolData()));
				}
				if(ent.getFireTicks() != -1) {
					addLoot(new ItemStack(Material.COOKED_MUTTON), 2, false);
				}else {
					addLoot(new ItemStack(Material.MUTTON), 2, false);
				}
			}
			// Squid
			if(ent instanceof Squid) {
				addLoot(new ItemStack(Material.INK_SACK), 3, false);
			}
		// Utility Mobs
			// Iron_Golem
			if(ent instanceof IronGolem) {
				addDirectLoot(new ItemStack(Material.IRON_INGOT, 3));
				addLoot(new ItemStack(Material.IRON_INGOT), 2, true);
				addLoot(new ItemStack(Material.RED_ROSE), 2, true);
			}
			// Snow_Golem
			if(ent instanceof Snowman)
				addLoot(new ItemStack(Material.SNOW_BALL), 15, true);
		// Monsters
			// Blaze
			if(ent instanceof Blaze) {
				addLoot(new ItemStack(Material.BLAZE_ROD), 1, true);
			}
			// Spider Cave_Spider
			if(ent instanceof Spider || ent instanceof CaveSpider) {
				addLoot(new ItemStack(Material.STRING), 2, true);
				addLoot(new ItemStack(Material.SPIDER_EYE), 1, true);
			}
			// Creeper
			if(ent instanceof Creeper) {
				addLoot(new ItemStack(Material.SULPHUR), 2, true);
			}
			// Enderman
			if(ent instanceof Enderman) {
				Enderman enderman = (Enderman) ent;
				if(enderman.getCarriedMaterial().getItemType() != null)
					addDirectLoot(new ItemStack(enderman.getCarriedMaterial().getItemType(), 1, (byte) enderman.getCarriedMaterial().getData()));
				addLoot(new ItemStack(Material.ENDER_PEARL), 1, true);
			}
			// Ghast
			if(ent instanceof Ghast) {
				addLoot(new ItemStack(Material.GHAST_TEAR), 1, true);
				addLoot(new ItemStack(Material.SULPHUR), 2, true);
			}
			// Guardian
			if(ent instanceof Guardian) {
				if(ent.getFireTicks() != -1) {
					addLoot(new ItemStack(Material.COOKED_FISH), 1, true);
				}else {
					addLoot(new ItemStack(Material.RAW_FISH), 1, true);
				}
				addLoot(new ItemStack(Material.PRISMARINE_SHARD), 2, true);
				addLoot(new ItemStack(Material.PRISMARINE_CRYSTALS), 1, true);
				addRareLoot(new ItemStack(Material.RAW_FISH), 60);
				addRareLoot(new ItemStack(Material.RAW_FISH, 1, (byte) 1), 25);
				addRareLoot(new ItemStack(Material.RAW_FISH, 1, (byte) 3), 13);
				addRareLoot(new ItemStack(Material.RAW_FISH, 1, (byte) 2), 2);
			}
			// Magma_Cube
			if(ent instanceof MagmaCube) {
				MagmaCube magmaCube = (MagmaCube) ent;
				if(magmaCube.getSize() > 1) {
					addLoot(new ItemStack(Material.MAGMA_CREAM), 1, true);
				}
			}
			// Skeleton Wither_Skeleton
			if(ent instanceof Skeleton) {
				Skeleton skeleton = (Skeleton) ent;
				EntityEquipment eq = skeleton.getEquipment();
				if(skeleton.getSkeletonType().equals(SkeletonType.NORMAL)){
					addLoot(new ItemStack(Material.ARROW), 2, true);
					addLoot(new ItemStack(Material.BONE), 2, true);
					if(eq.getItemInHand() != null)
					addRareLoot(new ItemStack(eq.getItemInHand()), (int) (eq.getItemInHandDropChance() * 100.0F));
					if(eq.getHelmet() != null)
					addRareLoot(new ItemStack(eq.getHelmet()), (int) (eq.getHelmetDropChance() * 100.0F));
					if(eq.getChestplate() != null)
					addRareLoot(new ItemStack(eq.getChestplate()), (int) (eq.getChestplateDropChance() * 100.0F));
					if(eq.getLeggings() != null)
					addRareLoot(new ItemStack(eq.getLeggings()), (int) (eq.getLeggingsDropChance() * 100.0F));
					if(eq.getBoots() != null)
					addRareLoot(new ItemStack(eq.getBoots()), (int) (eq.getBootsDropChance() * 100.0F));
				}else if(skeleton.getSkeletonType().equals(SkeletonType.WITHER)) {
					addLoot(new ItemStack(Material.BONE), 2, true);
					addLoot(new ItemStack(Material.COAL), 1, true);
					if(eq.getItemInHand() != null)
					addRareLoot(new ItemStack(eq.getItemInHand()), (int) (eq.getItemInHandDropChance() * 100.0F));
					if(eq.getHelmet() != null)
					addRareLoot(new ItemStack(eq.getHelmet()), (int) (eq.getHelmetDropChance() * 100.0F));
					addRareLoot(new ItemStack(Material.SKULL_ITEM, 1, (byte) 1), 3, 1);
				}
			}
			// Slime
			if(ent instanceof Slime) {
				Slime slime = (Slime) ent;
				if(slime.getSize() == 1)
					addLoot(new ItemStack(Material.SLIME_BALL), 2, true);
			}
			// Witch
			if(ent instanceof Witch) {
				
			}
			// Wither
			if(ent instanceof Wither) {
				addDirectLoot(new ItemStack(Material.NETHER_STAR));
			}
			// Zombie Zombie_Villager
			if(ent instanceof Zombie) {
				
			}
			// Zombie_Pigman
			if(ent instanceof PigZombie) {
				
			}
			
			
			e.getDrops().addAll(drops);
		}
	}
	
	private void addLoot(ItemStack loot, int chance, boolean asZero) {
		if(asZero) {
			chance++;
			double random = Math.random() * (((double) chance) + ((double) lootingEffect ));
			loot.setAmount((int) random);
		}else {
			double random = Math.random() * (((double) chance) + ((double) lootingEffect ));
			random++;
			loot.setAmount((int) random);
		}
		drops.add(loot);
	}
	private void addRareLoot(ItemStack item, int chanceOn100) {
		int random = (int) ((Math.random() * 100.0D));
		random++;
		chanceOn100 += (3 * lootingEffect);
		if(random <= chanceOn100) {
			drops.add(item);
		}
	}
	private void addRareLoot(ItemStack item, int chanceOn100, int bonusPerLooting) {
		int random = (int) ((Math.random() * 100.0D));
		random++;
		chanceOn100 += (bonusPerLooting * lootingEffect);
		if(random <= chanceOn100) {
			drops.add(item);
		}
	}
	private void addDirectLoot(ItemStack item) {
		drops.add(item);
	}
	
}
