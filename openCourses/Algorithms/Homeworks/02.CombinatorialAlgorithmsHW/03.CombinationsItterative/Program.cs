using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.CombinationsItterative
{
    class Program
    {
        private static int count = 0;
        static void Main(string[] args)
        {
            GenerateCombos(3, 2);
            Console.WriteLine($"Combination count: {count}");
        }

        static void GenerateCombos(int n, int k)
        {
            int[] arr = new int[k];
            for (int i = 0; i < k; i++)
            {
                arr[i] = i + 1;
            }
            while (arr[k - 1] <= n)
            {
                Console.WriteLine(string.Join(", ", arr));
                count++;

                int t = k - 1;

                while (t != 0 && arr[t] == n - k + t + 1)
                {
                    t--;
                }

                arr[t]++;

                for (int i = t + 1; i < k; i++)
                {
                    arr[i] = arr[i - 1] + 1;
                }
            }
        }
    }
}
