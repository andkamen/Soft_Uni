using System;
using System.Collections.Generic;
using System.Linq;

public class Tree<T>
{
    public T Value { get; set; }
    public Tree<T> Parent { get; set; }
    public IList<Tree<T>> Children { get; private set; }

    static Dictionary<int, Tree<int>> nodeByValue = new Dictionary<int, Tree<int>>(); 

    public Tree(T value, params Tree<T>[] children)
    {
        this.Value = value;
        this.Children = new List<Tree<T>>();

        foreach (var child in children)
        {
            this.Children.Add(child);
            child.Parent = this;
        }
    }

    public void Print(int indent = 0)
    {
        Console.Write(new string(' ', 2 * indent));
        Console.WriteLine(this.Value);
        foreach (var child in this.Children)
        {
            child.Print(indent + 1);
        }
    }

    public void Each(Action<T> action)
    {
        action(this.Value);

        foreach (var child in this.Children)
        {
            child.Each(action);
        }
    }

    public static Tree<int> GetTreeNodeByValue(int value)
    {
        if (!nodeByValue.ContainsKey(value))
        {
            nodeByValue[value]=new Tree<int>(value);
        }
        return nodeByValue[value];
    }

    public static Tree<int> FindRootNode()
    {
        var rootNode = nodeByValue.Values.FirstOrDefault(node => node.Parent == null);
        return rootNode;
    }

    public static IEnumerable<Tree<int>> FindMiddleNodes()
    {
        var middleNodes = nodeByValue.Values.Where(
            node => node.Children.Count > 0 &&
                    node.Parent != null).ToList();

        return middleNodes;
    }
}
