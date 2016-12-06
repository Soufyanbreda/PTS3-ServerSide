/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player2;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import java.awt.Point;
import java.io.Serializable;

/**
 *
 * @author Milton van de Sanden
 */
public class PlayerCar implements Serializable
{
    private final Sprite sprite;
    private float speed;
    private static final float MAXSPEED = 4.5f;
    private static final float ACCELERATION = 1.05f;
    
    public static final long serialVersionUID = 1875;
    public PlayerCar(Texture texture, Point size, Point location)
    {
        sprite = new Sprite(texture);
        
        sprite.setSize(size.x, size.y);
        sprite.setOrigin(6.5f, 10f);
        sprite.rotate(-90);
        sprite.setPosition(location.x, location.y);
        
        speed = 0.0f;
    }
    
    public Rectangle getRectangle()
    {
        return sprite.getBoundingRectangle();
    }
    
    public void moveForward()
    {
        float x = (float) Math.cos(Math.toRadians(sprite.getRotation()+90));
        float y = (float) Math.sin(Math.toRadians(sprite.getRotation()+90));

        sprite.translate(x * speed, y * speed);
     }
    
    public void turnRight()
    {
        sprite.rotate(-5f);   
    }

    public void turnLeft()
    {
        if (speed > 1)
        {
            sprite.rotate(5f);
        }
    }
    

    
    public float getSpeed()
    {
        return speed;
    }

    public void setSpeed(float speed)
    {
        if(speed > MAXSPEED)
        {
            throw new IllegalArgumentException();
        }
        
        this.speed = speed;
    }
    
    public Sprite getSprite()
    {
        return sprite;
    }
    
    public void increaseSpeed()
    {
        if (speed < 1)
        {
            speed = 1;
        }

        speed *= ACCELERATION;

        
        if (speed > MAXSPEED)
        {
            speed = MAXSPEED;
        }
    }    
    
    public void decreaseSpeed()
    {
        if (speed > 0)
        {
            speed -= speed/10;
        }
    }
    
    public float getMaxSpeed()
    {
        return MAXSPEED;
    }
}
