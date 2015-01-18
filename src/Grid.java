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
				if((int)(2*Math.random()) == 0)
				{
					grid[i][j] = new Cell(i, j);
				}
				else
				{
					grid[i][j] = new Cell(i, j, true);
				}
			}
		}
		
	}
	

	public void update()
	{
		/*
		 *	Iterates through cells on grid 
		 */
		Cell[][] setterGrid = new Cell[grid.length][grid[0].length];
		
		for(int i = 0; i < setterGrid.length; i++)
		{
			for(int j = 0; j < setterGrid[0].length; j++)
			{
				setterGrid[i][j] = new Cell(i, j, grid[i][j].isAlive());
			}
		}
		
		for(int i = 0; i < grid.length; i++)
		{
			for(int j = 0; j < grid[0].length; j++)
			{
				int counter = 0;
				
				/*
				 * Cycles through all surrounding cells
				 */
				for(int a = Math.max(i-1, 0); a <= Math.min(i+1, grid.length - 1); a++)
				{
					for(int b = Math.max(j-1, 0); b <= Math.min(j+1, grid[0].length - 1); b++)
					{
						
					/*
					 * Makes sure that the selected cell is not counted
					 */
						if(!(a == i && b == j))
						{
						/*
						 * Counts living cells
						 */
							if(grid[a][b].isAlive())
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
