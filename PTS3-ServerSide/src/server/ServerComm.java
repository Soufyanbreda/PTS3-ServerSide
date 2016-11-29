/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.awt.Point;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import server.player.Player;

/**
 *
 * @author marouano
 */
public class ServerComm extends UnicastRemoteObject implements IServerComm {
    public static final String MESSAGE = "Connected with server yo!";
    
    public ServerComm() throws RemoteException{
        super(0);
        
    }
    
    @Override
    public String getMessage() {
        return MESSAGE;
    }
    
    @Override
    public List<Player> Login(String username){
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean roleSwitch(String username){
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void ready(String username){
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void mapSwitch(String mapName){
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void pushPos(String username, Point pos){
        throw new UnsupportedOperationException();
    }

    
}
