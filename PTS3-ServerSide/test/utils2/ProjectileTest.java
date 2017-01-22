/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils2;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
public class ProjectileTest
{
    Projectile instance;
    
    public ProjectileTest(){}
    
    @BeforeClass
    public static void setUpClass(){}
    
    @AfterClass
    public static void tearDownClass(){}
    
    @Before
    public void setUp()
    {
        instance = null;
    }
    
    @After
    public void tearDown(){}

    /**
     * Test of getX method, of class Projectile.
     */
    @Test
    public void testGetX()
    {
        System.out.println("getX");
        
        instance.setX(5);
        
        float expResult = 5.0F;
        float result = instance.getX();
        
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getY method, of class Projectile.
     */
    @Test
    public void testGetY()
    {
        System.out.println("getY");
        
        instance.setY(5);
        
        float expResult = 5.0F;
        float result = instance.getY();

        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getSpeed method, of class Projectile.
     */
    @Test
    public void testGetSpeed()
    {
        System.out.println("getSpeed");
        
        instance.setSpeed(5);
        
        float expResult = 5.0F;
        float result = instance.getSpeed();
        
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of isRemove method, of class Projectile.
     */
    @Test
    public void testIsRemoveFalse() {
        System.out.println("isRemove False");
        
        instance.setRemove(false);
        
        boolean expResult = false;
        boolean result = instance.isRemove();
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of isRemove method, of class Projectile.
     */
    @Test
    public void testIsRemoveTrue() {
        System.out.println("isRemove True");
        
        instance.setRemove(true);
        
        boolean expResult = true;
        boolean result = instance.isRemove();
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setX method, of class Projectile.
     */
    @Test
    public void testSetX()
    {
        System.out.println("setX");
        
        int x = 5;
        instance.setX(x);
        
        float expResult = 5;
        float result = instance.getX();
        
        assertEquals(expResult, result, 0.0f);
    }

    /**
     * Test of setY method, of class Projectile.
     */
    @Test
    public void testSetY()
    {
        System.out.println("setY");
        
        int y = 5;
        instance.setY(y);
        
        float expResult = 5;
        float result = instance.getY();
        
        assertEquals(expResult, result, 0.0f);
    }

    /**
     * Test of setSpeed method, of class Projectile.
     */
    @Test
    public void testSetSpeed()
    {
        System.out.println("setSpeed");
        
        int speedX = 5;
        instance.setSpeed(speedX);
        
        float expResult = 5;
        float result = instance.getSpeed();
        
        assertEquals(expResult, result, 0.0f);
    }
}
