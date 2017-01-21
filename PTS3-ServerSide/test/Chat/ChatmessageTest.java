/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

import com.badlogic.gdx.graphics.Color;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Milton van de Sanden
 */
public class ChatmessageTest
{    
    Chatmessage instance;
    
    public ChatmessageTest(){}
    
    @BeforeClass
    public static void setUpClass(){}
    
    @AfterClass
    public static void tearDownClass(){}
    
    @Before
    public void setUp()
    {
        instance = new Chatmessage("testMessage", "testPlayer", Color.BLACK);
    }
    
    @After
    public void tearDown(){}

    /**
     * Test of getMessage method, of class Chatmessage.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        
        String expResult = "testMessage";
        String result = instance.getMessage();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setMessage method, of class Chatmessage.
     */
    @Test
    public void testSetMessage() {
        System.out.println("setMessage");
        
        String Message = "testMessage2";
        instance.setMessage(Message);
        
        String expResult = "testMessage2";
        String result = instance.getMessage();
        
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getPlayername method, of class Chatmessage.
     */
    @Test
    public void testGetPlayername()
    {
        System.out.println("getPlayername");
        
        String expResult = "testPlayer";
        String result = instance.getPlayername();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setPlayername method, of class Chatmessage.
     */
    @Test
    public void testSetPlayername()
    {
        System.out.println("setPlayername");
        
        String playerName = "testPlayer2";
        instance.setPlayername(playerName);
        
        String expResult = "testPlayer2";
        String result = instance.getPlayername();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getMessageDate method, of class Chatmessage.
     */
    @Test
    public void testGetMessageDate()
    {
        System.out.println("getMessageDate");
        
        instance.setMessageDate(new Date(5));
        
        Date expResult = new Date(5);
        Date result = instance.getMessageDate();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of setMessageDate method, of class Chatmessage.
     */
    @Test
    public void testSetMessageDate()
    {
        System.out.println("setMessageDate");
        
        Date MessageDate = new Date(5);
        instance.setMessageDate(MessageDate);
        
        Date expResult = new Date(5);
        Date result = instance.getMessageDate();
        
        assertEquals(expResult, result);
    }
    
}
