
import java.awt.*;

import javax.swing.*;

public class ConwayPanel extends JPanel
{
	private static Grid grid;
	
	private static JFrame frame;
	
	public static void main(String[] args)
	{
		grid = new Grid(100, 100);
		
		frame = new JFrame();
		
		frame.setTitle("Conway's Game of Life");
		frame.setLocationRelativeTo(null);
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(550,550));
		
		ConwayPanel panel = new ConwayPanel();
		
		frame.add(panel);
		frame.setVisible(true);
		frame.setLocation(new Point(300,200));
		frame.pack();
		
		while(true)
		{
			frame.repaint();
			
			try 
			{
				Thread.sleep(50);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			grid.update();
		}
	}
	
	public void paintComponent(Graphics graphics)
	{
		grid.draw(graphics);
	}
}
