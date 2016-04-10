using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.RecursiveDrawing
{
    class Program
    {
        static void Main(string[] args)
        {
            Draw('#');
        }

        private static void Draw(char c=(char)7, int n = 10, bool decreasing = true)
        {
            Console.WriteLine(new string(c, n));

            if (decreasing && n > 1)
            {
                Draw(c, n - 1, true);
            }
            else if (decreasing && n == 1)
            {
                Draw(c, n + 1, false);
            }
            else if (!decreasing && n < 10)
            {
                Draw(c, n + 1, false);
            }
            else if (!decreasing && n == 10)
            {
                Draw(c, n - 1, true);
            }
        }
    }
}
