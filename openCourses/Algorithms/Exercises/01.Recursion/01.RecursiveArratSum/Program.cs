using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.RecursiveArratSum
{
    class Program
    {
        static void Main(string[] args)
        {

            int[] array = { 1, 2, 3, 4, 5 };

            Console.WriteLine(FindSum(array));

        }

        private static int FindSum(int[] array, int index = 0)
        {
            if (index == array.Length - 1)
            {
                return array[index];
            }
            int sum = FindSum(array, index + 1);
            return array[index] + sum;
        }
    }
}
