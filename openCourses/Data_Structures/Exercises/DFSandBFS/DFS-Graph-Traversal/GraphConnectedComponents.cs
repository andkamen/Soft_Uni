using System;
using System.Collections.Generic;
using System.Linq;

public class GraphConnectedComponents
{
    private static new List<int>[] graph = new List<int>[]
    {
        new List<int>() {3, 6},
        new List<int>() {3, 4, 5, 6},
        new List<int>() {8},
        new List<int>() {0, 1, 5},
        new List<int>() {1, 6},
        new List<int>() {1, 3},
        new List<int>() {0, 1, 4},
        new List<int>() {},
        new List<int>() {2},
    };

    private static bool[] visited;

    public static void Main()
    {
        visited = new bool[graph.Length];
        graph = ReadGraph();
        FindGraphConnectedComponents();

    }
    static void DFS(int node)
    {
        if (!visited[node])
        {
            visited[node] = true;

            foreach (var childNode in graph[node])
            {
                DFS(childNode);
            }
            Console.Write(" {0}", node);
        }
    }

    private static List<int>[] ReadGraph()
    {
        int nodeCount = int.Parse(Console.ReadLine());
        var graph = new List<int>[nodeCount];

        for (int i = 0; i < nodeCount; i++)
        {
            graph[i] = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).Select(int.Parse).ToList();
        }
        return graph;
    }

    private static void FindGraphConnectedComponents()
    {
        visited = new bool[graph.Length];
        for (int startNode = 0; startNode < graph.Length; startNode++)
        {
            if (!visited[startNode])
            {
                Console.Write("Connected component:");
                DFS(startNode);
                Console.WriteLine();
            }
        }
    }


}
