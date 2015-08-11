
import javax.swing.*;
import java.awt.event.*;

//Tutorial from: https://www.youtube.com/watch?v=TMWUZ5vzghc
//MouseListener stuff: http://docs.oracle.com/javase/7/docs/api/java/awt/event/MouseEvent.html

public class mouse {
	private static int x, y, a, b;
	private static draw object = new draw();
	
	public static void main(String[] args){
		JFrame frame = new JFrame("Mouse");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.add(object);
		object.addMouseListener(new AL());
	}
	
	static class AL extends MouseAdapter{
		public void mouseClicked (MouseEvent e){
			x = e.getX();
			y = e.getY();
			//object.drawing(x, y);
		}
	}
}