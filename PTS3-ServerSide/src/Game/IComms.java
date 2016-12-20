/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Chat.ChatMessage;
import java.awt.Point;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Milton van de Sanden
 */
public interface IComms extends Remote
{
    public void pushPlayerPosition(String username, Point position, float rotation) throws RemoteException;
    public void receiveNewChatmessage(ChatMessage chatmessage) throws RemoteException;
}
