import java.awt.Color;
import java.awt.Graphics;


public class Cell 
{
	private boolean isAlive;
	
	private int x;
	private int y;
	
	public static final int CELL_SIDE_LENGTH = 5;
			
	
	public Cell(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.isAlive = false;
	}
	
	public Cell(int x, int y, boolean isAlive)
	{
		this.x = x;
		this.y = y;
		this.isAlive = isAlive;
	}
	
	public void draw(Graphics graphics)
	{
		if(isAlive())
		{
			graphics.setColor(Color.BLACK);
		}
		else
		{
			graphics.setColor(Color.WHITE);
		}
		
		graphics.fillRect(x*CELL_SIDE_LENGTH, y*CELL_SIDE_LENGTH, CELL_SIDE_LENGTH, CELL_SIDE_LENGTH);
	}
	
	public void setAlive(boolean isAlive)
	{
		this.isAlive = isAlive;
	}
	
	public boolean isAlive()
	{
		return isAlive;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
}
