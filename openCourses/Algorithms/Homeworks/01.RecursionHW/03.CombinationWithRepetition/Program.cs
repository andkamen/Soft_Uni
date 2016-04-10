using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.CombinationWithRepetition
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int k = int.Parse(Console.ReadLine());
            //int n = 3;
            //int k = 2;

            int[] array = new int[k];

            GenerateCombinations(array, n);
        }

        private static void GenerateCombinations(int[] array, int sizeOfSet, int index = 0, int start = 1)
        {
            if (index >= array.Length)
            {
                Print(array);
            }
            else
            {
                for (int i = start; i <= sizeOfSet; i++)
                {
                    array[index] = i;
                    GenerateCombinations(array, sizeOfSet, index + 1, i);
                }
            }
        }

        private static void Print(int[] array)
        {
            Console.WriteLine("({0})", string.Join(", ", array));
        }
    }
}

