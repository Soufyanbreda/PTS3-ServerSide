/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import Game.IComms;
import comms.IServerComms;
import comms.ServerComm;
import java.awt.Point;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import match2.Map;
import match2.Match;
import player.CompetingPlayer;
import player.Player;
import player.SpectatingPlayer;
import utils.Color;
import utils.PlayerState;

/**
 * @author Marouan Bakour
 * @author Milton van de Sanden
 */
public class ServerManager
{   
    private Match match;
    private IServerComms serverComms;
    
    private Registry serverRegistry;
    private final int SERVERPORTNUMBER = 1099;
    private InetAddress SERVERIP;
    
    private List<IComms> clientComms;
    
    public ServerManager()
    {
        match = new Match();
        clientComms = new ArrayList<>();
        
        try
        {
            serverComms = new ServerComm();
            
            SERVERIP = InetAddress.getLocalHost();
            
            serverRegistry = LocateRegistry.createRegistry(SERVERPORTNUMBER);
            serverRegistry.rebind("Server", serverComms);
            
            System.out.println("----------------------------");
            System.out.println("Server running");
            System.out.println("ip: " + SERVERIP.toString());
            System.out.println("port: " + SERVERPORTNUMBER);
        } catch (RemoteException | UnknownHostException ex)
        {
            Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("----------------------------");
            System.out.println("SERVER CRASHED, pls relaunch");
        }
        
        //blub();
    }
    
    public void blub()
    {
        Match match = logIn("Player1", "192.168.178.16", 1100);
    }
    
    public Match logIn(String username, String ip, int portnumber)
    {
        if(username == null)
        {
            throw new IllegalArgumentException("username is null");
        }
        
        if(username.isEmpty())
        {
            throw new IllegalArgumentException("username is empty");
        }

        if(match.getPlayer(username) != null)
        {
            throw new IllegalArgumentException("username is in use");
        }
        
        try
        {
            Registry registry = LocateRegistry.getRegistry(ip, portnumber);
            clientComms.add((IComms) registry.lookup("Client"));
            System.out.println("----------------------------");
            System.out.println("connected to received client");
            System.out.println("ip: " + ip);
            System.out.println("port: " + portnumber);
        } catch (RemoteException | NotBoundException ex)
        {
            Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("----------------------------");
            System.out.println("Cannot connect to received client");
            System.out.println("ip: " + ip);
            System.out.println("port: " + portnumber);
        }
                
        Player player;

        if(match.hasCompetingRoom())
        {
            player = new CompetingPlayer(username, generateColor());
        }
        else
        {
            player = new SpectatingPlayer(username, generateColor());
        }
        match.addPlayer(player);
        
        return match;
    }
    
    public Color generateColor()
    {
        Color color;
        
        switch (new Random().nextInt(4))
        {
            case 0:
                color = Color.BLUE;
                break;
            case 1:
                color = Color.GREEN;
                break;
            case 2:
                color = Color.RED;
                break;
            case 3:
                color = Color.YELLOW;
                break;
            default:
                color = Color.BLACK;
                break;
        }
        
        return color;
    }
    
    
    public void roleSwitch(String username)
    {
        Player player = match.getPlayer(username);
        Player player2;
        
        if(player.getClass() == CompetingPlayer.class)
        {
            player2 = new SpectatingPlayer(player.getUsername(), player.getColor());
            match.replacePlayer(player, player2);
            
            //serverComms.pushPlayer(player2);
        }
        else if(player.getClass() == SpectatingPlayer.class && match.hasCompetingRoom())
        {
            player2 = new CompetingPlayer(player.getUsername(), player.getColor());
            match.replacePlayer(player, player2);
            
            //serverComms.pushPlayer(player2);
        }
    }
    
    public void ready(String username, boolean isReady)
    {
        Player player = match.getPlayer(username);
        if(player != null)
        {
            if(player.getClass() == CompetingPlayer.class)
            {
                if(isReady)
                {
                    ((CompetingPlayer) player).setPlayerState(PlayerState.READY);
//                    serverComms.pushPlayer(player2);
                }
                else
                {
                    ((CompetingPlayer) player).setPlayerState(PlayerState.WAITING);
//                    serverComms.pushPlayer(player2);
                }            
            }   
        }
    }
    
    public void setMap(Map map)
    {
        match.setMap(map);
    }
    
    public void pushPosition(String username, Point location, float angle)
    {
        
        ((CompetingPlayer) match.getPlayer(username)).getPlayerCar().getSprite().setPosition(location.x, location.y);
        ((CompetingPlayer) match.getPlayer(username)).getPlayerCar().getSprite().setRotation(angle);
        
//        serverComms.pushPlayer(match.getPlayer(username));
    }
}
