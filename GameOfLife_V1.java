// A simple Java program to implement Game of Life
public class GameOfLife_V1
{
    public static void main(String[] args)
    {
        int M = 6, N = 8;
 
        // Intiliazing the grid.
        int[][] grid = { 
            { 0, 0, 0, 0, 0, 0, 1, 0 },
            { 1, 1, 1, 0, 0, 0, 1, 0 },
            { 0, 0, 0, 0, 0, 0, 1, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 1, 0, 0, 0 },
            { 0, 0, 0, 1, 1, 0, 0, 0 },
       
           
        };
 
        // Displaying the grid
        System.out.println("Original Generation");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (grid[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("o");
            }
            System.out.println();
        }
        System.out.println();
        nextGeneration(grid, M, N);
    }
 
    // Function to print next generation
    static void nextGeneration(int grid[][], int M, int N)
    {
        int[][] future = new int[M][N];
 
        // Loop through every cell
        for (int l = 1; l < M - 1; l++)
        {
            for (int m = 1; m < N - 1; m++)
            {
                // finding no Of Neighbours that are alive
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours += grid[l + i][m + j];
 
                // The cell needs to be subtracted from
                // its neighbours as it was counted before
                aliveNeighbours -= grid[l][m];
 
                // Implementing the Rules of Life
                System.out.println(aliveNeighbours+"  "+grid[l][m]);
                // Cell is lonely and dies
                if ((grid[l][m] == 1) && (aliveNeighbours < 2))
                    future[l][m] = 0;
 
                // Cell dies due to over population
                else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
                    future[l][m] = 0;
 
                // Cell is living remains the same 

                else if ((grid[l][m]==1) && ((aliveNeighbours ==2) || (aliveNeighbours ==3)))

                    future[l][m] = 1;
                // A new cell is born
                else if ((grid[l][m] == 0) && (aliveNeighbours == 3))
                    future[l][m] = 1;
                
                else if (N>M){
                 if (((grid[l][0]==1) && (aliveNeighbours==1)) && (l<N))
                    future[0][l]=1;
                 else if ((grid[l][M-1]==1) && (aliveNeighbours==1) )
                    future[M-1][l]=1;
                    }
                 else {
                    if (((grid[0][m]==1) && (aliveNeighbours==1)) && (m<M) )
                    future[m][0]=1;
                    if (((grid[N-1][m]==1) && (aliveNeighbours==1)) && (m<M))
                    future[m][N-1]=1;
                    }
                    

            }
        }
 
        System.out.println("Next Generation");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (future[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("o");
            }
            System.out.println();
        }
    }
}
