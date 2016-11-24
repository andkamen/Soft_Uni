using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05.CountOfOccurences
{
    class CountOfOccurences
    {
        static void Main(string[] args)
        {
            var sequence = Console.ReadLine().Split().Select(int.Parse).ToList();

            Dictionary<int,int> occurenceCount = new Dictionary<int, int>();

            foreach (var number in sequence)
            {
                if (!occurenceCount.ContainsKey(number))
                {
                    occurenceCount.Add(number,0);
                }

                occurenceCount[number]++;
            }

            foreach (KeyValuePair<int, int> numberCountPair in occurenceCount.OrderBy(key => key.Key))
            {
                Console.WriteLine($"{numberCountPair.Key} -> {numberCountPair.Value} times");
            }
        }
    }
}
