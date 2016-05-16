namespace Longest_Common_Subsequence
{
    using System;
    using System.Collections.Generic;
    using System.Data;

    public class LongestCommonSubsequence
    {
        public static void Main()
        {
            var firstStr = "tree";
            var secondStr = "team";

            var lcs = FindLongestCommonSubsequence(firstStr, secondStr);

            Console.WriteLine("Longest common subsequence:");
            Console.WriteLine("  first  = {0}", firstStr);
            Console.WriteLine("  second = {0}", secondStr);
            Console.WriteLine("  lcs    = {0}", lcs);
        }

        public static string FindLongestCommonSubsequence(string firstStr, string secondStr)
        {
            int firstLen = firstStr.Length + 1;
            int secondLen = secondStr.Length + 1;
            int[,] matrix = new int[firstLen, secondLen];
            
            for (int row = 1; row < firstLen; row++)
            {
                for (int col = 1; col < secondLen; col++)
                {
                    if (firstStr[row - 1] == secondStr[col - 1])
                    {
                        matrix[row, col] = matrix[row - 1, col - 1] + 1;
                    }
                    else
                    {
                        matrix[row, col] = Math.Max(matrix[row - 1, col], matrix[row, col - 1]);
                    }
                }
            }

            char[] result = new char[matrix[firstLen - 1, secondLen - 1]];
            int index = result.Length - 1;
            int r = firstLen - 1;
            int c = secondLen - 1;
            while (r > 0 && c > 0)
            {
                if (firstStr[r - 1] == secondStr[c - 1])
                {
                    result[index--] = firstStr[r - 1];
                    r--;
                    c--;
                }
                else if (matrix[r, c] == matrix[r - 1, c])
                {
                    r--;
                }
                else
                {
                    c--;
                }
            }
            
           return new string(result);
        }
    }
}
