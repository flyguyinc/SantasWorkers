/**
 *
 * @author J. Barrett
 * To Do:
 * 1) write findHighestValueGift
 * 2) write createPathToGift 
 * 3) write createPathHome
 * 4) write move so that 
 *  a)if he is at home, he finds the highest value gift and starts on that path
 *  b)if he is on a path, he finishes it
 *  c)if he just finished his path to a gift, have him create a path home 
 *              (a gift could have spawned to block his way)
 */

import java.awt.Point;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;


public class Elf extends DrawableRectangle{
    LinkedList<Step> path;   

    public Elf() {
        super(0, 0, "elf.jpg");
    }

    public void move(Collection<DrawableRectangle> list, char[][] map) {

        updatePosition();
    }

    @Override
    public char getSymbol() {
        return 'e';
    }

    public Collection<Step> getPath() {
        return path;
    }

    //given the list, find the gift with the highest value. 
    //if there is no gift in the list, return null
    public Gift findHighestValueGift(Collection<DrawableRectangle> list){
        return null;
    }
    
    //create a path to the targeted gift that walks around rocks and current gifts 
    //but assume the elf may step over gifts generated while he is traveling on his path
    //Right is done for you, write Left, Up and Down
    public LinkedList<Step> createPathToGift(Gift gift, char[][] map){
        int startR=getR(), startC=getC();
        Step start=new Step(startR, startC);
        
        HashSet<Point> set = new HashSet<Point>();
        PriorityQueue<Step> queue=new PriorityQueue<Step>();
        
        queue.add(start);
        
        while(!queue.isEmpty()){
            Step current=queue.poll();
            if (set.contains(new Point(current.r, current.c))) {
                continue;
            }
            set.add(new Point(current.r, current.c));
            LinkedList<Step> pathHere=new LinkedList<Step>(current.path);
            pathHere.add(current);
            if(current.r == gift.getR() && current.c == gift.getC()) return pathHere;
            Step right=new Step(current.r, current.c+1,pathHere);
            if(right.c<map[right.r].length && map[right.r][right.c]!='x')
                queue.add(right);
        }
        
        return null;
    }
    
    //create a path to 0,0 that walks around rocks and current gifts but assume the elf
    //may step over gifts generated while he is traveling on his path
    public LinkedList<Step> createPathHome(char[][] map){
        return null;
    }

}