namespace Sortable_Collection
{
    using System;
    using System.Collections.Generic;
    using System.Linq;

    using Sortable_Collection.Contracts;

    public class SortableCollection<T> where T : IComparable<T>
    {
        public SortableCollection()
        {
            this.Items = new List<T>();
        }

        public SortableCollection(IEnumerable<T> items)
        {
            this.Items = new List<T>(items);
        }

        public SortableCollection(params T[] items)
            : this(items.AsEnumerable())
        {
        }

        public List<T> Items { get; } = new List<T>();

        public int Count => this.Items.Count;

        public void Sort(ISorter<T> sorter)
        {
            sorter.Sort(this.Items);
        }

        public int BinarySearch(T item)
        {
            int startIndex = 0;
            int endIndex = this.Count - 1;

            int index = DoBinarySearch(item, startIndex, endIndex);
            return index;
        }

        private int DoBinarySearch(T item, int startIndex, int endIndex)
        {
            if (endIndex < startIndex)
            {
                return -1;
            }

            int midpoint = startIndex + (endIndex - startIndex) / 2;

            if (this.Items[midpoint].CompareTo(item) > 0)
            {
                return DoBinarySearch(item, startIndex, midpoint - 1);
            }
            if (this.Items[midpoint].CompareTo(item) < 0)
            {
                return DoBinarySearch(item, midpoint + 1, endIndex);
            }

            return midpoint;
        }

        public int InterpolationSearch(T item)
        {
            List<int> tempList = new List<int>(this.Count);
            int key = Convert.ToInt32(item);

            foreach (var element in this.Items)
            {
                tempList.Add(Convert.ToInt32(element));
            }

            int low = 0;
            int high = tempList.Count - 1;

            if (high < low)
            {
                return -1;
            }

            while (tempList[low] <= key && tempList[high] >= key)
            {
                int mid = low + ((key - tempList[low]) * (high - low)) / (tempList[high] - tempList[low]);

                if (tempList[mid] < key)
                {
                    low = mid + 1;
                }
                else if (tempList[mid] > key)
                {
                    high = mid - 1;
                }
                else
                {
                    return mid;
                }
            }
            if (tempList[low] == key)
            {
                return low;
            }
            return -1;
        }

        public void Shuffle()
        {
            throw new NotImplementedException();
        }

        public T[] ToArray()
        {
            return this.Items.ToArray();
        }

        public override string ToString()
        {
            return $"[{string.Join(", ", this.Items)}]";
        }
    }
}