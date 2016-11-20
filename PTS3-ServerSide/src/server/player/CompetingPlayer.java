/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.player;

import java.io.Serializable;
import utils.Color;
import utils.PlayerState;

/**
 *
 * @author Milton van de Sanden
 */
public class CompetingPlayer extends Player implements ICompetingPlayer, Serializable
{
    private int currentLap;
    private PlayerState playerState;
    private PlayerCar playerCar;

    public CompetingPlayer(String username, Color color)
    {
        super(username, color);
        
        currentLap = 0;
        playerState = PlayerState.NOTREADY;
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
        if(playerState != PlayerState.FINISHED || playerState != PlayerState.NOTREADY || playerState != PlayerState.RACING || playerState != PlayerState.READY)
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
