using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.Parenthesis
{
    class Program
    {
        private static int openCount = 1;
        private static int closeCount = 0;
        private static int half;
        private static StringBuilder array = new StringBuilder();
        
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());
            half = n;

            array.Append("(");
            PrintCombinations(array);


        }

        private static void PrintCombinations(StringBuilder array,int index = 1)
        {
            if (openCount + closeCount == half*2)
            {
                Console.WriteLine(array.ToString());
            }

            if (openCount<half)
            {
                openCount++;
                array.Append("(");
                PrintCombinations(array,index+1);
                array.Remove(index, 1);
                openCount--;
            }

            if (closeCount<openCount)
            {
                closeCount++;
                array.Append(")");
                PrintCombinations(array, index + 1);
                array.Remove(index, 1);
                closeCount--;
            }
        }
    }
}
