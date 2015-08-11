
import javax.swing.*;
import java.awt.*;

public class draw extends JPanel{
	public static int x, y;
	
	public void drawing(int xx, int yy){
		x = xx;
		y = yy;
		//repaint();
		
		
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
