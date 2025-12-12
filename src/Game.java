
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.*; 


public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	
	private BufferedImage back; 
	private int key, x, y, hi, wi; 

	private String screen;

	// lists
	private ArrayList <Entities> active;


	// entities
	private Blythe b;
	private Fern f; 
	
	

	
	public Game() {

		// setup
		
		new Thread(this).start();	
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		screen = "studio";

		// ints
		key =-1; 
		x=0;
		y=0;

		//lists
		active = setActive();

		// entities
		b = new Blythe(200,200);
		f = new Fern(400, 400);
		
	}

	// setting arraylists

	public ArrayList<Entities> setActive(){
		ArrayList<Entities> temp = new ArrayList<Entities>();
		temp.add(b);
		temp.add(f);
		return temp;
	}


	// you can probably set the characters and stuff in backgrounds
	
	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }
	   		catch(Exception e)
	      {
	      }
	  	}
	
	public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
		

		Graphics g2d = back.createGraphics();
	
		g2d.clearRect(0,0,getSize().width, getSize().height);

		// Set the font to be used for the dialogue text (example font)
		Font font = new Font("Arial", Font.PLAIN, 35);
		g2d.setFont(font);
	
		// Get the FontMetrics for the current font
		FontMetrics fm = g2d.getFontMetrics();
		
	
		drawScreens(g2d);
		setup(g2d);
	
		
		twoDgraph.drawImage(back, null, 0, 0);

	}

	// setup

	public void setup(Graphics g2d){
		b.moveEnt();	

		// drawing entities
		for (int i = 0; i < active.size(); i++) {

			if (active.get(i) == null){
				active = setActive();
			}
			
			active.get(i).drawEnt(g2d);
			b.proximity(g2d, active.get(i));
		}
	}

	private void drawScreens(Graphics g2d){

		switch (screen){
			case "studio":
			studio();
			break;
		}
		

	}

	// different screens

	public void studio(){

	}

	public void sculpting(){

	}

	


	


	//DO NOT DELETE
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


//DO NOT DELETE
	@Override
	public void keyPressed(KeyEvent e) {
		key= e.getKeyCode();
		System.out.println(key);

		// 87 w
		// 65 a
		// 83 s
		// 68 d

		
		
		
		// System.out.println(testDialogue.isaChoosing());
		if (key == 87){ // W
			b.setDy(-1);

		} else if (key == 83){ // S
			b.setDy(1);
		} else if (key == 65){ // A
			b.setDx(-1);
			b.setS(b.getwL());

		} else if (key == 68){ // D
			b.setDx(1);
			b.setS(b.getwR());
		}
			




		// player movement
		

		
	}


	//DO NOT DELETE
	@Override
	public void keyReleased(KeyEvent e) {
		// player movement
		b.setDy(0);
		b.setDx(0);

		if ( key == 65 ){
			b.setS(b.getiL());
		} else if (key == 68){
			b.setS(b.getiR());
		} else if (key == 87 || key == 83){
			if (b.getS()==b.getwL()){
				b.setS(b.getiL());
			} 
			else if (b.getS()==b.getwR()){
				b.setS(b.getiR());
			} 
		}
	}



	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		x=arg0.getX();
		y=arg0.getY();
	}



	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("entered");
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("exited");
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		System.out.println("you clicked at x: "+ arg0.getX() + ", y: " + arg0.getY());
		x=arg0.getX();
		y=arg0.getY();
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	

	
}
