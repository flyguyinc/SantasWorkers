
/**
 *
 * @author NAME 
 * 
 * To Do: 1) Finish Gift 2) Finish Elf 3) Get SantasLand Running
 */

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SantasLand extends JPanel implements ActionListener, KeyListener {

    javax.swing.Timer timer;
    Elf ted;
    ArrayList<DrawableRectangle> list;

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Santa's Workers");
        frame.setSize(515, 540);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SantasLand());
        frame.setVisible(true);
    }

    public SantasLand() {
        //put constructor code here
        ted = new Elf();
        list = new ArrayList<DrawableRectangle>();
        list.add(new HomeBase());
        list.add(ted);
        for (int i = 0; i < 15; i++) {
            list.add(new IceBlock());
        }
        for (int i = 0; i < 4; i++) {
            list.add(new Gift(list));
        }
        timer = new javax.swing.Timer(10, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
    }

    public void actionPerformed(ActionEvent e) {
        //type what needs to be performed every time the timer ticks
        if (new Random().nextInt(500) == 0) {
            list.add(new Gift(list));
        }
        ted.move(list, createMap());
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //draw your graphics here
        for (DrawableRectangle item : list) {
            item.draw(g);
        }
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public char[][] createMap() {
        char[][] map = new char[20][20];
        for (int r = 0; r < 20; r++) {
            for (int c = 0; c < 20; c++) {
                map[r][c] = '.';
            }
        }        

        for (DrawableRectangle item : list) {
            map[item.getR()][item.getC()] = item.getSymbol();
        }
        System.out.println("===============================");
        for (int r = 0; r < map.length; r++) {
            System.out.println(map[r]);
        }
        return map;
    }
}
