package ca.sharkmenard.specialarmors;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

public class EffectPoisonRunnable {
	
	private LivingEntity ent;
	private BukkitTask task;
	private int tickLeft;
	
	public EffectPoisonRunnable(Entity e, Player p) {
		if(!(e instanceof Player))
			if(e instanceof LivingEntity) {
				ent = (LivingEntity) e;
				if(!ent.hasMetadata("PoisonEffect")) {
					ent.setMetadata("PoisonEffect", new FixedMetadataValue((Plugin) Main.getInstance(), "60"));
					tickLeft = ent.getMetadata("PoisonEffect").get(0).asInt();
					task = Bukkit.getServer().getScheduler().runTaskTimer(Main.getInstance(), new Runnable() {

						@Override
						public void run() {
							double timeLeft = ((double) (tickLeft)) / 20.0D;
							if(ent.isDead()) {
								task.cancel();
							}
							if(timeLeft == 2.5D) {
								ent.damage(1.0D, p);
							}
							if(timeLeft == 1.0D) {
								ent.damage(1.0D, p);
							}
							if(tickLeft > 0) {
								tickLeft--;
							}else {
								ent.removeMetadata("PoisonEffect", Main.getInstance());
								task.cancel();
							}
						}
					}, 0, 1L);
				}
			}
	}
}
