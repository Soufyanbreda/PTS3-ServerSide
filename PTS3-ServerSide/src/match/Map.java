/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package match;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Milton van de Sanden
 */
public class Map implements Serializable
{
        private String backgroundPath;
    private Obstacle finish;
    private Obstacle finish2;
    private List<Obstacle> walls;
    
    public Map(String backgroundPath, Obstacle finish, Obstacle finish2, List<Obstacle> walls)
    {
        this.backgroundPath = backgroundPath;
        this.finish = finish;
        this.finish2 = finish2;
        this.walls = walls;
    }

    public String getBackgroundPath()
    {
        return backgroundPath;
    }

    public void setbackgroundPath(String backgroundPath)
    {
        this.backgroundPath = backgroundPath;
    }

    public Obstacle getFinish()
    {
        return finish;
    }

    public void setFinish(Obstacle finish)
    {
        this.finish = finish;
    }
    
    public Obstacle getFinish2()
    {
        return finish2;
    }
    
    public void setFinish2(Obstacle finish2)
    {
        this.finish2 = finish2;
    }

    public List<Obstacle> getWalls()
    {
        return walls;
    }

    public void setWalls(List<Obstacle> walls)
    {
        this.walls = walls;
    }

}
