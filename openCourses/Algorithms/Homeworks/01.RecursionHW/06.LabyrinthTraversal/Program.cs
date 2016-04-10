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
            
            FindPathToExist();

        }

        static void FindPathToExist()
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
                // We are out of the labyrinth -> can't find a path
                return;
            }

            // Append the current direction to the path
            path.Add(direction);

            // Check if we have found the exit
            if (labyrinth[row, col] == 'e')
            {
                PrintPath(path);
                PrintLabyrinth();
            }

            if (labyrinth[row, col] == ' ')
            {
                // Temporary mark the current cell as visited
                labyrinth[row, col] = '.';

                // Recursively explore all possible directions
                TryDirection(row, col - 1, 'L'); // left
                TryDirection(row - 1, col, 'U'); // up
                TryDirection(row, col + 1, 'R'); // right
                TryDirection(row + 1, col, 'D'); // down

                // Mark back the current cell as free
                labyrinth[row, col] = ' ';
            }

            // Remove the last direction from the path
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

        //Doesn't Work well with the input from the HW doc, because copy paste from a table sucks :( 
        static void ReadLabyrinth()
        {
            List<string> inputData = new List<string>();

            string input = Console.ReadLine();
                input.Replace("\t"," ");
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
