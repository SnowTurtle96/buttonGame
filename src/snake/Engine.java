/**
 * 
 */
package snake;


import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

/**
 * @author Jamie
 *
 */
public class Engine {

	public JFrame window;
	public JButton red,yellow,blue,green;
	public static Engine engine;
	public JPanel p1;
	public int difficulty = 4;
	public String color;
    public ArrayList<Integer> order;
    private int z;
	
    public Engine()
			
	{         order = new ArrayList<Integer>();	

		showFrame();
		makeFrame();
        
	}
	
	  public void makeFrame()
	  {
		  p1 = new JPanel();
	      p1.setLayout(new GridLayout(2,2));
	      window.add(p1);
	      
	      red = new JButton();
	      yellow = new JButton();
	      blue = new JButton();
	      green = new JButton();
	      
	      red.setBackground(Color.red); 
	      yellow.setBackground(Color.yellow); 
	      blue.setBackground(Color.blue); 
	      green.setBackground(Color.green); 
		  
	      p1.add(red);
		  p1.add(yellow);
		  p1.add(blue);
		  p1.add(green);
		  setPattern();
		  list();

	  }
	  
	  public void showFrame()
	  {
		    window = new JFrame("Snake");
			window.setLocation(200,90);
			window.setSize(800, 800);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        window.setVisible(true);
		  
	  }
	
	 public static void main(String[] args) 
	    {

	        new Engine();
	    }
	 
	 public void displayPattern()
	 {
		 red.setBackground(Color.black);
		
	 
	 }
	 
	 public void setPattern()
	 {
		 int i = 0;
		int n = 0;

		 while(difficulty < i)
		 {
        Random rand = new Random();
		 n = rand.nextInt(4) + 1;
		 
		 System.out.println(n);
		  i ++;
		  
		order.add(n);
		   z = order.size();

	     }
		 
		
}
	 public int list()
	 {
		 return z;
	 }
}

