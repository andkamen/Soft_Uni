namespace _3.ImplementArrayStack
{
    using System;

    public class ArrayStack<T>
    {
        private T[] elements;
        private const int InitialCapacity = 16;

        public ArrayStack(int capacity = InitialCapacity)
        {
            this.elements = new T[capacity];
            this.Count = 0;
        }

        public int Count { get; set; }

        public void Push(T element)
        {
            if (this.Count == this.elements.Length)
            {
                this.Grow();
            }
            this.elements[this.Count] = element;
            this.Count++;

        }

        public T Pop()
        {
            if (this.Count == 0)
            {
                throw new InvalidOperationException("Stack is empty");
            }

            T element = this.elements[this.Count - 1];
            this.Count--;
            return element;
        }

        public T[] ToArray()
        {
            T[] outputArr = new T[2 * this.elements.Length];
            Array.Copy(this.elements, outputArr, this.Count);

            return outputArr;
        }

        private void Grow()
        {
            T[] newArr = new T[2 * this.elements.Length];
            Array.Copy(this.elements, newArr, this.Count);
            this.elements = newArr;
        }
    }
}