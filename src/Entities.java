import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Entities {

    private int x, y, dx, dy, w, h;
    private String s, iL, iR; 

    public Entities (){
   
    }

    public Entities (int x1, int y1, int dx1, int dy1, int width, int height){
        x = x1;
        y = y1;
        dx = dx1;
        dy = dy1;
        w = width;
        h = height;
    }

    public Entities (int x1, int y1, int dx1, int dy1, int width, int height, String sprite, String idleL, String idleR){
        x = x1;
        y = y1;
        dx = dx1;
        dy = dy1;
        w = width;
        h = height;
        s = sprite;
        iL = idleL;
        iR = idleR;
    }

    public void drawEnt(Graphics g2d){
        g2d.drawImage(new ImageIcon(s).getImage(), x, y, w, h, null);
    }

    
}
