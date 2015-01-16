
public class Grid
{
	private Cell[][] grid;

	public Grid(int length, int width)
	{
		grid = new Cell[length][width];
		
		for(int i = 0; i < length; i ++)
		{
			for(int j = 0; j < width; j++)
			{
				grid[i][j] = new Cell();
			}
		}
	}
	
	public void setAlive(int x, int y, boolean isAlive)
	{
		
	}
	
	public void update()
	{
		for(int i = 0; i < grid.length; i ++)
		{
			for(int j = 0; j < grid[0].length; j++)
			{
				grid[i][j] = new Cell();
				
			}
		}
	}
}
