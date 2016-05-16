namespace Sortable_Collection.Sorters
{
    using System;
    using System.Collections.Generic;
    using Sortable_Collection.Contracts;

    public class MergeSorter<T> : ISorter<T> where T : IComparable<T>
    {
        public void Sort(List<T> collection)
        {
            var length = collection.Count;
            if (length <= 1)
            {
                return;
            }
            var middle = collection.Count / 2;

            var left = collection.GetRange(0, middle);
            var right = collection.GetRange(middle, collection.Count - middle);

            // Console.WriteLine($"left: {string.Join(", ", left)}");
            // Console.WriteLine($"right: {string.Join(", ", right)}");

            this.Sort(left);
            this.Sort(right);

            var tempList = Merge(left, right);
            for (int i = 0; i < tempList.Count; i++)
            {
                collection[i] = tempList[i];
            }
            //Console.WriteLine($"merged: {string.Join(", ", collection)}");
        }

        private static List<T> Merge(List<T> left, List<T> right)
        {
            var mergedList = new List<T>(left.Count + right.Count);

            int leftIndex = 0;
            int rightIndex = 0;
            
            while (leftIndex < left.Count && rightIndex < right.Count)
            {
                if (left[leftIndex].CompareTo(right[rightIndex]) < 0)
                {
                    mergedList.Add(left[leftIndex++]);
                }
                else
                {
                    mergedList.Add(right[rightIndex++]);
                }
            }
            while (leftIndex < left.Count)
            {
                mergedList.Add(left[leftIndex++]);
            }

            while (rightIndex < right.Count)
            {
                mergedList.Add(right[rightIndex++]);
            }

            return mergedList;
        }
    }
}
