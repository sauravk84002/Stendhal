package games.stendhal.server.maps.deniran.cityinterior.potionsshop;
import static org.junit.Assert.assertTrue;



import org.junit.BeforeClass;
import org.junit.Test;


import games.stendhal.server.core.engine.StendhalRPWorld;
import games.stendhal.server.core.engine.StendhalRPZone;
import utilities.QuestHelper;
import utilities.ZonePlayerAndNPCTestImpl;


public class BlackboardTest extends ZonePlayerAndNPCTestImpl {
	
	
	PotionsDealerNPC Speakernpc = new PotionsDealerNPC(); 

	private static final String ZONE_NAME = "test_blackboard";
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		QuestHelper.setUpBeforeClass();
		setupZone(ZONE_NAME, false);
	}

	public BlackboardTest() {
		setNpcNames("wanda");
		setZoneForPlayer(ZONE_NAME);
		addZoneConfigurator(new PotionsDealerNPC(), ZONE_NAME);
	}
	
	
	@Test
	public void testBlackboardEntity() {
		StendhalRPZone zone = new StendhalRPZone ("wanda");
		final StendhalRPWorld world = StendhalRPWorld.get();
		world.addRPZone(zone);
		PotionsDealerNPC npc = new PotionsDealerNPC();
		npc.configureZone(zone, null);
		

		
		assertTrue(zone.getEntityAt(5, 6).getClass() != null);
		assertTrue(zone.getEntityAt(10, 6).getClass() != null);
		

		
	}
	
}