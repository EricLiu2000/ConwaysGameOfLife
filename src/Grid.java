import java.awt.Graphics;


public class Grid
{
	private Cell[][] grid;

	
	/*
	 * Makes new grids(arrangements of cells)
	 */
	
	public Grid(int length, int width)
	{
		grid = new Cell[length][width];
		
		for(int i = 0; i < length; i ++)
		{
			for(int j = 0; j < width; j++)
			{
				grid[i][j] = new Cell(i, j);
			}
		}
	}
	

	public void update()
	{
		/*
		 *	Iterates through cells on grid 
		 */
		Cell[][] setterGrid = grid;
		
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[0].length; j++)
			{
				int counter = 0;
				setterGrid[i][j] = grid[i][j];
				
				int a;
				int b;
				
				/*
				 * Cycles through all surrounding cells
				 */
				for(a = Math.max(i-1, 0); a < Math.min(i+1, grid.length); a++)
				{
					for(b = Math.max(j-1, 0); b < Math.min(b+1, grid[0].length); b++)
					{
						
					/*
					 * Makes sure that the selected cell is not counted
					 */
						if(grid[a][b] != grid[i][j])
						{
						/*
						 * Counts living cells
						 */
							if(grid[a][b].isAlive() == true)
							{
								counter ++; 
							}
						}
					}
				}
				/*
				 * Marks cells for death/resurrection based on number of surrounding living cells
				 */
				if(counter < 2)
				{
					setterGrid[i][j].setAlive(false);
				}
				
				if(counter > 3)
				{
					setterGrid[i][j].setAlive(false);
				}
				
				if(counter == 3)
				{
					setterGrid[i][j].setAlive(true);
				}
			}
		}
		/*
		 * Implements changes(kills/resurrects)
		 */
		this.grid = setterGrid;
	}
	
	public void draw(Graphics graphics)
	{
		for(int i = 0; i < grid.length; i ++)
		{
			for(int j = 0; j < grid[0].length; j ++)
			{
				grid[i][j].draw(graphics);
			}
		}
	}
}
