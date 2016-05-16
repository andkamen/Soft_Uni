namespace Sortable_Collection
{
    using System;

    using Sortable_Collection.Sorters;

    public class SortableCollectionPlayground
    {
        private static Random Random = new Random();

        public static void Main(string[] args)
        {
            const int NumberOfElementsToSort = 22;
            const int MaxValue = 150;

            var array = new int[NumberOfElementsToSort];

            for (int i = 0; i < NumberOfElementsToSort; i++)
            {
                array[i] = Random.Next(MaxValue);
            }

            var collectionToSort = new SortableCollection<int>(array);
           // collectionToSort.Sort(new BucketSorter { Max = MaxValue });

           // Console.WriteLine(collectionToSort);
            //var collection = new SortableCollection<int>(3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48);
            var collection = new SortableCollection<int>(2, -1, 5, 0, -3);
           // var collection = new SortableCollection<int>();
            Console.WriteLine(collection);

            collection.Sort(new Quicksorter<int>());
            Console.WriteLine(collection);
            //Console.WriteLine(collection.InterpolationSearch(0));

        }
    }
}
