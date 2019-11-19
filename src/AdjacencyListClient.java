public class AdjacencyListClient {
    public static void main(String[] args) {
     /*   AdjacencyList graph= new AdjacencyList();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        for(AdjacencyList.Vertex c:graph.vertices)
        System.out.println(c.name);
        graph.addEdge('A','B',true);
        graph.addEdge('A','C',true);
        graph.addEdge('A','D',true);
        graph.addEdge('C','D',true);
        graph.addVertex('E');

      graph.addEdge('E','B',true);
//graph.IterativeBFS('A');
//graph.iterativeDFS('A');
//graph.dfs('A');
        *//*
 A--B--E
 |\
 | \
 C--D
  *//*

               *//*
 A--B--E   F--G
 |\          /
 | \        /
 C--D       H


  *//*
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addVertex('H');
        graph.addEdge('F','G',true);
    graph.addEdge('G','H',true);
      //  System.out.println(graph.connectedComponents('A'));
        graph.makeAdjacencyMatrix();*/
    AdjacencyList graph2= new AdjacencyList();
        graph2.addVertex('A');
        graph2.addVertex('B');
        graph2.addVertex('C');
        graph2.addVertex('D');
        graph2.addVertex('E');
        graph2.addVertex('F');
        graph2.addVertex('G');
        graph2.addEdge('A','B',false);
        graph2.addEdge('B','C',false);
        graph2.addEdge('C','D',false);
        graph2.addEdge('E','D',false);
        graph2.addEdge('G','F',false);
        graph2.addEdge('F','E',false);
        graph2.addEdge('A','G',false);
        graph2.addEdge('B','G',false);
        graph2.addEdge('B','F',false);
        graph2.addEdge('B','E',false);
   // graph2.topologicalSort();

    graph2.kahnAlgorithm();}

}
