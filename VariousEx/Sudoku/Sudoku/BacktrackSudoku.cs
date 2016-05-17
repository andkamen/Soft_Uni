using System;

namespace Sudoku
{
    class BacktrackSudoku
    {
        private const int N = 9;

        static void Main()
        {
            int[,] grid = new int[N, N];

            ReadGridFromLine(grid);
            //ReadGridFromBox(grid);


            if (SolveSudoku(grid))
            {
                PrintGrid(grid);
            }
            else
            {
                Console.WriteLine("No solution exists");
            }
        }

        private static bool SolveSudoku(int[,] grid)
        {
            int row = 0, col = 0;

            if (!FindFreeCell(grid, ref row, ref col))
            {
                return true; // grid is full, aka solved
            }

            for (int num = 1; num <= N; num++)
            {
                if (IsValidNum(grid, row, col, num))
                {
                    //attempt to solve with num
                    grid[row, col] = num;

                    if (SolveSudoku(grid))
                    {
                        return true;
                    }

                    //if num is invalid, delete it and try a new one
                    grid[row, col] = 0;
                }
            }

            return false; // no solution found
        }

        private static bool FindFreeCell(int[,] grid, ref int row, ref int col)
        {
            for (row = 0; row < N; row++)
            {
                for (col = 0; col < N; col++)
                {
                    if (grid[row, col] == 0)
                    {
                        return true; // found a free cell
                    }
                }
            }
            return false;
        }

        private static bool IsValidNum(int[,] grid, int row, int col, int num)
        {
            bool isValidCol = CheckCol(grid, row, col, num);
            bool isValidRow = CheckRow(grid, row, col, num);
            bool isValidBox = CheckBox(grid, row, col, num);

            return isValidBox && isValidCol && isValidRow;
        }

        private static bool CheckBox(int[,] grid, int row, int col, int num)
        {
            int boxStartRow = row - row % (N / 3);
            int boxStartCol = col - col % (N / 3);

            for (int r = boxStartRow; r < boxStartRow + N / 3; r++)
            {
                for (int c = boxStartCol; c < boxStartCol + N / 3; c++)
                {
                    if (grid[r, c] == num)
                    {
                        return false;
                    }
                }
            }

            return true;
        }

        private static bool CheckRow(int[,] grid, int row, int col, int num)
        {
            for (int c = 0; c < N; c++)
            {
                if (grid[row, c] == num)
                {
                    return false;
                }
            }
            return true;
        }

        private static bool CheckCol(int[,] grid, int row, int col, int num)
        {
            for (int r = 0; r < N; r++)
            {
                if (grid[r, col] == num)
                {
                    return false;
                }
            }
            return true;
        }

        private static void ReadGridFromBox(int[,] grid)
        {
            for (int r = 0; r < N; r++)
            {
                var inputArr = Console.ReadLine().ToCharArray();
                for (int c = 0; c < N; c++)
                {
                    grid[r, c] = inputArr[c]-48;
                }
            }
        }

        private static void ReadGridFromLine(int[,] grid)
        {

            string rawInput = "306508400520000000087000031003010080900863005050090600130000250000000074005206300";
            //string rawInput = ".................................................................................";
            rawInput = Console.ReadLine();

            var inputArr = rawInput.ToCharArray();

            for (int r = 0; r < N; r++)
            {
                for (int c = 0; c < N; c++)
                {
                    char inputNum = inputArr[r * N + c];
                    int num = inputNum == '.' || inputNum == '0' ? 0 : inputNum - 48;

                    grid[r, c] = num;
                }
            }
        }

        private static void PrintGrid(int[,] grid)
        {
            Console.WriteLine("--------+------+-------");
            for (int r = 0; r < grid.GetLength(0); r++)
            {
                Console.Write("| ");
                for (int c = 0; c < grid.GetLength(1); c++)
                {
                    if (c % 3 == 0 && c != 0)
                    {
                        Console.Write("|");
                    }
                    Console.Write(grid[r, c] == 0 ? ". " : $"{grid[r, c]} ");
                }
                Console.Write("| ");

                if (r % 3 == 2)
                {
                    Console.WriteLine();
                    Console.WriteLine("--------+------+-------");
                }
                else
                {
                    Console.WriteLine();
                }
            }
        }
    }
}
