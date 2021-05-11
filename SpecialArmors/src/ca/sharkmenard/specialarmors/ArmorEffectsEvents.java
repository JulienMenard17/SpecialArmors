package ca.sharkmenard.specialarmors;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class ArmorEffectsEvents implements Listener {
	
	@EventHandler
	public void onDamageToVampire(EntityDamageByEntityEvent e) {
		if(!e.isCancelled()) {
			if(e.getDamager() instanceof Player) {
				Player p = (Player) e.getDamager();
				callApplyEvent(ArmorEffectType.VAMPIRE, e, p);
			}
		}
	}
	
	@EventHandler
	public void onDamageToScytheDamage(EntityDamageByEntityEvent e) {
		if(!e.isCancelled()) {
			if(e.getDamager() instanceof Player) {
				Player p = (Player) e.getDamager();
				callApplyEvent(ArmorEffectType.SCYTHE_DAMAGE, e, p);
			}
		}
	}
	
	@EventHandler
	public void onDamageToDamageMultiplication(EntityDamageByEntityEvent e) {
		if(e.isCancelled()) {
			if(e.getDamager() instanceof Player) {
				Player p = (Player) e.getDamager();
				double basicDamage = e.getDamage();
				callApplyEvent(ArmorEffectType.DAMAGE_MULTIPLICATION, e, p);
				double modifiedDamage = e.getDamage();
				double damageMultiplicator = modifiedDamage - basicDamage;
				double finalRawDamage = basicDamage + (basicDamage * (damageMultiplicator * 0.1D));
				e.setDamage(finalRawDamage);
				
			}
		}
	}
	@EventHandler
	public void onDamageToMobsProtection(EntityDamageByEntityEvent e) {
		if(!e.isCancelled()) {
			if(e.getEntity() instanceof Player) {
				Player p = (Player) e.getEntity();
				double basicDamage = e.getDamage();
				callApplyEvent(ArmorEffectType.MOBS_PROTECTION, e, p);
				double modifiedDamage = e.getDamage();
				double damageMultiplicator = modifiedDamage - basicDamage;
				double finalRawDamage = basicDamage - (basicDamage * (damageMultiplicator * 0.2D));
					e.setDamage(finalRawDamage);
			}
		}
	}
	
	@EventHandler
	public void onDamageToPlayerWeakness(EntityDamageByEntityEvent e) {
		if(!e.isCancelled()) {
			if(e.getEntity() instanceof Player) {
				if(e.getDamager() instanceof Player) {
				Player p = (Player) e.getEntity();
				double basicDamage = e.getDamage();
				callApplyEvent(ArmorEffectType.PLAYER_WEAKNESS, e, p);
				double modifiedDamage = e.getDamage();
				double damageMultiplicator = modifiedDamage - basicDamage;
				double finalRawDamage = basicDamage + (basicDamage * (damageMultiplicator * 0.1D));
					e.setDamage(finalRawDamage);
				}
			}
		}
	}
	
	@EventHandler
	public void onDamageToPoison(EntityDamageByEntityEvent e) {
		if(!e.isCancelled()) {
			if(e.getDamager() instanceof Player) {
				Player p = (Player) e.getDamager();
				callApplyEvent(ArmorEffectType.POISON, e, p);
			}
		}
	}
	
	@EventHandler
	public void onDamageToFireDamageIncreaseAndFireResistance(EntityDamageEvent e) {
		if(!e.isCancelled()) {
			if(e.getEntity() instanceof Player) {
				Player p = (Player) e.getEntity();
				if(e.getCause().equals(DamageCause.FIRE) || e.getCause().equals(DamageCause.FIRE_TICK) || e.getCause().equals(DamageCause.LAVA)) {
					callApplyEvent(ArmorEffectType.FIRE_RESISTANCE, e, p);
				}
				if(e.getCause().equals(DamageCause.FIRE) || e.getCause().equals(DamageCause.FIRE_TICK) || e.getCause().equals(DamageCause.LAVA)) {
					double basicDamage = e.getDamage();
					callApplyEvent(ArmorEffectType.FIRE_DAMAGE_INCREASE, e, p);
					double modifiedDamage = e.getDamage();
					double damageMultiplicator = modifiedDamage - basicDamage;
					double finalRawDamage = basicDamage + (basicDamage * (damageMultiplicator * 0.2D ));
					e.setDamage(finalRawDamage);
				}
			}
		}
	}
	
	@EventHandler
	public void exthinguishAttemptWhileFireResistanceOff(PlayerCommandPreprocessEvent e) {
		if(!e.isCancelled())
			if(e.getPlayer().hasPermission("essentials.ext") && e.getPlayer().hasPermission("essentials.*")) {
				String str = e.getMessage().toString().split(" ")[0];
				if(str.equalsIgnoreCase("/ext") || str.equalsIgnoreCase("/extinguish") || str.equalsIgnoreCase("/essentials:extinguish") || str.equalsIgnoreCase("/essentials:ext")) {
					callApplyEvent(ArmorEffectType.FIRE_RESISTANCE_OFF, e, e.getPlayer());
				}
			}
	}
	
	@EventHandler
	public void onFireResistancePotionToFireResistanceOff(PlayerItemConsumeEvent e){
		if(!e.isCancelled()) {
			Player p = e.getPlayer();
			callApplyEvent(ArmorEffectType.FIRE_RESISTANCE_OFF, e, p);
		}
		
	}
	
	@EventHandler
	public void onKillToLootingIncrease(EntityDeathEvent e) {
		if(e.getEntity().getKiller() != null) {
			Player p = e.getEntity().getKiller();
			callOnceApplyEvent(ArmorEffectType.LOOTING_INCREASE, e, p);
		}
		
	}
	
	
	public void callApplyEvent(ArmorEffectType aeType, Event e, Player p) {
		for(PlayerEffects pe : Main.getPlayerEffectsHandler().getList()) {
			if(pe.getPlayer().equals(p)) {
				for(ArmorEffect ae : pe.getPlayerEffects()) {
					for(ArmorEffectType eType : ae.getEffectsList()) {
						if(eType.equals(aeType)) {
							eType.applyEvent(e);
						}
					}
				}
			}
		}
	}
	public void callOnceApplyEvent(ArmorEffectType aeType, Event e, Player p) {
		for(PlayerEffects pe : Main.getPlayerEffectsHandler().getList()) {
			if(pe.getPlayer().equals(p)) {
				for(ArmorEffect ae : pe.getPlayerEffects()) {
					for(ArmorEffectType eType : ae.getEffectsList()) {
						if(eType.equals(aeType)) {
							eType.applyEvent(e);
							return;
						}
					}
				}
			}
		}
	}

}
