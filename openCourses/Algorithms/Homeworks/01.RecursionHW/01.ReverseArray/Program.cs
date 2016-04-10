using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01.ReverseArray
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] array = {1, 2, 3, 4, 5, 6};

            ReverseArr(array,array.Length-1);
        }

        private static void ReverseArr(int[] array, int position)
        {
            if (position<0)
            {
                return;
            }
            Console.Write("{0} ",array[position]);
            ReverseArr(array,position-1);
        }


    }
}
