namespace _3.ImplementArrayStack
{
    using System;

    class ArrayStackMain
    {
        static void Main(string[] args)
        {
            var myStack = new ArrayStack<int>();

            for (int i = 0; i < 20; i++)
            {
                myStack.Push(i);
            }

            Console.WriteLine(string.Join(" ", myStack.ToArray()));

            int removed = myStack.Pop();
            Console.WriteLine(removed);
            Console.WriteLine(string.Join(" ", myStack.ToArray()));
        }
    }
}
