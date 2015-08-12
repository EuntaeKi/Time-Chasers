
import javax.swing.*;
import java.awt.*;

public class draw extends JPanel{
	public static int x, y;
	public static int mouseX_dragged;
	
	public void drawing(int xx, int yy){
		x = xx;
		y = yy;
		//repaint();
		
		
		//Defining left and right of the window
		if (x < 480 /*This gives the ability to specify a ceratin area: && x > 400*/){
			System.out.println("You are in the left half of the window");
		}
		else{
			System.out.println("You are in the right half of the window");
		}
		
		//Defining center of the window
		if (x == 480){
			System.out.println("You are in the center of the window");
		}
		
		//Print outs to find the coordinates of mouse pushed
		System.out.println("Mouse has been pushed");
		System.out.println("This is the x cord " + x);
		System.out.println("This is the y cord " + y);
		
	}
	
	
	//Having a red circle appear wherever you click
	
	/*public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.RED);;
		g.fillOval(x, y, 20, 20);
	}*/
}
