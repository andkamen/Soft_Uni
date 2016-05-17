using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.ThreeBrothers
{
    class Program
    {
        static void Main(string[] args)
        {

            int n = int.Parse(Console.ReadLine());
            Random rnd = new Random();
            for (int i = 0; i < n; i++)
            {
               string[] input = Console.ReadLine().Split();
               int sum= input.Sum(t => int.Parse(t));
                if (sum%3==0)
                {
                    int Result = rnd.Next(2);
                    Console.WriteLine(Result == 0 ? "Yes" : "No");
                }
                else
                {
                    Console.WriteLine("No");
                }
            }

        }
    }
}
