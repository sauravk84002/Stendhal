/* $Id$ */
/***************************************************************************
 *                   (C) Copyright 2003-2010 - Stendhal                    *
 ***************************************************************************
 ***************************************************************************
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *                                                                         *
 ***************************************************************************/
package games.stendhal.server.maps.quests;

import static org.junit.Assert.*;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertTrue;

//import java.util.LinkedList;
//import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import games.stendhal.server.entity.player.Player;

//import games.stendhal.server.core.engine.SingletonRepository;
import games.stendhal.server.core.engine.StendhalRPZone;

//import games.stendhal.server.entity.item.token.Token;

import games.stendhal.server.entity.mapstuff.portal.Door;
import games.stendhal.server.entity.mapstuff.sign.Sign;
import games.stendhal.server.entity.npc.NPCList;
import games.stendhal.server.maps.MockStendlRPWorld;

import marauroa.common.game.RPClass;
import utilities.PlayerTestHelper;
import utilities.QuestHelper;


public class ReverseArrowTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		MockStendlRPWorld.get();
		QuestHelper.setUpBeforeClass();
		StendhalRPZone zone = new StendhalRPZone("int_ados_reverse_arrow");
		MockStendlRPWorld.get().addRPZone(zone);
		MockStendlRPWorld.get().addRPZone(new StendhalRPZone("0_semos_mountain_n2"));
		

		if (!RPClass.hasRPClass("door")) {
			Door.generateRPClass();
		}
		if (!RPClass.hasRPClass("sign")) {
			Sign.generateRPClass();
		}

	}
	
	//protected List<Token> tokens;
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		MockStendlRPWorld.reset();
		NPCList.get().clear();
	}


	/**
	 * Tests for getSlotName.
	 */
	@Test
	public void testGetSlotName() {
		assertEquals("reverse_arrow", new ReverseArrow().getSlotName());
	}
	



/**
	 * Tests for reverseArrow.
	 */
	@Test
	public void testReverseArrow() {
		ReverseArrow arrowquest = new ReverseArrow();
		
		arrowquest.addToWorld();
		
		Player player = PlayerTestHelper.createPlayer("bob");
		
		player.teleport(arrowquest.zone, 0, 0, null, null);
		player.onAdded(arrowquest.zone);
		
		arrowquest.start(player);
		
		//invoke the position of the current token in order to test the validation
		int tx_0 = arrowquest.tokens.get(0).getX();
		int tx_4 = arrowquest.tokens.get(4).getX();
		int tx_8 = arrowquest.tokens.get(8).getX();
		
		int ty_0 = arrowquest.tokens.get(0).getY();
		int ty_4 = arrowquest.tokens.get(4).getY();
		int ty_8 = arrowquest.tokens.get(8).getY();
		
		//new condition created
		arrowquest.tokens.get(0).setPosition(tx_0, ty_0+1);
		arrowquest.tokens.get(4).setPosition(tx_4, ty_4+1);
		arrowquest.tokens.get(8).setPosition(tx_8, ty_8-3);
		
		ReverseArrow.ReverseArrowCheck arrowcheck = arrowquest.new ReverseArrowCheck();
		
		arrowcheck.onTurnReached(3); //last turn
		
		assertEquals(true, arrowquest.player.isQuestCompleted("reverse_arrow"));
	}
	
	
	
	
	
	/**
	 * Tests for reverseArrow.
	 */
	@Test
	public void testReverseArrow2() {
		ReverseArrow arrowquest = new ReverseArrow();
		
		arrowquest.addToWorld();
		
		Player player = PlayerTestHelper.createPlayer("bob");
		
		player.teleport(arrowquest.zone, 0, 0, null, null);
		player.onAdded(arrowquest.zone);
		
		arrowquest.start(player);
		
		//invoke the position of the current token in order to test the validation
		int tx_5 = arrowquest.tokens.get(5).getX();
		int tx_7 = arrowquest.tokens.get(7).getX();
		int tx_8 = arrowquest.tokens.get(8).getX();
		
		int ty_5 = arrowquest.tokens.get(5).getY();
		int ty_7 = arrowquest.tokens.get(7).getY();
		int ty_8 = arrowquest.tokens.get(8).getY();
		
		//new condition created
		arrowquest.tokens.get(5).setPosition(tx_5, ty_5-2);
		arrowquest.tokens.get(7).setPosition(tx_7, ty_7-2);
		arrowquest.tokens.get(8).setPosition(tx_8, ty_8-4);
		
		ReverseArrow.ReverseArrowCheck arrowcheck = arrowquest.new ReverseArrowCheck();
		
		arrowcheck.onTurnReached(3); //last turn
		
		assertEquals(true, arrowquest.player.isQuestCompleted("reverse_arrow"));
	}
	
	
	

	/**
	 * Tests for addToWorld.
	 */
	@Test
	public void testAddToWorld() {

		ReverseArrow arrowquest = new ReverseArrow();
		arrowquest.addToWorld();
	}

	/**
	 * Tests for finish.
	 */
	@Test
	public void testFinish() {
		ReverseArrow arrowquest = new ReverseArrow();
		arrowquest.addToWorld();
		arrowquest.player = PlayerTestHelper.createPlayer("bob");
		assertNotNull(arrowquest.player);
		arrowquest.finish(false, null);
		assertNotNull(arrowquest.player);

		arrowquest.finish(true, null);
		assertNull(arrowquest.player);
	}

}
