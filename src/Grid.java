
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
		
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[0].length; j++)
			{
				int counter = 0;
				
				for(int a = i-1; a < i+1; a++)
				{
					for(int b = j-1; b<b+1; b++)
					{
						
					
						if(grid[a][b] != grid[i][j])
						{
						
							if(grid[a][b].isAlive() == true)
							{
								counter ++; 
							}
						}
					}
				}

				if(counter < 2)
				{
					grid[i][j].setAlive(false);
				}
				
				if(counter > 3)
				{
					grid[i][j].setAlive(false);
				}
				
				if(counter == 3)
				{
					grid[i][j].setAlive(true);
				}
			}
		}
	}
}
