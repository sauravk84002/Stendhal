package games.stendhal.server.entity.player;

import org.junit.Test;
import utilities.PlayerTestHelper;

import static org.junit.Assert.assertEquals;


public class TeleportToTourTest{
	
	@Test
	public void TeleportTest() {;
	Player player = PlayerTestHelper.createPlayer("player");
	player.TeleportToTour();
	assertEquals(100.0, player.getX(), 100.001);
	assertEquals(30.0, player.getY(), 30.001);
	}

	@Test
	public void InvisTest() {;
	Player player = PlayerTestHelper.createPlayer("player");
	player.TeleportToTour();
	assertEquals(true,(player.isInvisibleToCreatures()));
	}
	
}