/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Player.CompetingPlayer;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Milton van de Sanden
 */
public interface IComms extends Remote
{
    public void pushPlayerPosition(CompetingPlayer player) throws RemoteException;
}
