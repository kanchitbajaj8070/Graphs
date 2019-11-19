import java.beans.Visibility;
import java.util.*;

public class AdjacencyList {
    public class Vertex {
        char name;
        LinkedList<Vertex> neighbors;
        int indegree;

        public int getIndegree()
        {
            return indegree;
        }
        Vertex(char name) {
            this.name = name;
            neighbors = new LinkedList<>();
            indegree=0;
        }
    }

    public ArrayList<Vertex> vertices = new ArrayList<>();

    public void addVertex(char name) {
        vertices.add(new Vertex(name));
    }

    private Vertex get(char value) {
        for (Vertex vertex : vertices) {
            if (vertex.name == (value)) {
                return vertex;
            }
        }

        return null;
    }

    public void addEdge(char v1, char v2, boolean isBidirectional) {
        try {
            Vertex s = null;
            s = get(v1);
            Vertex e = null;
            e = get(v2);
            if (isBidirectional) {
                e.neighbors.add(s);
                s.indegree+=1;
            }s.neighbors.add(e);
            e.indegree+=1;
        } catch (Exception e) {
            System.out.println("wrong name of edges");
        }
    }

    public void IterativeBFS(char start) {
        Vertex s = get(start);
        HashSet<Vertex> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            Vertex v = queue.remove();
            System.out.print(v.name + "  -->  ");
            for (Vertex u : v.neighbors) {
                if (!visited.contains(u)) {
                    queue.add(u);
                    visited.add(u);
                }
            }

        }
        System.out.println("\n -------------------------");

    }

    public void iterativeDFS(char start) {
        Vertex v = get(start);
        Stack<Vertex> stack = new Stack();
        HashSet<Vertex> visited = new HashSet<>();
        stack.add(v);
        visited.add(v);
        while (!stack.isEmpty()) {
            Vertex vertex = stack.pop();
            System.out.print(vertex.name + "  -->  ");
            for (Vertex u : vertex.neighbors) {
                if (!visited.contains(u)) {
                    stack.add(u);
                    visited.add(u);
                }
            }

        }

        System.out.println("\n=================\n");
    }

    public void dfs(char name) {
        HashSet<Vertex> hs = new HashSet<>();
        recursiedfs(get(name), hs);
    }

    public void recursiedfs(Vertex start, HashSet<Vertex> visited) {
        if (start == null)
            return;
        System.out.print(start.name + " -->  ");
        visited.add(start);
        for (Vertex vertex : start.neighbors) {
            if (!visited.contains(vertex)) {
                recursiedfs(vertex, visited);
            }
        }
    }

    public int connectedComponents(char start) {
        Vertex s = get(start);
        int c = 0;
        HashSet<Vertex> visited = new HashSet<>();
        for (Vertex v : vertices) {
            if (!visited.contains(v)) {
                c=c+1;
                System.out.println("\n"+c+ " th connected component ");
                recursiedfs(v, visited);

            }
        }
        return c;
    }
    public void topologicalSortUtil(Vertex v,HashSet<Vertex> visited,Stack<Vertex> stack)
    {   visited.add(v);
        for(Vertex u: v.neighbors)
        {
            if(!visited.contains(u))
            {
                topologicalSortUtil(u,visited,stack);
            }
        }
        stack.add(v);
    }
   public void topologicalSort()
   {
       HashSet<Vertex> visited= new HashSet<>();
       Stack<Vertex> stack= new Stack<>();
       for (Vertex vertex:vertices)
           if(!visited.contains(vertex))
           topologicalSortUtil(vertex,visited,stack);
    while (!stack.isEmpty())
    {
        System.out.print(stack.pop().name+" ");
    }
        System.out.println();
    }



    public int[][] array;
    public void makeAdjacencyMatrix()
    {   ArrayList<Character> graphvertices= new ArrayList<>();
        int n=vertices.size();
        for(Vertex v: vertices)
            graphvertices.add(v.name);
        Collections.sort(graphvertices);
        array= new int[n][n];
        for (int i = 0; i < n; i++) {
            Vertex v= get(graphvertices.get(i));
                for (Vertex u : v.neighbors) {
                            int index=graphvertices.indexOf(u.name);
                        array[i][index]=1;
                }

            }
            printAdjacencyMatrix(array,n);
        }
    public void printAdjacencyMatrix(int[][]a,int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.print(a[i][j]+"  ");
            }
            System.out.println();
        }
    }


public void kahnAlgorithm( ) {
    HashSet<Vertex> visited = new HashSet<>();
    int n = vertices.size();
    ArrayList<Vertex> verticesList = new ArrayList<>(vertices);
    verticesList.sort(Comparator.comparing(Vertex::getIndegree));
    System.out.println();
    Queue<Vertex> queue = new LinkedList<>();
    for (Vertex v : verticesList) {
        if (v.indegree == 0) {
            queue.add(v);
            visited.add(v);
        }
    }
    int counter = 0;
    while (counter <= n) {
        counter++;
        Vertex v = queue.peek();
        if (v != null) {
            System.out.print(v.name + "   ");
            queue.remove();
            for (Vertex v1 : v.neighbors) {
                v1.indegree = v1.indegree-1;
                if (v1.indegree == 0 && !visited.contains(v1)) {
                    queue.add(v1);
                    visited.add(v1);
                }
            }
        }

    }
}
public void printlist(ArrayList<Vertex> verticeslist)
{
    for(Vertex c: verticeslist)
        System.out.println("    "+c.name+" "+c.indegree);
    System.out.println();
}
}

