using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04.TowerOfHanoi
{
    using System.ComponentModel.Design;

    class Program
    {
        static IEnumerable<int> range = Enumerable.Range(1, 3);
        static int stepsTaken = 0;

        static Stack<int> source = new Stack<int>();
        static Stack<int> destination = new Stack<int>();
        static Stack<int> spare = new Stack<int>();
        static void Main(string[] args)
        {
            int numberOfDisks = int.Parse(Console.ReadLine());
            source = new Stack<int>(Enumerable.Range(1, numberOfDisks).Reverse());
            PrintRods();
            MoveDisks(numberOfDisks, source, destination, spare);
        }

        private static void MoveDisks(int bottomDisk, Stack<int> sourceRod, Stack<int> destinationRod, Stack<int> spareRod)
        {
            if (bottomDisk == 1)
            {
                destinationRod.Push(sourceRod.Pop());
                Console.WriteLine("Step #{0}: Moved disk {1}.", ++stepsTaken, bottomDisk);
                PrintRods();
            }
            else
            {
                MoveDisks(bottomDisk - 1, sourceRod, spareRod, destinationRod);

                destinationRod.Push(sourceRod.Pop());
                Console.WriteLine("Step #{0}: Moved disk {1}.", ++stepsTaken, bottomDisk);
                PrintRods();

                MoveDisks(bottomDisk - 1, spareRod, destinationRod, sourceRod);
            }
        }

        private static void PrintRods()
        {
            Console.WriteLine("Source: {0}", string.Join(", ", source.Reverse()));
            Console.WriteLine("Destination: {0}", string.Join(", ", destination.Reverse()));
            Console.WriteLine("Spare: {0}", string.Join(", ", spare.Reverse()));
            Console.WriteLine();
        }
    }
}
