/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author soufyan
 */
public class ServerLauncher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, MalformedURLException
    {
        ServerManager serverManager = new ServerManager();
        try {
            LocateRegistry.createRegistry(1099);
            System.out.println("java RMI registry created");
        } catch (RemoteException e){
            System.out.println("Java RMI registry already exists");
        }
        
        ServerComm obj = new ServerComm();
        
        Naming.rebind("//localhost/RmiServer", obj);
        System.out.println("put in registry");
    }
    
}
