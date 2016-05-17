using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.DrawHouse
{
    class Program
    {
        static void Main(string[] args)
        {
            //mazalqk ↓
            int n = int.Parse(Console.ReadLine());

            string part1 = new string('.', n - 1) + "*" + new string('.', n - 1);
            Console.WriteLine(part1);

            for (int i = 1; i < n-1; i++)
            {
                string part2 = new string('.', n - i -1) + "*"+new string(' ',2*i-1) +"*"+ new string('.', n - i-1);
                Console.WriteLine(part2);
            }
           
            string part3="";
            for (int i = 1; i < n; i++)
            {
                part3 += "* ";
               
            }
            part3 += "*";
            Console.WriteLine(part3);

            string floor = "+" + new string('-',2*n-3) + "+";
            Console.WriteLine( floor);


            for (int i = 0; i < n-2; i++)
            {
                string walls = "|"+new string(' ',2*n-3) + "|";
                Console.WriteLine( walls);
            }

            Console.WriteLine( floor);
        }
    }
}
