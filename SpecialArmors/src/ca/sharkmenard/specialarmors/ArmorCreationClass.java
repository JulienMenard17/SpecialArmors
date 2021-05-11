package ca.sharkmenard.specialarmors;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ArmorCreationClass {
	
	public static void generateArmors() {
		generateAngeliqueArmor();
		generateDemoniaqueArmor();
		generateTitanesqueArmor();
		generateMonstrueuseArmor();
	}
	
	private static void generateAngeliqueArmor() {
		
	//
	// Création des Items
	//
		
		// Lore de l'Armure Angélique
		
		ArrayList<String> lore = new ArrayList<String>();
		
		lore.add("§c➜ §fRareté : §c✰✰✰✰§f✰");
		lore.add("§7------------------------------");
		lore.add("§8• §aHausse des Pts de Vie");
		lore.add("§8• §cRésistance au Feu Off");
		lore.add("§8• §cDégâts de Feu Augmenté");
		lore.add("");
		lore.add("§c/armures §7pour plus d'infos");
		
		
		// Casque Angélique
		
		ItemStack helm = new ItemStack(Material.IRON_HELMET);
		ItemMeta helmM = helm.getItemMeta();
		helmM.setDisplayName("§c➜ §fCasque §fAngé§clique");
		helmM.setLore(lore);
		helmM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		helmM.addEnchant(Enchantment.DURABILITY, 3, true);
		helmM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		helm.setItemMeta(helmM);

		// Plastron Angélique
		
		ItemStack chest = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta chestM = chest.getItemMeta();
		chestM.setDisplayName("§c➜ §fPlastron §fAngé§clique");
		chestM.setLore(lore);
		chestM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		chestM.addEnchant(Enchantment.DURABILITY, 3, true);
		chestM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		chest.setItemMeta(chestM);
		
		// Jambières Angéliques
		
		ItemStack legs = new ItemStack(Material.IRON_LEGGINGS);
		ItemMeta legsM = legs.getItemMeta();
		legsM.setDisplayName("§c➜ §fJambières §fAngé§cliques");
		legsM.setLore(lore);
		legsM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		legsM.addEnchant(Enchantment.DURABILITY, 3, true);
		legsM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		legs.setItemMeta(legsM);
		
		// Bottes Angéliques
		
		ItemStack boots = new ItemStack(Material.IRON_BOOTS);
		ItemMeta bootsM = boots.getItemMeta();
		bootsM.setDisplayName("§c➜ §fBottes §fAngé§cliques");
		bootsM.setLore(lore);
		bootsM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		bootsM.addEnchant(Enchantment.DURABILITY, 3, true);
		bootsM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		boots.setItemMeta(bootsM);

		// Arc Angélique
		
		ItemStack weap = new ItemStack(Material.BOW);
		ItemMeta weapM = weap.getItemMeta();
		weapM.setDisplayName("§c➜ §fArc §fAngé§clique");
		weapM.setLore(lore);
		weapM.addEnchant(Enchantment.ARROW_DAMAGE, 6, true);
		weapM.addEnchant(Enchantment.ARROW_FIRE, 3, true);
		weapM.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
		weapM.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
		weapM.addEnchant(Enchantment.DURABILITY, 3, true);
		weapM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		weap.setItemMeta(weapM);
		
	//
	// Création des ArmorEffects
	//
		// Une list est requis pour créer un ArmorEffect Donc nous devons créer plein de List
		
		// List pour le Casque
		ArrayList<ItemStack> helmList = new ArrayList<ItemStack>();
		helmList.add(helm);
		
		// List pour le Plastron
		ArrayList<ItemStack> chestList = new ArrayList<ItemStack>();
		chestList.add(chest);
		
		// List pour les Jambières
		ArrayList<ItemStack> legsList = new ArrayList<ItemStack>();
		legsList.add(legs);
		
		// List pour les Bottes
		ArrayList<ItemStack> bootsList = new ArrayList<ItemStack>();
		bootsList.add(boots);
		
		// List pour l'arme
		ArrayList<ItemStack> weapList = new ArrayList<ItemStack>();
		weapList.add(weap);
		
		//List pour l'armure sans l'arme
		ArrayList<ItemStack> setList = new ArrayList<ItemStack>();
		setList.add(helm);
		setList.add(chest);
		setList.add(legs);
		setList.add(boots);
		
		// List pour l'armure + l'arme
		ArrayList<ItemStack> fullSetList = new ArrayList<ItemStack>();
		fullSetList.add(helm);
		fullSetList.add(chest);
		fullSetList.add(legs);
		fullSetList.add(boots);
		fullSetList.add(weap);
		
		//
		// List des effets
		//
		// Elle va être modifier pour chaque ArmorEffect qui a des effets différents 
		ArrayList<ArmorEffectType> effectList = new ArrayList<ArmorEffectType>();
		
		new ArmorEffect(setList, effectList, "AngeliqueSet");
		new ArmorEffect(fullSetList, effectList, "AngeliqueFullSet");
		
		effectList.add(ArmorEffectType.HEALTH_BOOST);
		effectList.add(ArmorEffectType.FIRE_DAMAGE_INCREASE);
		new ArmorEffect(weapList, effectList, "AngeliqueBow");

		effectList.add(ArmorEffectType.FIRE_RESISTANCE_OFF);
		new ArmorEffect(helmList, effectList, "AngeliqueHelm");
		new ArmorEffect(chestList, effectList, "AngeliqueChest");
		new ArmorEffect(legsList, effectList, "AngeliqueLegs");
		new ArmorEffect(bootsList, effectList, "AngeliqueBoots");


	}
	
	private static void generateDemoniaqueArmor() {
		
	//
	// Création des Items
	//
		
		ArrayList<String> lore = new ArrayList<String>();
		
		lore.add("§4➜ §cRareté : §4✰✰✰✰§f✰");
		lore.add("§7------------------------------");
		lore.add("§8• §aEffet de Vampirisme");
		lore.add("§8• §cDégâts par l'eau");
		lore.add("");
		lore.add("§c/armures §7pour plus d'infos");

		
		// Casque Démoniaque
		
		ItemStack helm = new ItemStack(Material.IRON_HELMET);
		ItemMeta helmM = helm.getItemMeta();
		helmM.setDisplayName("§4➜ §cCasque §4Démoniaque");
		helmM.setLore(lore);
		helmM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		helmM.addEnchant(Enchantment.DURABILITY, 3, true);
		helmM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		helm.setItemMeta(helmM);

		
		// Plastron Démoniaque
		
		ItemStack chest = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta chestM = chest.getItemMeta();
		chestM.setDisplayName("§4➜ §cPlastron §4Démoniaque");
		chestM.setLore(lore);
		chestM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		chestM.addEnchant(Enchantment.DURABILITY, 3, true);
		chestM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		chest.setItemMeta(chestM);

		
		// Jambières Démoniaques
		
		ItemStack legs = new ItemStack(Material.IRON_LEGGINGS);
		ItemMeta legsM = legs.getItemMeta();
		legsM.setDisplayName("§4➜ §cJambières §4Démoniaques");
		legsM.setLore(lore);
		legsM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		legsM.addEnchant(Enchantment.DURABILITY, 3, true);
		legsM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		legs.setItemMeta(legsM);

		// Bottes Démoniaques
		
		ItemStack boots = new ItemStack(Material.IRON_BOOTS);
		ItemMeta bootsM = boots.getItemMeta();
		bootsM.setDisplayName("§4➜ §cBottes §4Démoniaques");
		bootsM.setLore(lore);
		bootsM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		bootsM.addEnchant(Enchantment.DURABILITY, 3, true);
		bootsM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		boots.setItemMeta(bootsM);

		// Faux Démoniaque
		
		ItemStack weap = new ItemStack(Material.IRON_HOE);
		ItemMeta weapM = weap.getItemMeta();
		weapM.setDisplayName("§4➜ §cFaux §4Démoniaque");
		weapM.setLore(lore);
		weapM.addEnchant(Enchantment.KNOCKBACK, 1, true);
		weapM.addEnchant(Enchantment.DURABILITY, 3, true);
		weapM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		weap.setItemMeta(weapM);
		
		//
		// Création des ArmorEffects
		//
			// Une list est requis pour créer un ArmorEffect Donc nous devons créer plein de List
			
			// List pour le Casque
			ArrayList<ItemStack> helmList = new ArrayList<ItemStack>();
			helmList.add(helm);
			
			// List pour le Plastron
			ArrayList<ItemStack> chestList = new ArrayList<ItemStack>();
			chestList.add(chest);
			
			// List pour les Jambières
			ArrayList<ItemStack> legsList = new ArrayList<ItemStack>();
			legsList.add(legs);
			
			// List pour les Bottes
			ArrayList<ItemStack> bootsList = new ArrayList<ItemStack>();
			bootsList.add(boots);
			
			// List pour l'arme
			ArrayList<ItemStack> weapList = new ArrayList<ItemStack>();
			weapList.add(weap);
			
			//List pour l'armure sans l'arme
			ArrayList<ItemStack> setList = new ArrayList<ItemStack>();
			setList.add(helm);
			setList.add(chest);
			setList.add(legs);
			setList.add(boots);
			
			// List pour l'armure + l'arme
			ArrayList<ItemStack> fullSetList = new ArrayList<ItemStack>();
			fullSetList.add(helm);
			fullSetList.add(chest);
			fullSetList.add(legs);
			fullSetList.add(boots);
			fullSetList.add(weap);
			
			//
			// List des effets
			//
			// Elle va être modifier pour chaque ArmorEffect qui a des effets différents 
			ArrayList<ArmorEffectType> effectList = new ArrayList<ArmorEffectType>();
			effectList.add(ArmorEffectType.FIRE_RESISTANCE);
			new ArmorEffect(setList, effectList, "DemoniaqueSet");
			effectList.clear();
			effectList.add(ArmorEffectType.VAMPIRE);
			new ArmorEffect(fullSetList, effectList, "DemoniaqueFullSet");
			effectList.clear();
			
			effectList.add(ArmorEffectType.WATER_DAMAGE);
			
			new ArmorEffect(helmList, effectList, "DemoniaqueHelm");
			new ArmorEffect(chestList, effectList, "DemoniaqueChest");
			new ArmorEffect(legsList, effectList, "DemoniaqueLegs");
			
			effectList.add(ArmorEffectType.SCYTHE_DAMAGE);
			new ArmorEffect(bootsList, effectList, "DemoniaqueBoots");
			
			new ArmorEffect(weapList, effectList, "DemoniaqueScythe");

	}
	
	private static void generateTitanesqueArmor() {
		
	//
	// Création des Items
	//
		
		ArrayList<String> lore = new ArrayList<String>();

		lore.add("§3➜ §bRareté : §3✰✰✰✰§f✰");
		lore.add("§7------------------------------");
		lore.add("§8• §aDégâts augmentés");
		lore.add("§8• §cRalentissement");
		lore.add("");
		lore.add("§c/armures §7pour plus d'infos");
		
		// Casque Titanesque
		
		ItemStack helm = new ItemStack(Material.IRON_HELMET);
		ItemMeta helmM = helm.getItemMeta();
		helmM.setDisplayName("§3➜ §3Casque §bTitanesque");
		helmM.setLore(lore);
		helmM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		helmM.addEnchant(Enchantment.DURABILITY, 3, true);
		helmM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		helm.setItemMeta(helmM);

		
		// Plastron Titanesque
		
		ItemStack chest = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta chestM = chest.getItemMeta();
		chestM.setDisplayName("§3➜ §3Plastron §bTitanesque");
		chestM.setLore(lore);
		chestM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		chestM.addEnchant(Enchantment.DURABILITY, 3, true);
		chestM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		chest.setItemMeta(chestM);
		
		// Jambières Titanesques
		
		ItemStack legs = new ItemStack(Material.IRON_LEGGINGS);
		ItemMeta legsM = legs.getItemMeta();
		legsM.setDisplayName("§3➜ §3Jambières §bTitanesques");
		legsM.setLore(lore);
		legsM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		legsM.addEnchant(Enchantment.DURABILITY, 3, true);
		legsM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		legs.setItemMeta(legsM);

		// Bottes Titanesques
		
		ItemStack boots = new ItemStack(Material.IRON_BOOTS);
		ItemMeta bootsM = boots.getItemMeta();
		bootsM.setDisplayName("§3➜ §3Bottes §bTitanesques");
		bootsM.setLore(lore);
		bootsM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		bootsM.addEnchant(Enchantment.DURABILITY, 3, true);
		bootsM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		boots.setItemMeta(bootsM);

		// Épée Titanesque
		
		ItemStack weap = new ItemStack(Material.IRON_SWORD);
		ItemMeta weapM = weap.getItemMeta();
		weapM.setDisplayName("§3➜ §3Épée §bTitanesques");
		weapM.setLore(lore);
		weapM.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
		weapM.addEnchant(Enchantment.KNOCKBACK, 1, true);
		weapM.addEnchant(Enchantment.DURABILITY, 3, true);
		weapM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		weap.setItemMeta(weapM);
		
		//
		// Création des ArmorEffects
		//
			// Une list est requis pour créer un ArmorEffect Donc nous devons créer plein de List
			
			// List pour le Casque
			ArrayList<ItemStack> helmList = new ArrayList<ItemStack>();
			helmList.add(helm);
			
			// List pour le Plastron
			ArrayList<ItemStack> chestList = new ArrayList<ItemStack>();
			chestList.add(chest);
			
			// List pour les Jambières
			ArrayList<ItemStack> legsList = new ArrayList<ItemStack>();
			legsList.add(legs);
			
			// List pour les Bottes
			ArrayList<ItemStack> bootsList = new ArrayList<ItemStack>();
			bootsList.add(boots);
			
			// List pour l'arme
			ArrayList<ItemStack> weapList = new ArrayList<ItemStack>();
			weapList.add(weap);
			
			//List pour l'armure sans l'arme
			ArrayList<ItemStack> setList = new ArrayList<ItemStack>();
			setList.add(helm);
			setList.add(chest);
			setList.add(legs);
			setList.add(boots);
			
			// List pour l'armure + l'arme
			ArrayList<ItemStack> fullSetList = new ArrayList<ItemStack>();
			fullSetList.add(helm);
			fullSetList.add(chest);
			fullSetList.add(legs);
			fullSetList.add(boots);
			fullSetList.add(weap);
			
			//
			// List des effets
			//
			// Elle va être modifier pour chaque ArmorEffect qui a des effets différents 
			ArrayList<ArmorEffectType> effectList = new ArrayList<ArmorEffectType>();
			
			new ArmorEffect(setList, effectList, "TitanesqueSet");
			new ArmorEffect(fullSetList, effectList, "TitanesqueFullSet");
			
			effectList.add(ArmorEffectType.SLOWNESS);
			effectList.add(ArmorEffectType.DAMAGE_MULTIPLICATION);
			new ArmorEffect(weapList, effectList, "TitanesqueSword");

			new ArmorEffect(helmList, effectList, "TitanesqueHelm");
			new ArmorEffect(chestList, effectList, "TitanesqueChest");
			new ArmorEffect(legsList, effectList, "TitanesqueLegs");
			new ArmorEffect(bootsList, effectList, "TitanesqueBoots");

	}
	
	private static void generateMonstrueuseArmor() {
		
	//
	// Création des Items
	//
		
		ArrayList<String> lore = new ArrayList<String>();

		lore.add("§c➜ §6Rareté : §c✰✰✰✰§f✰");
		lore.add("§7------------------------------");
		lore.add("§8• §aPoison");
		lore.add("§8• §aLooting Custom");
		lore.add("§8• §aProtection contre les Mobs");
		lore.add("§8• §cFaible contre les Joueurs");
		lore.add("");
		lore.add("§c/armures §7pour plus d'infos");
		
		// Casque Monstreux
		
		ItemStack helm = new ItemStack(Material.IRON_HELMET);
		ItemMeta helmM = helm.getItemMeta();
		helmM.setDisplayName("§c➜ §6Casque §cMonstrueux");
		helmM.setLore(lore);
		helmM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		helmM.addEnchant(Enchantment.DURABILITY, 3, true);
		helmM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		helm.setItemMeta(helmM);

		// Plastron Monstreux
		
		ItemStack chest = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta chestM = chest.getItemMeta();
		chestM.setDisplayName("§c➜ §6Plastron §cMonstrueux");
		chestM.setLore(lore);
		chestM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		chestM.addEnchant(Enchantment.DURABILITY, 3, true);
		chestM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		chest.setItemMeta(chestM);

		// Jambières Monstreuses
		
		ItemStack legs = new ItemStack(Material.IRON_LEGGINGS);
		ItemMeta legsM = legs.getItemMeta();
		legsM.setDisplayName("§c➜ §6Jambières §cMonstrueuses");
		legsM.setLore(lore);
		legsM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		legsM.addEnchant(Enchantment.DURABILITY, 3, true);
		legsM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		legs.setItemMeta(legsM);

		// Bottes Monstreuses
		
		ItemStack boots = new ItemStack(Material.IRON_BOOTS);
		ItemMeta bootsM = boots.getItemMeta();
		bootsM.setDisplayName("§c➜ §6Bottes §cMonstrueuses");
		bootsM.setLore(lore);
		bootsM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
		bootsM.addEnchant(Enchantment.DURABILITY, 3, true);
		bootsM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		boots.setItemMeta(bootsM);

		// Hache Monstreuse
		
		ItemStack weap = new ItemStack(Material.IRON_AXE);
		ItemMeta weapM = weap.getItemMeta();
		weapM.setDisplayName("§c➜ §6Hache §cMonstrueuse");
		weapM.setLore(lore);
		weapM.addEnchant(Enchantment.DAMAGE_ALL, 6, true);
		weapM.addEnchant(Enchantment.LOOT_BONUS_MOBS, 3, true);
		weapM.addEnchant(Enchantment.DURABILITY, 3, true);
		weapM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		weap.setItemMeta(weapM);

		//
		// Création des ArmorEffects
		//
			// Une list est requis pour créer un ArmorEffect Donc nous devons créer plein de List
			
			// List pour le Casque
			ArrayList<ItemStack> helmList = new ArrayList<ItemStack>();
			helmList.add(helm);
			
			// List pour le Plastron
			ArrayList<ItemStack> chestList = new ArrayList<ItemStack>();
			chestList.add(chest);
			
			// List pour les Jambières
			ArrayList<ItemStack> legsList = new ArrayList<ItemStack>();
			legsList.add(legs);
			
			// List pour les Bottes
			ArrayList<ItemStack> bootsList = new ArrayList<ItemStack>();
			bootsList.add(boots);
			
			// List pour l'arme
			ArrayList<ItemStack> weapList = new ArrayList<ItemStack>();
			weapList.add(weap);
			
			//List pour l'armure sans l'arme
			ArrayList<ItemStack> setList = new ArrayList<ItemStack>();
			setList.add(helm);
			setList.add(chest);
			setList.add(legs);
			setList.add(boots);
			
			// List pour l'armure + l'arme
			ArrayList<ItemStack> fullSetList = new ArrayList<ItemStack>();
			fullSetList.add(helm);
			fullSetList.add(chest);
			fullSetList.add(legs);
			fullSetList.add(boots);
			fullSetList.add(weap);
			
			//
			// List des effets
			//
			// Elle va être modifier pour chaque ArmorEffect qui a des effets différents 
			ArrayList<ArmorEffectType> effectList = new ArrayList<ArmorEffectType>();
			
			new ArmorEffect(setList, effectList, "MonstrueuxSet");
			new ArmorEffect(fullSetList, effectList, "MonstrueuxFullSet");
			
			effectList.add(ArmorEffectType.PLAYER_WEAKNESS);
			effectList.add(ArmorEffectType.MOBS_PROTECTION);
			effectList.add(ArmorEffectType.LOOTING_INCREASE);
			
			new ArmorEffect(helmList, effectList, "MonstrueuxHelm");
			new ArmorEffect(chestList, effectList, "MonstrueuxChest");
			new ArmorEffect(legsList, effectList, "MonstrueuxLegs");
			new ArmorEffect(bootsList, effectList, "MonstrueuxBoots");
			
			effectList.add(ArmorEffectType.POISON);
			new ArmorEffect(weapList, effectList, "MonstrueuxAxe");


	}
	
}
