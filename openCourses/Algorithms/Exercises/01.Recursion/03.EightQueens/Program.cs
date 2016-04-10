using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.EightQueens
{
    using System.Runtime.InteropServices;

    class Program
    {
        const int Size = 8;
        static bool[,] chessboard = new bool[Size, Size];
        private static int solutionsFound = 0;

        static HashSet<int> attackRows = new HashSet<int>();
        static HashSet<int> attackColumns = new HashSet<int>();
        static HashSet<int> attackLeftDiagonal = new HashSet<int>();
        static HashSet<int> attackRightDiagonal = new HashSet<int>();
        static void Main(string[] args)
        {
            PutQueens(0);

            Console.WriteLine(solutionsFound);
        }


        static void PutQueens(int row)
        {
            if (row == Size)
            {
                PrintSolution();
            }
            else
            {
                for (int col = 0; col < Size; col++)
                {
                    if (CanPlaceQueen(row, col))
                    {
                        MarkAllAttackedPositions(row, col);
                        PutQueens(row + 1);
                        UnmarkAllAttackedPositions(row, col);
                    }
                }
            }
        }


        private static bool CanPlaceQueen(int row, int col)
        {
            var positionOccupied =
                attackRows.Contains(row) ||
                attackColumns.Contains(col) ||
                attackLeftDiagonal.Contains(col - row) ||
                attackRightDiagonal.Contains(col + row);
            return !positionOccupied;
        }
        private static void MarkAllAttackedPositions(int row, int col)
        {
            attackRows.Add(row);
            attackColumns.Add(col);
            attackLeftDiagonal.Add(col - row);
            attackRightDiagonal.Add(col + row);

            chessboard[row, col] = true;
        }

        private static void UnmarkAllAttackedPositions(int row, int col)
        {
            attackRows.Remove(row);
            attackColumns.Remove(col);
            attackLeftDiagonal.Remove(col - row);
            attackRightDiagonal.Remove(col + row);

            chessboard[row, col] = false;
        }

        private static void PrintSolution()
        {
            for (int row = 0; row < Size; row++)
            {
                for (int col = 0; col < Size; col++)
                {
                    Console.Write(chessboard[row, col] ? '*' : '-');
                }
                Console.WriteLine();
            }
            Console.WriteLine();
            solutionsFound++;
        }
    }
}
