using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08.DistanceInLabyrinth
{
    using System.Globalization;

    class Program
    {
        private static string[,] matrix =
       {
            {"0", "0", "0", "x", "0", "x"},
            {"0", "x", "0", "x", "0", "x"},
            {"0", "*", "x", "0", "x", "0"},
            {"0", "x", "0", "0", "0", "0"},
            {"0", "0", "0", "x", "x", "0"},
            {"0", "0", "0", "x", "0", "x"},
};


        static void Main(string[] args)
        {
            Cell start = FindStartingPosition();
            if (start == null)
            {
                Console.WriteLine("No starting Position");
                return;
            }

            var cells = new Queue<Cell>();
            cells.Enqueue(start);

            while (cells.Count != 0)
            {
                Cell currentCell = cells.Dequeue();

                //check Up
                if (IsValidPath(currentCell.Row + 1, currentCell.Col))
                {
                    //update matrix cell with distance value
                    matrix[currentCell.Row + 1, currentCell.Col] = (currentCell.Step + 1).ToString();
                    //add new cell to queue to propagate BFS
                    cells.Enqueue(new Cell(currentCell.Row + 1, currentCell.Col, currentCell.Step + 1));
                }
                //check Down
                if (IsValidPath(currentCell.Row - 1, currentCell.Col))
                {
                    matrix[currentCell.Row - 1, currentCell.Col] = (currentCell.Step + 1).ToString();
                    cells.Enqueue(new Cell(currentCell.Row - 1, currentCell.Col, currentCell.Step + 1));
                }
                //check Left
                if (IsValidPath(currentCell.Row, currentCell.Col - 1))
                {
                    matrix[currentCell.Row, currentCell.Col - 1] = (currentCell.Step + 1).ToString();
                    cells.Enqueue(new Cell(currentCell.Row, currentCell.Col - 1, currentCell.Step + 1));
                }
                //check Right
                if (IsValidPath(currentCell.Row, currentCell.Col + 1))
                {
                    matrix[currentCell.Row, currentCell.Col + 1] = (currentCell.Step + 1).ToString();
                    cells.Enqueue(new Cell(currentCell.Row, currentCell.Col + 1, currentCell.Step + 1));
                }
            }

            PrintMatrix();

        }

        private static bool IsValidPath(int row, int col)
        {
            if (row >= 0 && row < matrix.GetLength(0) &&
                col >= 0 && col < matrix.GetLength(1))
            {
                if (matrix[row, col].Equals("0"))
                {
                    return true;
                }
            }

            return false;
        }

        private static void PrintMatrix()
        {
            for (int row = 0; row < matrix.GetLength(0); row++)
            {
                for (int col = 0; col < matrix.GetLength(1); col++)
                {
                    Console.Write("{0, 3}", matrix[row, col] == "0" ? "U" : matrix[row, col]);
                }

                Console.WriteLine();
            }
        }

        private static Cell FindStartingPosition()
        {
            Cell startingPosition = null;
            for (int i = 0; i < matrix.GetLength(0); i++)
            {
                for (int j = 0; j < matrix.GetLength(1); j++)
                {
                    if (matrix[i, j].Equals("*"))
                    {
                        startingPosition = new Cell(i, j, 0);
                    }
                }
            }

            return startingPosition;
        }
    }
}
