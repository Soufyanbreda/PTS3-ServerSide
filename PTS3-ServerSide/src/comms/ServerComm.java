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



/**
 *
 * @author marouano
 */
public class ServerComm extends UnicastRemoteObject implements IServerComms 
{
    public ServerComm() throws RemoteException
    {
        
    }
    
    @Override
    public Match Login(String username)
    {
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
    
}
