namespace _06.ImplementReversedList
{
    using System;
    using System.Collections;
    using System.Collections.Generic;


    public class ReversedList<T> : IEnumerable<T>
    {

        private const int defaultCapacity = 16;
        private T[] array;

        public ReversedList() : this(defaultCapacity)
        {
        }

        public ReversedList(int capacity)
        {
            this.array = new T[capacity];
            this.Count = 0;
        }

        public int Count { get; private set; }

        public int Capacity
        {
            get { return this.array.Length; }
        }



        public void Add(T element)
        {
            if (this.Count == this.Capacity)
            {
                T[] newArray = new T[this.Capacity * 2];
                Array.Copy(this.array, newArray, this.Count);
                this.array = newArray;
            }

            this.array[this.Count] = element;
            this.Count++;
        }

        public void Remove(int index)
        {
            if (index < 0 || index >= this.Count)
            {
                throw new IndexOutOfRangeException("Invalid index.");
            }

            int tempIndex = this.Count - index - 1;
            T[] newArray = new T[this.Capacity];

            Array.Copy(this.array, newArray, tempIndex);
            Array.Copy(this.array, tempIndex + 1, newArray, tempIndex, index);

            this.Count--;
            this.array = newArray;
        }

        public T this[int index]
        {
            get
            {
                if (index < 0 || index >= this.Count)
                {
                    throw new IndexOutOfRangeException("Invalid index.");
                }

                return this.array[this.Count - index - 1];
            }

            set
            {
                if (index < 0 || index >= this.Count)
                {
                    throw new IndexOutOfRangeException("Invalid index.");
                }

                this.array[this.Count - index - 1] = value;

            }
        }

        public IEnumerator<T> GetEnumerator()
        {
            for (int i = this.Count - 1; i >= 0; i--)
            {
                yield return this.array[i];
            }
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return this.GetEnumerator();
        }
    }
}