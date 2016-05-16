using System.Collections.Generic;
using System.Runtime.InteropServices;

namespace Longest_Increasing_Subsequence
{
    using System;

    public class LongestIncreasingSubsequence
    {
        public static void Main()
        {
            var sequence = new[] { 3, 14, 5, 12, 15, 7, 8, 9, 11, 10, 1 };
            var longestSeq = FindLongestIncreasingSubsequence(sequence);
            Console.WriteLine("Longest increasing subsequence (LIS)");
            Console.WriteLine("  Length: {0}", longestSeq.Length);
            Console.WriteLine("  Sequence: [{0}]", string.Join(", ", longestSeq));
        }

        public static int[] FindLongestIncreasingSubsequence(int[] sequence)
        {
            int[] len = new int[sequence.Length];
            int[] prev = new int[sequence.Length];

            int maxLen = 0;
            int lastIndex = -1;

            for (int x = 0; x < sequence.Length; x++)
            {
                len[x] = 1;
                prev[x] = -1;

                for (int i = 0; i < x; i++)
                {
                    if (sequence[i] < sequence[x] && len[i] + 1 > len[x])
                    {
                        len[x] = len[i] + 1;
                        prev[x] = i;
                    }
                }

                if (len[x] > maxLen)
                {
                    maxLen = len[x];
                    lastIndex = x;
                }



            }
            var longestSeq = new List<int>();

            while (lastIndex != -1)
            {
                longestSeq.Add(sequence[lastIndex]);
                lastIndex = prev[lastIndex];
            }

            longestSeq.Reverse();

            return longestSeq.ToArray();



        }
    }
}