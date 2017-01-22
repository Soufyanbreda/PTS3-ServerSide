/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package match2;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Milton van de Sanden
 */
public class MapTest
{
    Map instance;
    
    public MapTest(){}
    
    @BeforeClass
    public static void setUpClass(){}
    
    @AfterClass
    public static void tearDownClass(){}
    
    @Before
    public void setUp()
    {
        instance = new Map("testBackgroundPath", new Obstacle(1, 1, 1, 1, "testSpritePath1", ObstacleType.FINISH), new Obstacle(2, 2, 2, 2, "testSpritePath2", ObstacleType.FINISH), new ArrayList<Obstacle>(){{new Obstacle(5, 5, 5, 5, "testSpritePathWall", ObstacleType.WALL);}});
    }
    
    @After
    public void tearDown(){}

    /**
     * Test of getBackgroundPath method, of class Map.
     */
    @Test
    public void testGetBackgroundPath()
    {
        System.out.println("getBackgroundPath");
                
        String expResult = "testBackgroundPath";
        String result = instance.getBackgroundPath();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setbackgroundPath method, of class Map.
     */
    @Test
    public void testSetbackgroundPath()
    {
        System.out.println("setbackgroundPath");
        
        String backgroundPath = "testBackgroundPath2";
        instance.setbackgroundPath(backgroundPath);
        
        String expResult = "testBackgroundPath2";
        String result = instance.getBackgroundPath();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getFinish method, of class Map.
     */
    @Test
    public void testGetFinish()
    {
        System.out.println("getFinish");
        
        Obstacle expResult = new Obstacle(1, 1, 1, 1, "testSpritePath1", ObstacleType.FINISH);
        Obstacle result = instance.getFinish();
        
        assertEquals(expResult.getSpritePath(), result.getSpritePath());
    }

    /**
     * Test of setFinish method, of class Map.
     */
    @Test
    public void testSetFinish()
    {
        System.out.println("setFinish");
        
        Obstacle finish = new Obstacle(3, 3, 3, 3, "testSpritePath3", ObstacleType.FINISH);
        instance.setFinish(finish);
        
        Obstacle expResult = new Obstacle(3, 3, 3, 3, "testSpritePath3", ObstacleType.FINISH);
        Obstacle result = instance.getFinish();
        
        assertEquals(expResult.getSpritePath(), result.getSpritePath());
    }

    /**
     * Test of getFinish2 method, of class Map.
     */
    @Test
    public void testGetFinish2()
    {
        System.out.println("getFinish2");
        
        Obstacle expResult = new Obstacle(2, 2, 2, 2, "testSpritePath2", ObstacleType.FINISH);
        Obstacle result = instance.getFinish2();
        
        assertEquals(expResult.getSpritePath(), result.getSpritePath());
    }

    /**
     * Test of setFinish2 method, of class Map.
     */
    @Test
    public void testSetFinish2()
    {
        System.out.println("setFinish2");
        
        Obstacle finish2 = new Obstacle(4, 4, 4, 4, "testSpritePath4", ObstacleType.FINISH);
        instance.setFinish2(finish2);
        
        Obstacle expResult = new Obstacle(4, 4, 4, 4, "testSpritePath4", ObstacleType.FINISH);
        Obstacle result = instance.getFinish2();
        
        assertEquals(expResult.getSpritePath(), result.getSpritePath());
    }

    /**
     * Test of getWalls method, of class Map.
     */
    @Test
    public void testGetWalls()
    {
        System.out.println("getWalls");
        
        List<Obstacle> expResult = new ArrayList<Obstacle>(){{new Obstacle(5, 5, 5, 5, "testSpritePathWall", ObstacleType.WALL);}};
        List<Obstacle> result = instance.getWalls();

        assertEquals(expResult, result);
    }

    /**
     * Test of setWalls method, of class Map.
     */
    @Test
    public void testSetWalls()
    {
        System.out.println("setWalls");
        
        List<Obstacle> walls = new ArrayList<Obstacle>(){{new Obstacle(6, 6, 6, 6, "testSpritePathWall", ObstacleType.WALL);}};
        instance.setWalls(walls);
        
        List<Obstacle> expResult = new ArrayList<Obstacle>(){{new Obstacle(6, 6, 6, 6, "testSpritePathWall", ObstacleType.WALL);}};
        List<Obstacle> result = instance.getWalls();
        
        assertEquals(expResult, result);
    }    
}
