using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Needles
{
    class Needles
    {
        static void Main(string[] args)
        {
            int[] inputSize = Console.ReadLine().Split().Select(int.Parse).ToArray();

            List<int> collection = Console.ReadLine().Split().Select(int.Parse).ToList();

            List<int> numbersToInsert = Console.ReadLine().Split().Select(int.Parse).ToList();

            Dictionary<int, int> numberPosition = new Dictionary<int, int>();

            int[] numberArray = new int[inputSize[1]];

            for (int i = 0; i < numbersToInsert.Count; i++)
            {
                numberPosition[numbersToInsert[i]] = 0;
                numberArray[i] = numbersToInsert[i];
            }

            numbersToInsert.Sort();
            numbersToInsert = numbersToInsert.Distinct().ToList();

            for (int num = 0; num < numbersToInsert.Count; num++)
            {
                for (int index = 0; index < collection.Count; index++)
                {
                    if (numbersToInsert[num] <= collection[index] && collection[index] != 0)
                    {
                        var insertIndex = FindIndex(index, collection);

                        numberPosition[numbersToInsert[num]] = insertIndex;
                        break;
                    }

                    if (index == collection.Count - 1)
                    {
                        var insertIndex = FindIndex(collection.Count, collection);

                        numberPosition[numbersToInsert[num]] = insertIndex;
                    }

                }
            }

            StringBuilder output = new StringBuilder();
            foreach (int needle in numberArray)
            {
                output.AppendFormat("{0} ", numberPosition[needle]);
            }

            Console.WriteLine(output.ToString().TrimEnd());
        }

        private static int FindIndex(int index, List<int> collection)
        {
            while (index > 0 && collection[index - 1] == 0)
            {
                index--;
            }
            return index;
        }
    }
}
