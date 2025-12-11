
import java.awt.Graphics;
import javax.swing.ImageIcon;



public class Blythe extends Entities{

    public Blythe (){
        super();       
    }

    public Blythe(int x,int y){
        super(x, y, 0, 0, 92, 104, 
            "assets/characters/blythe/bIdleL.gif", 
            "assets/characters/blythe/bIdleL.gif", 
            "assets/characters/blythe/bIdleR.gif",
            "assets/characters/blythe/bWalkL.gif",
            "assets/characters/blythe/bWalkR.gif");
    }

    // methods

    public boolean proximity(Graphics g2d, Entities e){

        boolean temp;

        int top = this.getY();
        int bottom = this.getY()+this.getH();
        int left = this.getX();
        int right = this.getX()+this.getW();

        if (!(e instanceof Blythe)){
            int etop = e.getY();
            int ebottom = e.getY()+e.getH();
            int eleft = e.getX();
            int eright = e.getX()+e.getW();
            
    
            if((top > etop -50 && bottom < ebottom +40)
                && ((left < eright +15)
                && (right > eleft -15))){
                    g2d.drawImage(new ImageIcon("assets/stickers/eSticker.png").getImage(), 200, 200 ,200, 200, null);
                    System.out.println("in proximity with " + e.getS());
                    temp = true;
            }else {
                System.out.println("not in proximity with " + e.getS());
                temp = false;
            }
           
        }  else {
            temp = false;
        }
        return temp;   
    }
    
}
