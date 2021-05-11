package ca.sharkmenard.specialarmors;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

import net.minecraft.server.v1_8_R3.AttributeInstance;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.GenericAttributes;

public class Main extends JavaPlugin {
	
	private static Main m;
	private File dataFile;
	private FileConfiguration data;
	private File listFile;
	private FileConfiguration list;
	private static ArmorEffectsHandler armorHandler;
	private static PlayerEffectsHandler playerEffectsHandler;
	

	@Override
	public void onEnable() {
		m = this;
		createListConfig();
		createDataConfig();
		armorHandler = new ArmorEffectsHandler();
		playerEffectsHandler = new PlayerEffectsHandler();
		getCommand("specialarmors").setExecutor(new CommandsExecutor());
	/*	EntityPlayer player = (EntityPlayer)((CraftPlayer) Bukkit.getPlayerExact("failaxite")).getHandle();
		AttributeInstance attribute = player.getAttributeInstance(GenericAttributes.maxHealth);
		attribute.setValue(20.0D);
	*/	
		ArmorCreationClass.generateArmors();
		
		new  DataToPlayerEffect();
		
		Bukkit.getPluginManager().registerEvents(new ArmorEquipListener(), this);
		Bukkit.getPluginManager().registerEvents(new ArmorEffectsEvents(), this);
		Bukkit.getServer().getScheduler().runTaskTimer((Plugin) this, new Runnable() {
			
			@Override
			public void run() {
				ArrayList<PlayerEffectRemoval> effectRemoval = new ArrayList<PlayerEffectRemoval>();
				for(PlayerEffects pe : Main.getPlayerEffectsHandler().getList()) {
					Player p = pe.getPlayer();
					for(ArmorEffect ae : pe.getPlayerEffects()) {
						int pieces = 0;
						for(ArmorType aType  : ae.getPiecesType()) {
							int slot = aType.getSlot();
							if(slot == -1) {
								if(Main.matchItem(ae.getGearPiece(aType),p.getItemInHand())) {
									pieces++;
								}									
							}else {
								if(Main.matchItem(ae.getGearPiece(aType),p.getEquipment().getHelmet())) {
									pieces++;
								}
								if(Main.matchItem(ae.getGearPiece(aType),p.getEquipment().getChestplate())) {
									pieces++;
								}
								if(Main.matchItem(ae.getGearPiece(aType),p.getEquipment().getLeggings())) {
									pieces++;
								}
								if(Main.matchItem(ae.getGearPiece(aType),p.getEquipment().getBoots())) {
									pieces++;
								}
							}
						}
						if(ae.getEffectsList().contains(ArmorEffectType.FIRE_RESISTANCE_OFF)) {
							if(p.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)) {
								p.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
							}
						}
						if(pieces != ae.getPiecesType().size()) {
							effectRemoval.add(new PlayerEffectRemoval(pe, ae));
						}
					}
				}
				for(PlayerEffectRemoval per : effectRemoval) {
					for(ArmorEffectType eType : per.getArmorEffect().getEffectsList()) {
						eType.removeEffect(per.getPlayerEffects().getPlayer(), eType, per.getArmorEffect().getPiecesType());
					}
					per.getPlayerEffects().removeArmorEffect(per.getArmorEffect());

				}
				


			}
		}, 0, 1L);
		new EffectDamageRunnable();
	}
	
	@Override
	public void onDisable() {
		ArrayList<String> playerStrList = new ArrayList<String>();
		for(PlayerEffects pe : getPlayerEffectsHandler().getList()) {
			UUID name = pe.getPlayer().getUniqueId();
			ArrayList<ArmorEffect> aeList = pe.getPlayerEffects();
			ArrayList<String> aeListToStrList = new ArrayList<String>();
			for(ArmorEffect ae : aeList) {
				aeListToStrList.add(ae.getArmorName());
			}
			
			playerStrList.add(name.toString());
			
			getData().set(name.toString(), aeListToStrList);
		}
		getData().set("players", playerStrList);
		saveData();
	}
	
	public FileConfiguration getData() {
		return this.data;
	}
	
	public void createDataConfig() {
		dataFile = new File(getDataFolder(), "Data.yml");
		if(!dataFile.exists()) {
			dataFile.getParentFile().mkdirs();
			saveResource("Data.yml", false);
		}

		data = new YamlConfiguration();
		try {
			data.load(dataFile);
		} catch (IOException | InvalidConfigurationException e ) {
			e.printStackTrace();
		}
	}
	
	public void createListConfig() {
		listFile = new File(getDataFolder(), "effectsList.yml");
		if(!listFile.exists()) {
			listFile.getParentFile().mkdirs();
		}
		saveResource("effectsList.yml", true);

		list = new YamlConfiguration();
		try {
			list.load(listFile);
		} catch (IOException | InvalidConfigurationException e ) {
			e.printStackTrace();
		}
	}
	
	public void saveData() {
	    try {
	            data.save(dataFile);
	        } catch (IOException e) {
	            this.getLogger().warning("Unable to save " + "Data.yml"); // shouldn't really happen, but save throws the exception
	        }
	}
	
	public static Main getInstance() {
		return m;
	}
	
	public static ArmorEffectsHandler getArmorHandler() {
		return armorHandler;
	}
	
	public static PlayerEffectsHandler getPlayerEffectsHandler() {
		return playerEffectsHandler;
	}
	
	public static boolean matchItem(ItemStack item1, ItemStack item2) {
		if(item1 != null && item2 != null) {
		ItemStack i1 = new ItemStack(item1);
		ItemStack i2 = new ItemStack(item2);
		if(i1.getType().equals(i2.getType())) {
			if((i1.hasItemMeta() && i2.hasItemMeta()) || (!i1.hasItemMeta() && !i2.hasItemMeta()) ){
				if(i1.hasItemMeta()) {
					ItemMeta m1 = i1.getItemMeta();
					ItemMeta m2 = i2.getItemMeta();
					if((m1.hasDisplayName() && m2.hasDisplayName()) || (!m1.hasDisplayName() && !m2.hasDisplayName()) ) {
						if(m1.hasDisplayName()) {
							if(!m1.getDisplayName().equals(m2.getDisplayName())) return false;
						}
					}else {
						return false;
					}
					
					// A finir
					
					return true;
					
					//
					
					
				}else {
					return true;
				}
			}else {
				return false;
			}
		}
	}

		return false;
	}
	
	public void test(int i) {
		Player pla = Bukkit.getPlayer("SharkMenard17");
		pla.sendMessage("test" + i);

	}
	
	public void test(String i) {
		Player pla = Bukkit.getPlayer("SharkMenard17");
		pla.sendMessage("test - " + i);

	}
}
