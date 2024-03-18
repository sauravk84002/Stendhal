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

import static org.junit.Assert.assertEquals;
import static utilities.SpeakerNPCTestHelper.getReply;

import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;

import games.stendhal.server.core.engine.SingletonRepository;
import games.stendhal.server.maps.semos.library.HistorianGeographerNPC;
import games.stendhal.server.core.engine.StendhalRPZone;
import games.stendhal.server.entity.npc.SpeakerNPC;
import games.stendhal.server.entity.player.Player;
import utilities.PlayerTestHelper;
import games.stendhal.server.entity.npc.fsm.Engine;
import utilities.QuestHelper;

public class MeetZynnTest {
	
	private AbstractQuest quest;
	private Player player = null;
	private SpeakerNPC npc = null;
	private Engine en = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		QuestHelper.setUpBeforeClass();
	}
	
	@Before
	public void setUp() {
		final StendhalRPZone gameZone = new StendhalRPZone("admin_test");
		new HistorianGeographerNPC().configureZone(gameZone, null);
		npc = SingletonRepository.getNPCList().get("Zynn Iwuhos");
		en = npc.getEngine();
		quest = new MeetZynn();
		quest.addToWorld();
		player = PlayerTestHelper.createPlayer("Rohan");
	}
	
	@Test
	public void XPFromDialogueTest() {
		// calculates final xp after interacting with Zynn
		player.setXP(200);
		en.step(player, "Hi");
		en.step(player, "history");
		assertEquals("At present, there are two significant powers on Faiumoni; the Deniran Empire, and the dark legions of Blordrough. Blordrough has recently conquered the south of the island, seizing several steel mines and a large gold mine. At present, Deniran still controls the central and northern parts of Faiumoni, including several gold and mithril mines.", getReply(npc));
		
		en.step(player, "Nalwor");
		assertEquals("Nalwor is an ancient elven city, built deep inside the forest to the southeast of us long before humans ever arrived on this island. Elves don't like mixing with other races, but we're given to understand that Nalwor was built to help defend their capital city of Teruykeh against an evil force.", getReply(npc));
		
		en.step(player, "levels");		
		assertEquals("Maps are split into levels according to the height of that particular area above or below the surface. Areas on the surface are at level 0. The level number is the first thing in a map's name. For instance, #Semos itself is at ground level, so it is level 0; its map is called \"0_semos_city\". The first level of the dungeon beneath us is at level -1, so its map is called \"-1_semos_dungeon\". You should note, though, that a map of a building's interior will usually have the level at the end of the name instead, with \"int\" (for \"interior\") at the start. For instance, the upstairs floor of the tavern would be mapped out as \"int_semos_tavern_1\".", getReply(npc));
		
		en.step(player, "naming");
		assertEquals("Each map is usually split up into \"sets\" of zones, with a central feature that is used as a reference point. The zones surrounding this central zone are named by the direction in which they lie from it. For instance, from the central zone \"0_semos_city\", you can travel west to the old village at \"0_semos_village_w\", or you could travel two zones north and one west to the mountains at \"0_semos_mountain_n2_w\".", getReply(npc));
		
		assertEquals(240, player.getXP());
		
	}
}
