
namespace _07.ImplementLinkedList
{
    using System;
    using System.Collections;
    using System.Collections.Generic;

    class CustomLinkedList<T> : IEnumerable<T>
    {
        private class ListNode<T>
        {
            public ListNode(T value)
            {
                this.Value = value;
            }

            public T Value { get; set; }

            public ListNode<T> NextNode { get; set; }
        }

        private ListNode<T> head;
        private ListNode<T> tail;

        public int Count { get; private set; }

        public void Add(T element)
        {
            if (this.Count == 0)
            {
                this.head = this.tail = new ListNode<T>(element);
            }
            else
            {
                var newTail = new ListNode<T>(element);
                //At Count 1 tail and head are same elemenet and this gives both the new value then moves tail
                // after that only tail gets moved further down
                this.tail.NextNode = newTail;
                this.tail = newTail;
            }

            this.Count++;
        }

        public T Remove(int index)
        {
            if (index < 0 || index >= this.Count)
            {
                throw new IndexOutOfRangeException("Invalid index.");
            }

            if (this.Count == 0)
            {
                throw new InvalidOperationException("Empty list.");
            }

            ListNode<T> currentNode = this.head;
            ListNode<T> previousNode = null;

            for (int i = 0; i < index; i++)
            {
                previousNode = currentNode;
                currentNode = currentNode.NextNode;
            }

            //in case first element is removed. Move head
            if (previousNode == null)
            {
                var element = this.head.Value;
                this.head = this.head.NextNode;
				this.Count--;
                return element;
            }
            //stop referencing desired element
            previousNode.NextNode = currentNode.NextNode;

            //in case tail was removed.
            if (index == this.Count - 1)
            {
                this.tail = previousNode;
            }

            this.Count--;
            return currentNode.Value;
        }

        public int FirstIndexOf(T item)
        {
            int index = -1;
            var currentNode = this.head;
            while (currentNode != null)
            {
                index++;
                if (currentNode.Value.Equals(item))
                {
                    return index;
                }
                currentNode = currentNode.NextNode;
            }
            return index;
        }

        public int LastIndexOf(T item)
        {
            int currentIndex = -1;
            int lastIndexAt = -1;
            var currentNode = this.head;
            while (currentNode != null)
            {
                currentIndex++;
                if (currentNode.Value.Equals(item))
                {
                    lastIndexAt = currentIndex;
                }
                currentNode = currentNode.NextNode;
            }
            return lastIndexAt;
        }


        public IEnumerator<T> GetEnumerator()
        {
            var currentNode = this.head;
            while (currentNode != null)
            {
                yield return currentNode.Value;
                currentNode = currentNode.NextNode;
            }
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return this.GetEnumerator();
        }
    }
}
