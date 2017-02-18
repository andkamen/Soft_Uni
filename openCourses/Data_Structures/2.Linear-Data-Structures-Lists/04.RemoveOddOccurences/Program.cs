using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.RemoveOddOccurences
{
    class Program
    {
        static void Main(string[] args)
        {
            var sequence = Console.ReadLine().Split().Select(int.Parse).ToList();

            List<int> result = RemoveOddOccurences(sequence);

            Console.WriteLine(string.Join(" ",result));

        }

        private static List<int> RemoveOddOccurences(List<int> sequence)
        {
            var elements = sequence.Distinct().ToList();
            foreach (int number in elements)
            {
                int occurenceCount = sequence.Count(num => num == number);
                if (occurenceCount % 2 == 1)
                {
                    sequence.RemoveAll(num => num == number);
                }
            }

            return sequence;
        }
    }
}
