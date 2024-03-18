package games.stendhal.server.maps.atlantis.cityinside;

import static org.junit.Assert.assertTrue;



import org.junit.BeforeClass;
import org.junit.Test;


import games.stendhal.server.core.engine.StendhalRPWorld;
import games.stendhal.server.core.engine.StendhalRPZone;
import utilities.QuestHelper;
import utilities.ZonePlayerAndNPCTestImpl;


public class Blackboard extends ZonePlayerAndNPCTestImpl {
	
	
	PotionsDealerNPC Speakernpc = new PotionsDealerNPC(); 

	private static final String ZONE_NAME = "test_blackboard";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		QuestHelper.setUpBeforeClass();
		setupZone(ZONE_NAME, false);
	}

	public Blackboard() {
		setNpcNames("Mirielle");
		setZoneForPlayer(ZONE_NAME);
		addZoneConfigurator(new PotionsDealerNPC(), ZONE_NAME);
	}
	
	
	@Test
	public void testBlackboardEntity() {
		StendhalRPZone zone = new StendhalRPZone ("Mirielle");
		final StendhalRPWorld world = StendhalRPWorld.get();
		world.addRPZone(zone);
		PotionsDealerNPC npc = new PotionsDealerNPC();
		npc.configureZone(zone, null);
		

		

		assertTrue(zone.getEntityAt(7, 7).getClass() != null);
		

		
	}
	
}