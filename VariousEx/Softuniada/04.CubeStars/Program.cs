using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.CubeStars
{
    class Program
    {
        static void Main(string[] args)
        {

            int n = int.Parse(Console.ReadLine());

            int starCount=0;

            char[, ,] matrix = new char[n, n, n];

            SortedList<char,int> stars = new SortedList<char, int>();

            string[] input = new string[n];
            for (int i = 0; i < n; i++)
            {
                input[i] = Console.ReadLine();
            }

            

            for (int r = 0; r < n; r++)
            {
                for (int h = 0; h < n; h++)
                {
                    for (int c = 0; c < n; c++)
                    {
                        matrix[r, h, c] = input[r][2*h*(n+1)+c*2];
                       // Console.Write(matrix[r, h, c]);
                    }
                    //Console.Write(" | ");
                }
               // Console.WriteLine();
            }

            for (int r = 1; r < n-1; r++)
            {
                for (int h = 0; h < n-2; h++)
                {
                    for (int c = 1; c < n-1; c++)
                    {
                        if (matrix[r, h, c] == matrix[r, h+1, c] &&
                            matrix[r, h, c] == matrix[r+1, h+1, c] &&
                            matrix[r, h, c] == matrix[r-1, h+1, c] &&
                            matrix[r, h, c] == matrix[r, h+1, c+1] &&
                            matrix[r, h, c] == matrix[r, h+1, c-1] &&
                            matrix[r, h, c] == matrix[r, h+2, c] )
                        {
                            starCount++;
                            if(!stars.ContainsKey(matrix[r, h, c]))
                            {
                                stars.Add(matrix[r, h, c],1);
                            }
                            else
                            {
                                stars[matrix[r, h, c]]++;
                            }
                        }
                    }
                }
            }
            
            Console.WriteLine(starCount);
            foreach (var entry in stars)
            {
                Console.WriteLine("{0} -> {1}", entry.Key, entry.Value);
            }

        }
    }
}
