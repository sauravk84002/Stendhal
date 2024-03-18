package games.stendhal.server.entity.item.scroll;

import games.stendhal.server.entity.item.ConsumableItem;
import games.stendhal.server.entity.player.*;
import org.junit.Test;
import utilities.PlayerTestHelper;
import games.stendhal.server.core.engine.SingletonRepository;
import games.stendhal.server.entity.status.PoisonAttacker;

import static org.junit.Assert.assertEquals;

public class MarkedScrollTest {
	
	@Test
	public void TeleportWhenPoisonedTest() {;
		Player player = PlayerTestHelper.createPlayer("player");
		final MarkedScroll scroll = (MarkedScroll) SingletonRepository.getEntityManager().getItem("marked scroll");
		
		final String poisontype = "greater poison";
		final ConsumableItem poison = (ConsumableItem) SingletonRepository.getEntityManager().getItem(poisontype);
		final PoisonAttacker poisoner = new PoisonAttacker(100, poison);
		poisoner.onAttackAttempt(player, SingletonRepository.getEntityManager().getCreature("snake"));
		
		scroll.useTeleportScroll(player);
		assertEquals("Teleport? Hah! You can barely move! (You cannot teleport when poisoned)", PlayerTestHelper.getPrivateReply(player));
	}
}