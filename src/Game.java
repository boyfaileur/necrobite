
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.*; 


public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	
	private BufferedImage back; 
	private int key, x, y, hi, wi, rem; 

	private String screen, speaker;

	// lists
	private ArrayList <Entities> active;
	private ArrayList<String> dialogueList;


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
		wi = Toolkit.getDefaultToolkit().getScreenSize().width;
        hi = Toolkit.getDefaultToolkit().getScreenSize().height;

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

	public ArrayList<String> setDialogue(String dialogueFile){ // setting up the dialogue file
		ArrayList<String> temp = new ArrayList<String>();
		File file = new File(dialogueFile);

		Scanner scan;
        try {
            scan = new Scanner(file);

            while(scan.hasNextLine()){  
                String word = scan.nextLine();
                temp.add(word);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        temp.add(" ");

		return temp;
	}

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
		g2d.setFont(new Font("Jersey 10", Font.PLAIN, 35)); 

	
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

			

			for (int j = 0; j < active.size(); j++){
				if ((active.get(i).getH()+active.get(i).getY()>
				active.get(j).getH()+active.get(j).getY())&&(i<j)){
					System.out.println("supposed to swap");
					Collections.swap(active, i, j);
				} 
				
			}
			

			active.get(i).drawEnt(g2d);
			b.proximity(g2d, active.get(i));

			if (!(active.get(i) instanceof Blythe)){
				Entities e = active.get(i);
				
				
				if (e.isT()){

					g2d.drawImage(new ImageIcon("assets/boxes/silverdbox.png").getImage(), ((wi/2) - 350), (hi - 258), 350*2, 108*2,this);

					g2d.setColor(Color.WHITE);
					if (dialogueList==null){
						setDialogue();
						
					} 

					if (dialogueList.size()<=1){
						e.setT(false);
						e.setA(true);
					}
						setSpeaker();
						g2d.drawString(speaker, (wi/2) - 325, hi - 200);
						g2d.drawString((dialogueList.get(0)), (wi/2) - 325, (hi - 180));
					}
					
			}
		}
	}

	private void setDialogue(){
		for (int i = 0; i < active.size(); i++) {

			if (!(active.get(i) instanceof Blythe)){
				Entities e = active.get(i);
				if (e.isT()){
				
				String cD = e.getdF();
				dialogueList = setDialogue(cD); // setting the dialogue file
				// at this point, the name is still attached to the sentence
				
			}
			}
			
		}
	}

	public void setSpeaker(){
		if (dialogueList.size()>0){
			for (int j = 0; j < active.size(); j++) {
				speaker = setSpeaker(active.get(j), dialogueList); // this removes the speaker from the beginning of the line

			}	
		}
	}

	private String setSpeaker(Entities e, ArrayList<String> dialogueList){
		String currentLine = dialogueList.get(0);
		String temp;
		if (currentLine.startsWith(e.getN())){
			temp = e.getN();
			dialogueList.set(0,currentLine.replace(e.getN(), ""));
		} else {
			temp = "";
		}
		return temp;
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

	// other 

	


	


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


		if (key == 69){ // E
			b.setT(true);
			setDialogue();
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

		if (key == 69){ // E
			b.setT(false);
		}

		if (key == 32){
			if (dialogueList.size()>0){
				dialogueList.remove(0);
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
