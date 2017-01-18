/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import Chat.Chatmessage;
import Game.IComms;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
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
import match2.MapManager;
import match2.Match;
import player2.CompetingPlayer;
import player2.Player;
import player2.PlayerCar;
import player2.SpectatingPlayer;
import utils2.Color;
import utils2.PlayerState;
import utils2.Projectile;

/**
 * @author Marouan Bakour
 * @author Milton van de Sanden
 */
public class ServerManager
{   
    private boolean connectionsStable = false;
    
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
            serverComms = new ServerComm(this);
            
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
        
//        blub();
    }
    
    public void pushPosition(String username, Point position, float rotation)
    {
//        System.out.println("username: " + username);
        CompetingPlayer player = ((CompetingPlayer) match.getPlayer(username));
//        System.out.println("playername: " + player.getUsername());
        player.getPlayerCar().setPosition(position);
        player.getPlayerCar().setRotation(rotation);
        
        if(connectionsStable)
        {
            for(IComms clientComm : clientComms)
            {
                try
                {
                    clientComm.pushPlayerPosition(player.getUsername(), new Point((int) player.getPlayerCar().getRectangle().x, (int) player.getPlayerCar().getRectangle().y), player.getPlayerCar().getRotation());
                }
                catch (RemoteException ex)
                {
                    Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }            
        }
    }
            
    public Match logIn(String username, boolean isCompeting, String ip, int portnumber)
    {
        connectionsStable = false;
        
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
            
            if(match.hasCompetingRoom() && isCompeting)
            {
                CompetingPlayer player = new CompetingPlayer(username, generateColor());
                player.setPlayerCar(new PlayerCar(0f, new Point(335, 685)));
                player.getPlayerCar().setRotation(90);

                match.addPlayer(player);                                

//                if(match.getPlayers().size() > 1)
//                {
//                    for(IComms clientComm : clientComms)
//                    {
//                        try
//                        {
//                            System.out.println("blub");
//                            if(connectionsStable)
//                            {
//                                System.out.println("Pushing new player to all clients");
//                                clientComm.pushPlayerPosition(player.getUsername(), new Point((int) player.getPlayerCar().getRectangle().x, (int) player.getPlayerCar().getRectangle().y), player.getPlayerCar().getRotation());
//                            }
//                        } catch (RemoteException ex)
//                        {
//                            Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//                }
            }
            else
            {
                SpectatingPlayer player = new SpectatingPlayer(username, generateColor());
                match.addPlayer(player);            
            }

            Map map = new MapManager().maps.get(1);

            match.setMap(map);            
        }
        catch (RemoteException | NotBoundException ex)
        {
            Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("----------------------------");
            System.out.println("Cannot connect to received client");
            System.out.println("ip: " + ip);
            System.out.println("port: " + portnumber);
        }
        
        
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
    
    public void pushFinish(String username)
    {
//        boolean matchFinished = match.addFinishedPlayer(username);
        //if(connectionsStable)
        //{
            for(IComms clientComm : clientComms)
            {
                try
                {
                    clientComm.pushPlayerPosition(username, new Point(300, 500), 0f);
                    clientComm.receiveNewChatmessage(new Chatmessage(" " + username + " has finished", "SYSTEM", com.badlogic.gdx.graphics.Color.BLACK));

    //                if(matchFinished)
    //                {
    //                    clientComm.receiveNewChatmessage(new Chatmessage(" MATCH FINISHED", "SYSTEM", com.badlogic.gdx.graphics.Color.BLACK));
    //                    
    //                    int rank = 1;
    //                    for(String player : match.getFinishedPlayers())
    //                    {
    //                        clientComm.receiveNewChatmessage(new Chatmessage(" " + player + " finished " + rank, "SYSTEM", com.badlogic.gdx.graphics.Color.BLACK));
    //                        rank++;
    //                    }
    //                }
                }
                catch (RemoteException ex)
                {
                    Logger.getLogger(ServerManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }   
        //}        
    }

      public void BroadcastChatmessage(Chatmessage chatmessage) throws RemoteException
      {
        if(connectionsStable)
        {
            for(IComms clientcomm: clientComms)
            {
               clientcomm.receiveNewChatmessage(chatmessage);
            }
        }
      }
   
    
//    public void pushBullet(String username) throws RemoteException
//    {
//        ArrayList<Projectile> projectiles = new ArrayList<>();
//        CompetingPlayer player = ((CompetingPlayer) match.getPlayer(username));
//
//        //Shoot
//        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
//        {
//            projectiles.add(new Projectile(player.getPlayerCar().getRectangle().getX(),player.getPlayerCar().getRectangle().getY(), player.getPlayerCar()));
//        }
//
//         //Update
//        ArrayList<Projectile> projectilesToRemove = new ArrayList<>();
//        for(Projectile p : projectiles)
//        {
//            p.update(Gdx.graphics.getDeltaTime());
//            if(p.isRemove())
//            {
//                projectilesToRemove.add(p);
//            }
//        }
//        projectiles.removeAll(projectilesToRemove);   
//    }
    public void pushProjectile(Projectile p) throws RemoteException
    {
        if(connectionsStable)
        {
            for(IComms clientComm : clientComms)
            {
                clientComm.pushProjectile(p);
            }            
        }
    }

    public void setConnectionsStable(boolean isStable)
    {
        connectionsStable = isStable;
    }
}
