namespace _07.ImplementLinkedList
{
    using System;

    public class LinkedListMain
    {
        static void Main(string[] args)
        {
            var list = new CustomLinkedList<int>();
            for (int i = 0; i < 10; i++)
            {
                list.Add(i);
            }
            list.Add(3);

            Console.WriteLine(string.Join(" ", list));

            int removedElement = list.Remove(0);
            Console.WriteLine(removedElement);
            Console.WriteLine(string.Join(" ", list));

            Console.WriteLine(list.FirstIndexOf(3));
            Console.WriteLine(list.LastIndexOf(3));

        }
    }
}