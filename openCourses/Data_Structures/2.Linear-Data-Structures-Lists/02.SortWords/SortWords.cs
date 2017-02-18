using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.SortWords
{
    class SortWords
    {
        static void Main(string[] args)
        {
            var words = Console.ReadLine().Split().ToList();
            words.Sort();
            Console.WriteLine(String.Join(" ", words));
        }
    }
}
