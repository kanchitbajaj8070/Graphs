import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.util.ArrayList;
import java.util.HashMap;

public class ColoringOfGraph {

    public static void isMcolorable(int[][]graph,int m)
    {
int[]color= new int[graph.length];
boolean ans= isMcolorableHelper(graph,m,0,color);
if(ans==true)
{
    System.out.println("possible -->");
    for(int a:color)
        System.out.print(a+"    ");
    System.out.println();
}
else
    System.out.println("not possible");
    }

    public static boolean isMcolorableHelper(int [][] graph, int m , int v, int []color)
    {
       if(v==graph.length)
           return true;
        for (int c = 1; c <=m ; c++) {
            if(isSafe(graph,c,v,color))
            {
                color[v]=c;
                Boolean rr= isMcolorableHelper(graph,m,v+1,color);
                if(rr)
                            return true;
                else
                    color[v]=0;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] graph, int c, int v, int[] color) {

        for (int i = 0; i <graph.length ; i++) {
            if(graph[i][v]==1&&color[i]==c)
                return false;
        }
        return true;
    }

    public static int colorsRequiredToColor(AdjacencyList graph)
    {
        HashMap<AdjacencyList.Vertex,Integer> color= new HashMap<>();
        int c=0;
        ArrayList<AdjacencyList.Vertex> vertices= new ArrayList<>(graph.vertices);
        for(AdjacencyList.Vertex v : vertices)
        {
            if(c==0) {
                color.put(v, c++);
              continue;
            }for(AdjacencyList.Vertex u : v.neighbors)
            {
                if(color.get(u)!=null)
                {
                    int p=color.get(u);
                    if(p==c)
                        c++;
                }
                }
                color.put(v,c);

        }
        for(AdjacencyList.Vertex v1:vertices)
        {
            System.out.println(v1.name+" -> "+color.get(v1));
        }
        return c+1;
    }
}

