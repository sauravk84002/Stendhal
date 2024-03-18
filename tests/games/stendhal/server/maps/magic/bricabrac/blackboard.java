package games.stendhal.server.maps.magic.bricabrac;

import static org.junit.Assert.assertTrue;



import org.junit.BeforeClass;
import org.junit.Test;


import games.stendhal.server.core.engine.StendhalRPWorld;
import games.stendhal.server.core.engine.StendhalRPZone;
import utilities.QuestHelper;
import utilities.ZonePlayerAndNPCTestImpl;


public class blackboard extends ZonePlayerAndNPCTestImpl {
	
	
	BuyerNPC Speakernpc = new BuyerNPC(); 

	private static final String ZONE_NAME = "test_blackboard";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		QuestHelper.setUpBeforeClass();
		setupZone(ZONE_NAME, false);
	}

	public blackboard() {
		setNpcNames("vonda");
		setZoneForPlayer(ZONE_NAME);
		addZoneConfigurator(new BuyerNPC(), ZONE_NAME);
	}
	
	
	@Test
	public void testBlackboardEntity() {
		StendhalRPZone zone = new StendhalRPZone ("vonda");
		final StendhalRPWorld world = StendhalRPWorld.get();
		world.addRPZone(zone);
		BuyerNPC npc = new BuyerNPC();
		npc.configureZone(zone, null);
		
		
		assertTrue(zone.getEntityAt(10, 10).getClass() != null);
		

		
	}
	
}