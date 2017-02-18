using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _1.ReverseNumbersWithStack
{
    class Program
    {
        static void Main(string[] args)
        {
            var input = Console.ReadLine();
            if (string.IsNullOrEmpty(input))
            {
                Console.WriteLine("(Empty)");
                return;
            }

            var numbers = input.Split().Select(int.Parse).ToList();

            Stack<int> reverseNums = new Stack<int>();

            foreach (var number in numbers)
            {
                reverseNums.Push(number);
            }

            Console.WriteLine(string.Join(" ", reverseNums.ToArray()));
        }
    }
}
