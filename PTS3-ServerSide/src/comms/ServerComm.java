/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comms;

//import match.Lobby;

import java.awt.Point;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import match2.Match;
import server.ServerManager;



/**
 *
 * @author marouano
 */
public class ServerComm extends UnicastRemoteObject implements IServerComms 
{
    private ServerManager serverManager;
    
    public ServerComm() throws RemoteException{}
    
    public ServerComm(ServerManager serverManager) throws RemoteException
    {
        this.serverManager = serverManager;
    }
    
    @Override
    public Match Login(String username, boolean isCompeting, String ip, int portnumber) throws RemoteException
    {
        System.out.println(username + " is logging in");
        return serverManager.logIn(username, isCompeting, ip, portnumber);
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
    public void pushPosition(String username, Point position, float rotation) throws RemoteException
    {
        serverManager.pushPosition(username, position, rotation);
    }
    
    @Override
    public void pushFinish(String username) throws RemoteException
    {
        serverManager.pushFinish(username);
    }

//    @Override
//    public void pushBullet(String username) {
//     //serverManager.pushBullet(username);
//     throw new UnsupportedOperationException();
//    }
}
