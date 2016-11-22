/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.Random;
import match.Match;
import server.player.CompetingPlayer;
import server.player.Player;
import server.player.SpectatingPlayer;
import utils.Color;
import utils.PlayerState;

/**
 * @author Marouan Bakour
 * @author Milton van de Sanden
 */
public class ServerManager
{   
    private final Match match;
    
    public ServerManager()
    {
        match = new Match();
    }
    
    public Match logIn(String username)
    {
        if(username == null)
        {
            throw new IllegalArgumentException("username is null");
        }
        
        if(username.isEmpty())
        {
            throw new IllegalArgumentException("username is empty");
        }

        if(match.getPlayer(username) != null)
        {
            throw new IllegalArgumentException("username is in use");
        }
                
        Player player;

        if(match.hasCompetingRoom())
        {
            player = new CompetingPlayer(username, generateColor());
        }
        else
        {
            player = new SpectatingPlayer(username, generateColor());
        }
        
        match.addPlayer(player);
        
        return match;
    }

    public Color generateColor()
    {
        Color color;
        
        switch (new Random().nextInt(4))
        {
            case 0:
                color = Color.BLUE;
                break;
            case 1:
                color = Color.GREEN;
                break;
            case 2:
                color = Color.RED;
                break;
            case 3:
                color = Color.YELLOW;
                break;
            default:
                color = Color.BLACK;
                break;
        }
        
        return color;
    }
    
    
    public void roleSwitch(String username)
    {
        Player player = match.getPlayer(username);
        Player player2;
        
        if(player.getClass() == CompetingPlayer.class)
        {
            player2 = new SpectatingPlayer(player.getUsername(), player.getColor());
            match.replacePlayer(player, player2);
        }
        else if(player.getClass() == SpectatingPlayer.class && match.hasCompetingRoom())
        {
            player2 = new CompetingPlayer(player.getUsername(), player.getColor());
            match.replacePlayer(player, player2);
        }
    }
    
    public void ready(String username, boolean isReady)
    {
        Player player = match.getPlayer(username);
        if(player != null)
        {
            if(player.getClass() == CompetingPlayer.class)
            {
                if(isReady)
                {
                    ((CompetingPlayer) player).setPlayerState(PlayerState.READY);
                }
                else
                {
                    ((CompetingPlayer) player).setPlayerState(PlayerState.WAITING);
                }            
            }   
        }        
    }
}
