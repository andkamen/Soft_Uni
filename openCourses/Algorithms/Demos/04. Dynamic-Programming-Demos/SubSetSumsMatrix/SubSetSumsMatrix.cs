using System;
using System.Collections.Generic;

class SubSetSums
{
	static int[] nums = { 5, 5, 15, 20, 1 };
	static int sum = 26;
	static bool[,] possibleSum = new bool[nums.Length, sum + 1];
	static bool[,] isCalculated = new bool[nums.Length, sum + 1];

	static void Main()
	{
        bool possibleSum = CalcPossibleSums(nums.Length - 1, sum);
		if (possibleSum)
		{
			PrintSubset(nums.Length - 1, sum);
		}
		else
		{
			Console.WriteLine("Not possible!");
		}
	}

	static bool CalcPossibleSums(int i, int sum)
	{
		if (sum < 0 || i < 0)
		{
			return false;
		}

		if (!isCalculated[i, sum])
		{
			possibleSum[i, sum] =
				(nums[i] == sum) ||
				CalcPossibleSums(i - 1, sum) ||
				CalcPossibleSums(i - 1, sum - nums[i]);
			isCalculated[i, sum] = true;
		}

		return possibleSum[i, sum];
	}

	private static void PrintSubset(int i, int sum)
	{
		Console.Write(sum + " = ");
		List<int> nums = new List<int>();
		while (true)
		{
			if (SubSetSums.nums[i] == sum)
			{
                // Take the last sum
				nums.Add(SubSetSums.nums[i]);
				break;
			}
			else if (CalcPossibleSums(i - 1, sum - SubSetSums.nums[i]))
			{
				// Take arr[i]
				nums.Add(SubSetSums.nums[i]);
				sum = sum - SubSetSums.nums[i];
				i = i - 1;
			}
			else if (CalcPossibleSums(i - 1, sum))
			{
				// Skip arr[i]
				i = i - 1;
			}
		}
		Console.WriteLine(string.Join(" + ", nums));
	}
}
