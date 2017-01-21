/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils2;

import player2.PlayerCar;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import java.io.Serializable;

/**
 *
 * @author Danny
 */
public class Projectile implements Serializable{
    
    private float x, y, speed;
    private boolean remove;
    // private Texture texture;
    //private Sprite sprite;
     private Rectangle rectangle;
    private PlayerCar car;
    private boolean firstLocation = true;
    float dirX;
    float dirY;
    public static final long serialVersionUID = 1875;
    
    public Projectile(float startX, float startY, PlayerCar c)
    {
        x = startX;
        y = startY;
        car = c;
        speed = 700;
        remove = false;
        rectangle = new Rectangle(startX,startY,10f,10f);

//        if(texture == null)
//        {
//            texture = new Texture("images/bullet.png");
//            sprite = new Sprite(texture);
//            sprite.setOrigin(x, y);
//        }
    }
	
    public void update(float deltaTime)
    {
        if(firstLocation)
        {
            dirX = (float)Math.cos(Math.toRadians(car.getRotation()+90));
            dirY = (float)Math.sin(Math.toRadians(car.getRotation()+90));
            firstLocation = false;
        }
        
        x +=  dirX * speed * deltaTime;
        y +=  dirY * speed * deltaTime;
        
        if(x > Gdx.graphics.getWidth() || y > Gdx.graphics.getHeight())
        {
            remove = true;
        }
    }
        
    public void render(SpriteBatch batch, Sprite sprite)
    {
        batch.draw(sprite, x, y);
        //sprite.draw(batch);
    }

    public float getX()
    {
            return x;
    }

    public float getY()
    {
            return y;
    }

    public float getSpeed()
    {
        return speed;
    }

    public boolean isRemove()
    {
        return remove;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public void setSpeed(int speedX)
    {
        this.speed = speedX;
    }

    public void setRemove(boolean remove)
    {
        this.remove = remove;
    }
}
    