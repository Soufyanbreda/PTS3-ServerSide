/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.awt.Point;
import java.util.List;
import server.player.Player;

/**
 *
 * @author marouano
 */
public interface IServerComm extends Remote{
    
    String getMessage();

    List<Player> Login(String username);

    void mapSwitch(String mapName);

    void pushPos(String username, Point pos);

    void ready(String username);

    boolean roleSwitch(String username);
    
}
