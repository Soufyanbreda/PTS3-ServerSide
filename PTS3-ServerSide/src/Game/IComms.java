/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Point;
import player2.CompetingPlayer;
import java.rmi.Remote;
import java.rmi.RemoteException;
import player2.Player;

/**
 *
 * @author Milton van de Sanden
 */
public interface IComms extends Remote
{
    public void pushPlayerPosition(String username, Point position, float rotation) throws RemoteException;
    
    public void pushPlayer(Player player) throws RemoteException;
}
