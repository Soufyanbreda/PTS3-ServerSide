/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comms;

//import match.Lobby;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import match.Match;
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
    public Match Login(String username, String ip, int portnumber)
    {
        return serverManager.logIn(username, ip, portnumber);
    }
    
    @Override
    public boolean roleSwitch(String username){
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void ready(String username){
        throw new UnsupportedOperationException();
    }
    
}
