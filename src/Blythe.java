
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.ImageIcon;



public class Blythe extends Entities{

    private int top, bottom, left, right;

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
        
        if (!(e instanceof Blythe)){
            int etop = e.getY();
            int ebottom = e.getY()+e.getH();
            int eleft = e.getX();
            int eright = e.getX()+e.getW();
            
    
            if((top > etop -50 && bottom < ebottom +40)
                && ((left < eright +15)
                && (right > eleft -15))){
                    g2d.drawImage(new ImageIcon("assets/stickers/eSticker.png").getImage(), (e.getX()+(e.getW()/2)-13), (e.getY()+(e.getH()/2))+18 ,26, 26, null);
                    temp = true;
            }else {
                temp = false;
            }
           
        }  else {
            temp = false;
        }
        return temp;   
    }

    public void moveEnt(){

        top = this.getY();
        bottom = this.getY()+this.getH();
        left = this.getX();
        right = this.getX()+this.getW();


        int wi = Toolkit.getDefaultToolkit().getScreenSize().width;
        int hi = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        super.moveEnt();

        if (left<0){
            this.setX(0);
        }
        if (top<0){
            this.setY(0);
        }
        if (right>wi){
            setX((wi-this.getW()));
        }
        if (bottom>hi){
            setY(hi-(this.getH()));
        }
    }
    
}
