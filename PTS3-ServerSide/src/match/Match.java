/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package match;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import server.player.Player;
import utils.GameState;

/**
 *
 * @author Milton van de Sanden
 */
public class Match implements Serializable
{
    private GameState gameState;
    
    private List<Player> players;
    
    public Match()
    {
        gameState = GameState.LOBBY;
        
        players = new ArrayList<>();
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    
    public void addPlayer(Player player)
    {
        if(!players.contains(player))
        {
            players.add(player);
        }
    }
    
    public void removePlayer(Player player)
    {
        players.remove(player);
    }
}
