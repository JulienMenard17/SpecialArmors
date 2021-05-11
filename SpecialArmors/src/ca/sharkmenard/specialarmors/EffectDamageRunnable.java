package ca.sharkmenard.specialarmors;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class EffectDamageRunnable {
	
	private BukkitTask task;
	

	public EffectDamageRunnable() {
		Bukkit.getServer().getScheduler().runTaskTimer(Main.getInstance(), new Runnable() {

			@Override
			public void run() {
				for(PlayerEffects pe : Main.getPlayerEffectsHandler().getList()) {
					for(ArmorEffect ae : pe.getPlayerEffects()) {
						boolean isWaterFound = false;
						if(!isWaterFound)
							for(ArmorEffectType eType : ae.getEffectsList())
								if(!isWaterFound)
									if(eType.equals(ArmorEffectType.WATER_DAMAGE)) {
										isWaterFound = true;
										Player p = pe.getPlayer();
										eType.giveEffect(p, eType, ae.getPiecesType());
									}
					}
				}
			}
		}, 0, 10L);
	}

	public BukkitTask getTask() {
		return task;
	}

	public void cancelTask() {
		this.task.cancel();
	}
	
}
