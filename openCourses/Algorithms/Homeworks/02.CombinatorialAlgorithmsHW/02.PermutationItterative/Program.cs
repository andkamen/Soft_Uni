using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.PermutationItterative
{
    class Program
    {
        private static int countOfPermuations = 0;

        static void Main()
        {
            //int N = int.Parse(Console.ReadLine());
            int N =4;
            var array = Enumerable.Range(1, N).ToArray();
            int[] p = new int[N];

            int i = 1;
            int j=0;
            while (i < N)
            {
                if (p[i] < i)
                {
                    j = i % 2 == 1 ? p[i] : 0;
                    Console.WriteLine(string.Join(", ", array));
                    Swap(ref array[j],ref array[i]);
                    countOfPermuations++;

                    p[i]++;
                    i = 1;
                }
                else
                {
                    p[i] = 0;
                    i++;
                }
            }

            Swap(ref array[j], ref array[1]);
            countOfPermuations++;

            Console.WriteLine($"Total Permuations: {countOfPermuations}");
        }
        

        static void Swap(ref int i, ref int j)
        {
            if (i == j)
            {
                return;
            }
            i ^= j;
            j ^= i;
            i ^= j;
        }
    }
}
