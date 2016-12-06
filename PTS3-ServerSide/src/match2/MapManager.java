/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package match2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author soufyan
 */
public class MapManager implements Serializable
{
    public List<Map> maps;
    
    public static final long serialVersionUID = 1875;
    
    public MapManager()
    {
        maps = new ArrayList<>();
                
        maps.add
        (
            new Map
            (
                "map/maps/Map1.png",
                new Obstacle(60, 10, 10, 30, "map/finish.png", ObstacleType.FINISH),
                new Obstacle(80, 50, 20, 50, "map/finish.png", ObstacleType.FINISH),
                new ArrayList<Obstacle>()
                {{
                    //innerwals
                    add(new Obstacle(150, 125, 25, 225, "map/wall.jpg", ObstacleType.WALL));
                    add(new Obstacle(475, 125, 25, 225, "map/wall.jpg", ObstacleType.WALL));
                    add(new Obstacle(150, 100, 350, 25, "map/wall.jpg", ObstacleType.WALL));
                    add(new Obstacle(150, 350, 350, 25, "map/wall.jpg", ObstacleType.WALL));
                    
                    //outerwalls
                    add(new Obstacle(65, 50, 25, 375, "map/wall.jpg", ObstacleType.WALL));
                    add(new Obstacle(550, 50, 25, 375, "map/wall.jpg", ObstacleType.WALL));
                    add(new Obstacle(75, 30, 500, 25, "map/wall.jpg", ObstacleType.WALL));
                    add(new Obstacle(75, 425, 500, 25, "map/wall.jpg", ObstacleType.WALL));
                }}
            )
        );
        
        maps.add
        (
            new Map
            (
                "map/maps/racemap3.png",
                new Obstacle(325, 665, 20, 70, "map/finish.png", ObstacleType.FINISH),
                new Obstacle(325, 80, 20, 70, "map/finish.png", ObstacleType.FINISH),
                new ArrayList<Obstacle>()
                {{
                    //innerwals
                    add(new Obstacle(125, 150, 25, 500, "map/wall.jpg", ObstacleType.WALL));
                    add(new Obstacle(150, 650, 575, 15, "map/wall.jpg", ObstacleType.WALL));
                    add(new Obstacle(425, 225, 25, 425, "map/wall.jpg", ObstacleType.WALL));
                    add(new Obstacle(150, 165, 625, 65, "map/wall.jpg", ObstacleType.WALL));

                    //outerwalls
                    add(new Obstacle(0, 0, 25, 750, "map/wall.jpg", ObstacleType.WALL));
                    add(new Obstacle(25, 735, 900, 25, "map/wall.jpg", ObstacleType.WALL));
                    add(new Obstacle(850, 585, 25, 150, "map/wall.jpg", ObstacleType.WALL));
                    add(new Obstacle(550, 565, 300, 25, "map/wall.jpg", ObstacleType.WALL));
                    add(new Obstacle(550, 325, 25, 250, "map/wall.jpg", ObstacleType.WALL));
                    add(new Obstacle(550, 325, 325, 25, "map/wall.jpg", ObstacleType.WALL));
                    add(new Obstacle(550, 325, 325, 25, "map/wall.jpg", ObstacleType.WALL));
                    add(new Obstacle(25, 50, 875, 25, "map/wall.jpg", ObstacleType.WALL));
                    add(new Obstacle(875, 75, 25, 250, "map/wall.jpg", ObstacleType.WALL));
                }}
            )
        ); 
    }
}