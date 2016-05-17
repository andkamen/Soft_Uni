using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.EqualSum
{
    class Program
    {
        static void Main(string[] args)
        {
            int a = int.Parse(Console.ReadLine());
            int b = int.Parse(Console.ReadLine());
            int c = int.Parse(Console.ReadLine());
            int d = int.Parse(Console.ReadLine());

            if (a == b + c + d)
            {
                Console.WriteLine("Yes");
                Console.WriteLine(a);
            }
            else if (b == a + c + d)
            {
                Console.WriteLine("Yes");
                Console.WriteLine(b);
            }
            else if (c == a + b + d)
            {
                Console.WriteLine("Yes");
                Console.WriteLine(c);
            }
            else if (d == a + b + c)
            {
                Console.WriteLine("Yes");
                Console.WriteLine(d);
            }
            else if (a + b == c + d)
            {
                Console.WriteLine("Yes");
                Console.WriteLine(a + b);
            }
            else if (a + c == b + d)
            {
                Console.WriteLine("Yes");
                Console.WriteLine(a + c);
            }
            else if (a + d == b + c)
            {
                Console.WriteLine("Yes");
                Console.WriteLine(a + d);
            }
            else
            {
                Console.WriteLine("No");
            }
        }
    }
}
