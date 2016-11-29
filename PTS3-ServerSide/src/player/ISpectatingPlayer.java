/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import utils.Color;

/**
 *
 * @author Milton van de Sanden
 */
public interface ISpectatingPlayer
{
    public String getUsername();
    public void setUsername(String username);
    
    public Color getColor();
    public void setColor(Color color);
}
