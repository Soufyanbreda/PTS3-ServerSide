/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comms;

import java.awt.Point;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import match2.Match;
import server.ServerManager;
import utils2.Projectile;

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
    
   

    @Override
    public void pushProjectile(Projectile p) throws RemoteException {
        try {
            serverManager.pushProjectile(p);
        } 
        catch (RemoteException ex) {
            Logger.getLogger(ServerComm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
