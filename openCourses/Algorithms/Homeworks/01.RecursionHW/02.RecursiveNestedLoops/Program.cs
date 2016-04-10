using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.RecursiveNestedLoops
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = 3;
            Combinations(n);
        }

        private static void Combinations(int n, int[] array = null, int pos = 0)
        {
            if (array == null)
            {
                array = new int[n];
            }

            for (int i = 1; i <= n; i++)
            {
                array[pos] = i;
                if (pos + 1 == n)
                {
                    Print(array);
                }
                if (pos + 1 < n)
                {
                    Combinations(n, array, pos + 1);
                }
            }
        }

        private static void Print(int[] array)
        {
            Console.WriteLine(string.Join(" ", array));
        }
    }
}
