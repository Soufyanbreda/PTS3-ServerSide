/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player2;

import java.awt.Point;
import java.io.Serializable;
import utils2.Color;
import utils2.PlayerState;

/**
 *
 * @author Milton van de Sanden
 */
public class CompetingPlayer extends Player implements ICompetingPlayer, Serializable
{
    private int currentLap;
    private PlayerState playerState;
    private PlayerCar playerCar;
    
    public static final long serialVersionUID = 1875;

    public CompetingPlayer(String username, Color color)
    {
        super(username, color);
        
        currentLap = 0;
        playerState = PlayerState.WAITING;
    }
    
    @Override
    public int getCurrentLap()
    {
        return currentLap;
    }

    @Override
    public void setCurrentLap(int currentLap)
    {
        if(currentLap <= this.currentLap)
        {
            throw new IllegalArgumentException();
        }
        this.currentLap = currentLap;
    }

    @Override
    public PlayerState getPlayerState()
    {
        return playerState;
    }

    @Override
    public void setPlayerState(PlayerState playerState)
    {
        if(playerState != PlayerState.FINISHED || playerState != PlayerState.WAITING || playerState != PlayerState.RACING || playerState != PlayerState.READY)
        {
            throw new IllegalArgumentException();
        }
        
        this.playerState = playerState;
    }

    @Override
    public PlayerCar getPlayerCar()
    {
        return playerCar;
    }

    @Override
    public void setPlayerCar(PlayerCar playerCar)
    {
        this.playerCar = playerCar;
    }
}
