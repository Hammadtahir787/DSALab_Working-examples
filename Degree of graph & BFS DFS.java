import java.util.*;

class Graph {
    private final Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    // Add an edge to the graph
    public void addEdge(int source, int destination, boolean isDirected) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.get(source).add(destination);

        if (!isDirected) {
            adjacencyList.putIfAbsent(destination, new ArrayList<>());
            adjacencyList.get(destination).add(source);
        }
    }

    // Task 1: Calculate degree of each node for an undirected graph
    public Map<Integer, Integer> calculateDegrees() {
        Map<Integer, Integer> degreeMap = new HashMap<>();

        for (int node : adjacencyList.keySet()) {
            degreeMap.put(node, adjacencyList.get(node).size());
        }

        return degreeMap;
    }

    // Task 2a: Perform Breadth-First Traversal for Directed Graph
    public List<Integer> breadthFirstTraversal(int startNode) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);

            for (int neighbor : adjacencyList.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return result;
    }

    // Task 2b: Perform Depth-First Traversal for Directed Graph
    public List<Integer> depthFirstTraversal(int startNode) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(startNode);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (!visited.contains(current)) {
                visited.add(current);
                result.add(current);

                for (int neighbor : adjacencyList.getOrDefault(current, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        // Add edges for an undirected graph
        graph.addEdge(1, 2, false);
        graph.addEdge(1, 3, false);
        graph.addEdge(2, 4, false);
        graph.addEdge(3, 4, false);
        graph.addEdge(4, 5, false);

        // Calculate degrees for the undirected graph
        System.out.println("Degree of each node:");
        Map<Integer, Integer> degrees = graph.calculateDegrees();
        for (Map.Entry<Integer, Integer> entry : degrees.entrySet()) {
            System.out.println("Node " + entry.getKey() + ": " + entry.getValue());
        }

        // Create a directed graph for traversals
        Graph directedGraph = new Graph();
        directedGraph.addEdge(1, 2, true);
        directedGraph.addEdge(1, 3, true);
        directedGraph.addEdge(2, 4, true);
        directedGraph.addEdge(3, 4, true);
        directedGraph.addEdge(4, 5, true);

        // Perform Breadth-First Traversal
        System.out.println("\nBreadth-First Traversal starting from node 1:");
        System.out.println(directedGraph.breadthFirstTraversal(1));

        // Perform Depth-First Traversal
        System.out.println("\nDepth-First Traversal starting from node 1:");
        System.out.println(directedGraph.depthFirstTraversal(1));
    }
}
