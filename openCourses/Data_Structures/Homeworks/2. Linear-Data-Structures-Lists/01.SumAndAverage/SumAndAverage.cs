using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.SumAndAverage
{
    class SumAndAverage
    {
        static void Main(string[] args)
        {
            var input = Console.ReadLine();

            if (string.IsNullOrEmpty(input))
            {
                Console.WriteLine("Sum=0; Average=0");
                return;
            }

            var numbers = input.Split().Select(int.Parse).ToList();
            double average = numbers.Average();
            int sum = numbers.Sum();

            Console.WriteLine($"Sum={sum}; Average={average}");

        }
    }
}
