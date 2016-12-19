/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comms;

import java.awt.Point;
import java.rmi.Remote;
import java.rmi.RemoteException;
import match2.Match;

/**
 *
 * @author Milton van de Sanden
 */
public interface IServerComms extends Remote
{
    public Match Login(String username, boolean isCompeting, String ip, int portnumber) throws RemoteException;
    public boolean roleSwitch(String username) throws RemoteException;
    public void ready(String username) throws RemoteException;
    public void pushPosition(String username, Point position, float rotation) throws RemoteException;
    public void pushFinish(String username) throws RemoteException;
    //public void pushBullet(String username);
}
