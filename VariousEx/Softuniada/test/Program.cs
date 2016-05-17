using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace test
{
    class Program
    {
        static void Main(string[] args)
        {
            int test = 1111;
            int[] letters = new Int32[4];
            int i=0;
            foreach (var ch in test.ToString())
            {
                letters[i++] = ch;
            }
           
            foreach (var ch in letters)
            {
                Console.WriteLine((char)ch);
            }
        }
    }
}
