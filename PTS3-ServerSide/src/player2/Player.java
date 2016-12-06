/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player2;

import java.io.Serializable;
import utils2.Color;

/**
 *
 * @author Milton van de Sanden
 */
public abstract class Player implements Serializable
{
    private String username;
    private Color color;
    public static final long serialVersionUID = 1875;
    public Player(String username, Color color)
    {
        if(username == null)
        {
            throw new IllegalArgumentException();
        }
        
        if(username.isEmpty())
        {
            throw new IllegalArgumentException();
        }
        
        if(color == null)
        {
            throw new IllegalArgumentException();
        }
        
        if(color != Color.BLACK && color != Color.BLUE && color != Color.GREEN && color != Color.RED && color != Color.YELLOW)
        {
            throw new IllegalArgumentException();
        }
        
        this.username = username;
        this.color = color;
    }
    
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        if(username == null)
        {
            throw new IllegalArgumentException();
        }
        
        if(username.isEmpty())
        {
            throw new IllegalArgumentException();
        }
        
        this.username = username;
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        if(color == null)
        {
            throw new IllegalArgumentException();
        }
        
        if(color != Color.BLACK || color != Color.BLUE || color != Color.GREEN || color != Color.RED || color != Color.YELLOW)
        {
            throw new IllegalArgumentException();
        }
                
        this.color = color;
    }
}
