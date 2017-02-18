using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03.LongestSubsequence
{
    class LongestSubsequence
    {
        static void Main(string[] args)
        {
            var sequence = Console.ReadLine().Split().Select(int.Parse).ToList();
            var longestSubsequence = sequence.GroupBy(num => num).OrderByDescending(num => num.Count()).First();

            Console.WriteLine(string.Join(" ", longestSubsequence));
        }
    }
}
