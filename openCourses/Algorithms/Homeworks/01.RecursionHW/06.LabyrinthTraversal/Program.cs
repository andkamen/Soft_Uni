using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.LabyrinthTraversal
{
    using System.Runtime.InteropServices;

    class Program
    {
        static List<char> path = new List<char>();

        private static char[,] labyrinth = 
        {
            {'s',' ',' ',' ',' ',' '},
            {' ','*','*',' ','*',' '},
            {' ','*','*',' ','*',' '}, 
            {' ','*','e',' ',' ',' '},
            {' ',' ',' ','*',' ',' '}
        };

        public static void Main()
        {
            //ReadLabyrinth();

            FindPathToExit();

        }

        static void FindPathToExit()
        {
            for (int row = 0; row < labyrinth.GetLength(0); row++)
            {
                for (int col = 0; col < labyrinth.GetLength(1); col++)
                {
                    if (labyrinth[row, col] == 's')
                    {
                        TryDirection(row, col - 1, 'L');
                        TryDirection(row - 1, col, 'U');
                        TryDirection(row, col + 1, 'R');
                        TryDirection(row + 1, col, 'D');
                    }
                }
            }
        }

        private static void TryDirection(int row, int col, char direction)
        {
            if (!InRange(row, col))
            {
                return;
            }

            path.Add(direction);

            if (labyrinth[row, col] == 'e')
            {
                PrintPath(path);
                PrintLabyrinth();
            }

            if (labyrinth[row, col] == ' ')
            {
                labyrinth[row, col] = '.';

                TryDirection(row, col - 1, 'L');
                TryDirection(row - 1, col, 'U');
                TryDirection(row, col + 1, 'R');
                TryDirection(row + 1, col, 'D');

                labyrinth[row, col] = ' ';
            }

            path.RemoveAt(path.Count - 1);
        }

        static bool InRange(int row, int col)
        {
            bool rowInRange = row >= 0 && row < labyrinth.GetLength(0);
            bool colInRange = col >= 0 && col < labyrinth.GetLength(1);

            return rowInRange && colInRange;
        }

        static void PrintLabyrinth()
        {
            for (int row = 0; row < labyrinth.GetLength(0); row++)
            {
                for (int col = 0; col < labyrinth.GetLength(1); col++)
                {
                    Console.Write("{0} ", labyrinth[row, col]);
                }

                Console.WriteLine();
            }
        }

        static void PrintPath(List<char> path)
        {
            Console.Write("Found path to the exit: ");
            foreach (var dir in path)
            {
                Console.Write(dir);
            }
            Console.WriteLine();
        }

        //Doesn't Work well with the input from the HW doc, because copy paste from a word table sucks :(  ☺☺
        //might as well not use at all
        static void ReadLabyrinth()
        {
            List<string> inputData = new List<string>();

            string input = Console.ReadLine();
            input.Replace("\t", " ");
            while (!string.IsNullOrWhiteSpace(input))
            {
                inputData.Add(input);
                input = Console.ReadLine();
                input.Replace("\t", " ");
            }

            labyrinth = new char[inputData.Count, inputData[0].Length];

            for (int row = 0; row < labyrinth.GetLength(0); row++)
            {
                for (int col = 0; col < labyrinth.GetLength(1); col++)
                {
                    labyrinth[row, col] = inputData[row][col];
                }
            }
        }
    }
}
