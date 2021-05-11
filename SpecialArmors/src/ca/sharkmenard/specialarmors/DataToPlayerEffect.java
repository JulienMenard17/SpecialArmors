package ca.sharkmenard.specialarmors;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;

public class DataToPlayerEffect {
	
	public DataToPlayerEffect() {
		ArrayList<String> playersStrList = new ArrayList<String>(Main.getInstance().getData().getStringList("players"));
		for(String pName : playersStrList) {
			ArrayList<String> aeStrList = new ArrayList<String>(Main.getInstance().getData().getStringList(pName));
			for(String aeStr : aeStrList) {
				for(ArmorEffect ae : Main.getArmorHandler().getArmorList()) {
					if(ae.getArmorName().equals(aeStr)) {
						new PlayerEffects(Bukkit.getOfflinePlayer(UUID.fromString(pName)).getPlayer(), ae, true);
					}
				}
			}
		}
		Main.getInstance().saveResource("Data.yml", true);
	}

}
