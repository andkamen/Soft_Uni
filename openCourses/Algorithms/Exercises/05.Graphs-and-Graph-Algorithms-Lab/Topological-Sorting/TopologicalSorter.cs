using System;
using System.Collections.Generic;

public class TopologicalSorter
{
    private Dictionary<string, List<string>> graph;

    public TopologicalSorter(Dictionary<string, List<string>> graph)
    {
        this.graph = graph;
    }

    public ICollection<string> TopSort()
    {
        // TODO: Implement the topological sorting algorithm
        throw new NotImplementedException();
    }
}
