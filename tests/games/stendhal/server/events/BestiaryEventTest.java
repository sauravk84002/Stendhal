package games.stendhal.server.events;

//import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


//import games.stendhal.server.entity.item.Bestiary;

import games.stendhal.server.entity.player.*;
import org.junit.Test;
import utilities.PlayerTestHelper;

public class BestiaryEventTest {

	@Test
	public void testBestiaryEvent() { 
		Player player = PlayerTestHelper.createPlayer("player");
		BestiaryEvent event = new BestiaryEvent(player,false,false);
		assertEquals("",event.get("enemies"));
	}

}
