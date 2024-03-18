package games.stendhal.server.entity.player;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import games.stendhal.server.core.engine.StendhalRPZone;

import utilities.PlayerTestHelper;

public class TOURtest {
	private String playername = "player";
	private Player player;	
	private Player killer;
	private StendhalRPZone zone;
	
	
	@Test 
	public void checkinvisible() {
		zone = new StendhalRPZone("0_nalwor_city");
		player = PlayerTestHelper.createPlayer(playername);
		zone.add(player);
		player.teleport(zone, 200, 200, null, player);
		player.tour();
		assertEquals(false,player.isInvisibleToCreatures());

				
	}
	
	@Test
	public void toofarfromtour() {
		zone = new StendhalRPZone("0_nalwor_city");
		player = PlayerTestHelper.createPlayer(playername);
		zone.add(player);
		player.teleport(zone, 200, 200, null, player);
		player.tour();
		assertEquals(30.0,player.getX(),30.001);
		assertEquals(30.0,player.getY(),30.001);
	}

}

