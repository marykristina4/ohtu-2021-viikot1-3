/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
//import org.junit.*;
//import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class StatisticsTest {
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
    
    Statistics stats;
    
    
    public StatisticsTest() {
    }
    

    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hakuOikein() {
        //stats.search(Kurri);
    assertEquals("Kurri", stats.search("Kurri").getName());
    }
        @Test
    public void hakuEiOikein() {
        //stats.search(Kurri);
    assertEquals(null, stats.search("Kutti"));
    }
          @Test
    public void hakuTeamOikein() {
        //stats.search(Kurri);
    assertEquals(3, stats.team("EDM").size());
    }
           @Test
    public void hakuScorersOikein() {
        //stats.search(Kurri);
    assertEquals(3, stats.topScorers(3).size());
    }
        
}
