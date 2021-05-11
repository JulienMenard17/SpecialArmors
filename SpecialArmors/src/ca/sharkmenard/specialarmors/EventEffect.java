package ca.sharkmenard.specialarmors;

import org.bukkit.event.Event;

public interface EventEffect extends Effect {
	
	void applyEvent(Event event);

}
