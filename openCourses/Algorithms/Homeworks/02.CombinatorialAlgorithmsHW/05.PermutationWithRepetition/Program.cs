using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05.PermutationWithRepetition
{
    class Program
    {
        static void Main()
        {
            var arr = new int[] { 3, 5, 1, 5, 5 };
            
            //Madness
            arr = Console.ReadLine().
                Replace("}", "").
                Substring(5).
                Split(new char[] { ',', ' ' }, StringSplitOptions.RemoveEmptyEntries).
                Select(str =>
                {
                    int value = int.Parse(str);
                    return value;
                }).ToArray();

            Array.Sort(arr);
            PermuteRep(arr, 0, arr.Length - 1);
        }

        static void PermuteRep(int[] arr, int start, int end)
        {
            Print(arr);

            for (int left = end - 1; left >= start; left--)
            {
                for (int right = left + 1; right <= end; right++)
                {
                    if (arr[left] != arr[right])
                    {
                        Swap(ref arr[left], ref arr[right]);
                        PermuteRep(arr, left + 1, end);
                    }
                }

                // Undo all modifications done by the
                // previous recursive calls and swaps
                var firstElement = arr[left];
                for (int i = left; i <= end - 1; i++)
                {
                    arr[i] = arr[i + 1];
                }
                arr[end] = firstElement;
            }
        }

        static void Print<T>(T[] arr)
        {
            Console.WriteLine("(" + string.Join(", ", arr) + ")");
        }

        static void Swap<T>(ref T first, ref T second)
        {
            T oldFirst = first;
            first = second;
            second = oldFirst;
        }
    }
}
