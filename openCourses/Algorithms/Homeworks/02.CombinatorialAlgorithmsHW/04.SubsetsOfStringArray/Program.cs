using System;
using System.Linq;

class CombinationsGeneratorNoReps
{
    static int k = 2;
    static int n = 3;
    private static string[] objects;
    static int[] arr = new int[k];

    static void Main()
    {
        objects = Console.ReadLine().Replace("}","").Substring(5).Split(new char[] {',',' '},StringSplitOptions.RemoveEmptyEntries );
        k = Int32.Parse(Console.ReadLine().Substring(4));
        GenerateCombinationsNoRepetitions(0, 0);
    }

    static void GenerateCombinationsNoRepetitions(int index, int start)
    {
        if (index >= k)
        {
            PrintCombinations();
        }
        else
        {
            for (int i = start; i < n; i++)
            {
                arr[index] = i;
                GenerateCombinationsNoRepetitions(index + 1, i + 1);
            }
        }
    }

    static void PrintCombinations()
    {
        Console.WriteLine("({0}) --> ({1})",
            string.Join(", ", arr),
            string.Join(", ", arr.Select(i => objects[i])));
    }
}
