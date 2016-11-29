/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import utils.Color;
import utils.PlayerState;

/**
 *
 * @author Milton van de Sanden
 */
public interface ICompetingPlayer
{
    public String getUsername();
    public void setUsername(String username);
    
    public Color getColor();
    public void setColor(Color color);
    
    public int getCurrentLap();
    public void setCurrentLap(int lap);
    
    public PlayerState getPlayerState();
    public void setPlayerState(PlayerState playerState);

    public PlayerCar getPlayerCar();
    public void setPlayerCar(PlayerCar playerCar);
}
