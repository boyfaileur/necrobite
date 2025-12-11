import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Entities {

    private int x, y, dx, dy, w, h;
    private String s, iL, iR, wL, wR; 

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

    public Entities (int x1, int y1, int dx1, int dy1, int width, int height, String sprite, String idleL, String idleR, String walkL, String walkR){
        x = x1;
        y = y1;
        dx = dx1;
        dy = dy1;
        w = width*2;
        h = height*2;
        s = sprite;
        iL = idleL;
        iR = idleR;
        wL = walkL;
        wR = walkR;
    }

    public void drawEnt(Graphics g2d){
        g2d.drawImage(new ImageIcon(s).getImage(), x, y, w, h, null);
    }

    public void moveEnt(){
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getiL() {
        return iL;
    }

    public void setiL(String iL) {
        this.iL = iL;
    }

    public String getiR() {
        return iR;
    }

    public void setiR(String iR) {
        this.iR = iR;
    }

    public String getwL() {
        return wL;
    }

    public void setwL(String wL) {
        this.wL = wL;
    }

    public String getwR() {
        return wR;
    }

    public void setwR(String wR) {
        this.wR = wR;
    }

    
}
