using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.BinomialCoefficients
{
    class BinomialCoefficients
    {
        private static Dictionary<Tuple<int, int>, long> binomsFound = new Dictionary<Tuple<int, int>, long>();

        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            int k = int.Parse(Console.ReadLine());

            long result = Binom(n, k);
            Console.WriteLine(result);
        }

        private static long Binom(int n, int k)
        {
            if (k>n)
            {
                return 0;
            }
            if (k==0 || k == n)
            {
                return 1;
            }

            var current = new Tuple<int, int>(n, k);

            if (!binomsFound.ContainsKey(current))
            {
                binomsFound[current] = Binom(n - 1, k - 1) + Binom(n - 1, k);
            }

            return binomsFound[current];
        }
    }
}
