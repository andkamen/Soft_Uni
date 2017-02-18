using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2.CalculateSequenceWithQueue
{
    class Program
    {
        static void Main(string[] args)
        {
            int startingNum = int.Parse(Console.ReadLine());

            Queue<int> sequence = new Queue<int>();
            List<int> result = new List<int>();
            sequence.Enqueue(startingNum);

            while (result.Count < 50)
            {
                int currentNum = sequence.Dequeue();
                result.Add(currentNum);

                sequence.Enqueue(currentNum + 1);
                sequence.Enqueue(2 * currentNum + 1);
                sequence.Enqueue(currentNum + 2);
            }

            Console.WriteLine(string.Join(" ,", result));
        }
    }
}
