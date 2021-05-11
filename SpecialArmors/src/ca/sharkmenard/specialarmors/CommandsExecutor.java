package ca.sharkmenard.specialarmors;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandsExecutor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String intro = "§8[§cSpecial§5Armors§8]§r ";
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(label.equalsIgnoreCase("specialarmor") || label.equalsIgnoreCase("specialarmors") || label.equalsIgnoreCase("sa")) {
				if(p.hasPermission("specialarmors.give")) {
					if(args.length == 2 && args[0].equalsIgnoreCase("give")){
						boolean isFound = false;
						for(ArmorEffect ae : Main.getArmorHandler().getArmorList()) {
							if(!isFound && ae.getArmorName().equalsIgnoreCase(args[1])) {
								for(ItemStack items : ae.getGearToList()) {
									p.getInventory().addItem(items);
									isFound = true;
								}
							}
						}
						if(!isFound) {
							p.sendMessage(intro + "§cIl n'y a aucune armure/pièces d'armures qui porte ce nom !");
						}else {
							p.sendMessage(intro + "§aVous avez reçu une/des pièce(s) d'armure(s)");
						}
					}else {
						p.sendMessage(intro + "§7Usage Correct: /sa give <ArmorName>");
					}
					
				}else {
					p.sendMessage(intro + "§cVous n'avez pas la permission d'effectuer cette commande !");
				}
				
			}
		}
		return false;
	}

}
