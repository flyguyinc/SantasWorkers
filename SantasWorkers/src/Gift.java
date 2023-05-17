/**
 *
 * @author J. Barrett
 * 
 * To Do List:
 * 1)update the constructor so that the gift will be randomly placed on 
 *      the map in a place not taken up by another DrawableRectangle
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Gift extends DrawableRectangle{
    
    int value;

    public Gift(ArrayList<DrawableRectangle> list) {
        super(2, 2, "gift.png");
        Random randy=new Random();
        value=randy.nextInt(9)+1;
        do {
            setR(randy.nextInt(20));
            setC(randy.nextInt(20));
        } while (getR() == 2 && getC() == 2);
    }

    
    public int getValue(){
        return value;
    }

    @Override
    public char getSymbol() {
        return (char) ((int)('1')+(value-1));
    }
    
    public void draw(Graphics g){
        super.draw(g);
        g.setColor(Color.black);
        g.setFont(new Font("HOBO STD",Font.BOLD,16));
        g.drawString(""+value, x+width/3, y+width/5*4);
    }
    
    

}