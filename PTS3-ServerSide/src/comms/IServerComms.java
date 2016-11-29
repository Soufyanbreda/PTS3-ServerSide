/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comms;

import java.rmi.Remote;
import java.rmi.RemoteException;
import match.Match;

/**
 *
 * @author Milton van de Sanden
 */
public interface IServerComms extends Remote
{
    public Match Login(String username) throws RemoteException;
    
    public boolean roleSwitch(String username) throws RemoteException;
    
    public void ready(String username) throws RemoteException;
}