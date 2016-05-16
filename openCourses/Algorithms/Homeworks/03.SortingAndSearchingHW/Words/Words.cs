using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Words
{
    class Words
    {
        private static int wordCount = 0;
        static void Main()
        {
            var arr = Console.ReadLine().ToCharArray();

            Array.Sort(arr);
            PermuteRep(arr, 0, arr.Length - 1);

            Console.WriteLine(wordCount);
        }

        static void PermuteRep(char[] arr, int start, int end)
        {
            //Print(arr);
            if (VerifyWord(arr))
            {
                wordCount++;
            }

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

        private static bool VerifyWord(char[] arr)
        {
            for (int i = 1; i < arr.Length; i++)
            {
                if (arr[i] == arr[i - 1])
                {
                    return false;
                }
            }
            return true;
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
