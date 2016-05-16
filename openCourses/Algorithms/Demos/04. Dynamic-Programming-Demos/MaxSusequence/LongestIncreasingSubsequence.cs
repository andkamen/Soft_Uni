using System;
using System.Collections.Generic;

class LongestIncreasingSubsequence
{
	const int NO_PREVIOUS = -1;

	static void Main()
	{
		int[] seq = { 3, 4, 8, 1, 2, 4, 32, 6, 2, 5, 33, 4, 38, 22 };
		int[] len = new int[seq.Length];
		int[] prev = new int[seq.Length];

		int bestIndex = CalculateLongestIncreasingSubsequence(seq, len, prev);

		Console.WriteLine("seq[]  = " + String.Join(", ", seq));
		Console.WriteLine("len[]  = " + String.Join(", ", len));
		Console.WriteLine("prev[] = " + String.Join(", ", prev));

		PrintLongestIncreasingSubsequence(seq, prev, bestIndex);
	}

	private static int CalculateLongestIncreasingSubsequence(
        int[] seq, int[] len, int[] prev)
	{
        int bestLen = 0;
		int bestIndex = 0;
		for (int x = 0; x < seq.Length; x++)
		{
			len[x] = 1;
            prev[x] = NO_PREVIOUS;
			for (int i = 0; i <= x - 1; i++)
			{
				if (seq[i] < seq[x] && 1 + len[i] > len[x])
				{
					len[x] = 1 + len[i];
					prev[x] = i;
					if (len[x] > bestLen)
					{
						bestLen = len[x];
						bestIndex = x;
					}
				}
			}
		}
		return bestIndex;
	}

	static void PrintLongestIncreasingSubsequence(int[] seq, int[] prev, int index)
	{
		List<int> lis = new List<int>();
		while (index != NO_PREVIOUS)
		{
			lis.Add(seq[index]);
			index = prev[index];
		}
		lis.Reverse();
		Console.WriteLine("subsequence = [{0}]", string.Join(", ", lis));
	}
}
