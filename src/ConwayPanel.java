
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class ConwayPanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener
{
	private static Grid grid;
	
	private static JFrame frame;
	
	private static boolean hasStarted = false;
	
	public static void main(String[] args)
	{
		grid = new Grid(500, 500);
		
		frame = new JFrame();
		
		frame.setTitle("Conway's Game of Life");
		frame.setLocationRelativeTo(null);
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(1000,1000));
		
		ConwayPanel panel = new ConwayPanel();
		
		frame.addMouseListener(panel);
		frame.addMouseMotionListener(panel);
		frame.addKeyListener(panel);
		frame.add(panel);
		frame.setVisible(true);
		frame.setLocation(new Point(300,200));
		frame.pack();
		
		
		while(!hasStarted)
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
		}
		
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

	public void mouseClicked(MouseEvent e) 
	{
		int x = (e.getX())/5 - 2;
		int y = (e.getY())/5 - 6;
		grid.getGrid()[x][y].setAlive(true);
	}

	public void mouseEntered(MouseEvent e) 
	{
		
	}

	public void mouseExited(MouseEvent e) 
	{
		
	}

	public void mousePressed(MouseEvent e) 
	{
		
	}

	public void mouseReleased(MouseEvent e) 
	{
		
	}

	public void keyPressed(KeyEvent x) {
		switch(x.getKeyCode())
		{
		case KeyEvent.VK_B:
			hasStarted = true;
			break;	
		}
		
	}
	
	public void keyReleased(KeyEvent arg0) {
		
		
	}

	public void keyTyped(KeyEvent arg0) 
	{	
		
	}

	public void mouseDragged(MouseEvent e) 
	{	
		int x = (e.getX())/5 - 2;
		int y = (e.getY())/5 - 6;
		grid.getGrid()[x][y].setAlive(true);
	}

	
	public void mouseMoved(MouseEvent e) 
	{
		
	}
}
