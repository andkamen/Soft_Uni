using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06.ImplementReversedList
{
    class ReversedListMain
    {
        static void Main(string[] args)
        {
            var list = new ReversedList<int>();
            for (int i = 0; i < 20; i++)
            {
                list.Add(i);
            }

            Console.WriteLine(String.Join(" ", list));

            list.Remove(2);
            list.Remove(2);

            Console.WriteLine(String.Join(" ", list));
        }
    }
}
