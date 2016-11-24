namespace _04.Trees
{
    using System;
    class Program
    {
        static void Main(string[] args)
        {
            int nodesCount = int.Parse(Console.ReadLine());

            for (int i = 0; i < nodesCount; i++)
            {
                string[] edge = Console.ReadLine().Split();
                int parentValue = int.Parse(edge[0]);
                Tree<int> parentNode = Tree<int>.GetTreeNodeByValue(parentValue);
                int childValue = int.Parse(edge[0]);
                Tree<int> childNode = Tree<int>.GetTreeNodeByValue(childValue);
                parentNode.Children.Add(childNode);
                childNode.Parent = parentNode;
            }

            int pathSum = int.Parse(Console.ReadLine());
            int subtreeSum = int.Parse(Console.ReadLine());

        }
    }
}
