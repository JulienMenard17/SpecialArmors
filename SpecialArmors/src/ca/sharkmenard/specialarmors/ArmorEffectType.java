package ca.sharkmenard.specialarmors;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import ca.sharkmenard.specialarmors.effects.*;


public enum ArmorEffectType {
	
	HEALTH_BOOST(HealthBoost.class),
	FIRE_RESISTANCE_OFF(FireResistanceOff.class),
	FIRE_DAMAGE_INCREASE(FireDamageIncrease.class),
	SLOWNESS(Slowness.class),
	DAMAGE_MULTIPLICATION(DamageMultiplication.class),
	FIRE_RESISTANCE(FireResistance.class),
	VAMPIRE(Vampire.class),
	WATER_DAMAGE(WaterDamage.class),
	POISON(Poison.class),
	LOOTING_INCREASE(LootingIncrease.class),
	MOBS_PROTECTION(MobsProtection.class),
	PLAYER_WEAKNESS(PlayerWeakness.class),
	SCYTHE_DAMAGE(ScytheDamage.class);
	
	private final Constructor<? extends Effect> ctor;
	
	private ArmorEffectType(final Class<? extends Effect> effectClass) {
        try {
            this.ctor = effectClass.getConstructor();
        } catch (NoSuchMethodException ex) {
            throw new AssertionError(ex);
        } catch (SecurityException ex) {
            throw new AssertionError(ex);
        }
	}
	
	public void giveEffect(Player p, ArmorEffectType eType, ArrayList<ArmorType> arrayList) {
        try {
    		Method method = ctor.getDeclaringClass().getMethod("applyEffect", Player.class, eType.getClass(), arrayList.getClass());
    			try {
					Object instance = ctor.newInstance();
		    		try {
		    			method.invoke(instance, p, eType, arrayList);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					e1.printStackTrace();
				}
				
        } catch (NoSuchMethodException ex) {
            throw new AssertionError(ex);
        } catch (SecurityException ex) {
            throw new AssertionError(ex);
        }
	}
	
	public void applyEvent(Event e) {
		Object instance1 = null;
		try {
			instance1 = ctor.newInstance();
		} catch (InstantiationException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IllegalAccessException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IllegalArgumentException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (InvocationTargetException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		if(instance1 instanceof EventEffect) {
			 try {
		    		Method method = ctor.getDeclaringClass().getMethod("applyEvent", Event.class);
		    			try {
							Object instance = ctor.newInstance();
				    		try {
				    			method.invoke(instance, e);
							} catch (IllegalAccessException ex) {
								ex.printStackTrace();
							} catch (IllegalArgumentException ex) {
								ex.printStackTrace();
							} catch (InvocationTargetException ex) {
								ex.printStackTrace();
							}
						} catch (InstantiationException ex) {
							ex.printStackTrace();
						} catch (IllegalAccessException e1) {
							e1.printStackTrace();
						} catch (IllegalArgumentException e1) {
							e1.printStackTrace();
						} catch (InvocationTargetException e1) {
							e1.printStackTrace();
						}
						
		        } catch (NoSuchMethodException ex) {
		            throw new AssertionError(ex);
		        } catch (SecurityException ex) {
		            throw new AssertionError(ex);
		        }
		}else{
			Bukkit.getLogger().warning("This Effect is not an EventEffect : " + this.toString());
		}
			
	}

	public void removeEffect(Player p, ArmorEffectType eType, ArrayList<ArmorType> arrayList) {
		try {
    		Method method = ctor.getDeclaringClass().getMethod("removeEffect", Player.class, eType.getClass(), arrayList.getClass());
    			try {
					Object instance = ctor.newInstance();
		    		try {
		    			method.invoke(instance, p, eType, arrayList);
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						e.printStackTrace();
					}
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					e1.printStackTrace();
				}
				
        } catch (NoSuchMethodException ex) {
            throw new AssertionError(ex);
        } catch (SecurityException ex) {
            throw new AssertionError(ex);
        }
	}
	

}
