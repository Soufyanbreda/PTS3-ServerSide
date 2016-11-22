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

/**
 * @author Marouan Bakour
 * @author Milton van de Sanden
 */
public class ServerManager
{   
    private Match match;
    
    public ServerManager()
    {
        match = new Match();
    }
    
    public Match logIn(String username)
    {
        int competingCounter = 0;
        
        for(Player player : match.getPlayers())
        {
            if(username.equals(player.getUsername()))
            {
                return null;
            }
            
            if(player.getClass() == CompetingPlayer.class)
            {
                competingCounter++;
            }
        }
        
        Player player;

        Color color;
            
        switch (competingCounter)
        {
            case 0:
                color = Color.RED;
                break;
            case 1:
                color = Color.BLUE;
                break;
            case 2:
                color = Color.GREEN;
                break;
            case 3:
                color = Color.YELLOW;
                break;
            default:
                color = Color.BLACK;
                break;
        }
        
        if(competingCounter < 4)
        {
            player = new CompetingPlayer(username, color);
        }
        else
        {
            player = new SpectatingPlayer(username, color);
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
}
