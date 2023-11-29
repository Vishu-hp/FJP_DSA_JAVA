import java.io.*;
import java.util.*;

class Main {
    public static class Edge{
        int src, nbr, wt;

        Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int des, boolean[] vis){
        if(src == des){
            return true;
        }

        vis[src] = true;

        for(Edge edge: graph[src]){
            if(vis[edge.nbr] == false){
                boolean faith = hasPath(graph, edge.nbr, des, vis);

                if(faith){
                    return true;
                }
            }
        }

        return false;
    }

    public static void printAllPaths(ArrayList<Edge>[] graph, int src, int des, boolean[] vis, String psf){
        if(src == des){
            System.out.println(psf);
            return;
        }

        vis[src] = true;

        for(Edge e: graph[src]){
            if(vis[e.nbr] == false){
                printAllPaths(graph, e.nbr, des, vis, psf+e.nbr);
            }
        }

        vis[src] = false;
    }

    public static void dfs(ArrayList<Edge>[] graph, int vtx, boolean[] vis, ArrayList<Integer> comp){
        vis[vtx] = true;
        comp.add(vtx);

        for(Edge e: graph[vtx]){
            if(vis[e.nbr] == false){
                dfs(graph, e.nbr, vis, comp);
            }
        } 
    }

    public static ArrayList<ArrayList<Integer>> getConnectedComp(ArrayList<Edge>[] graph){
        int vtces = graph.length;
        boolean[] vis = new boolean[vtces];
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

        for(int vtx=0; vtx<vtces; vtx++){
            if(vis[vtx] == false){
                ArrayList<Integer>comp = new ArrayList<>();
                dfs(graph, vtx, vis, comp);
                comps.add(comp);
            }
        }

        return comps;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int vtces = scn.nextInt();

        ArrayList<Edge>[] graph = new ArrayList[vtces];

        // Initialization
        for(int i=0; i<vtces; i++){
            graph[i] = new ArrayList<>();
        }

        int ndedges = scn.nextInt();

        for(int i=0; i<ndedges; i++){
            int v1 = scn.nextInt(), v2 = scn.nextInt(), wt = scn.nextInt();

            graph[v1].add(new Edge(v1, v2, wt)); 
            graph[v2].add(new Edge(v2, v1, wt)); 
        }


        // Print graph
        /* for(ArrayList<Edge> edges: graph){
            for(Edge edge: edges){
                System.out.println(edge.src + "->" + edge.nbr + "@" + edge.wt);
            }
        } */

        // Has Path
        /* int src = scn.nextInt(), des = scn.nextInt();
        boolean[] vis = new boolean[vtces];
        System.out.println(hasPath(graph, src, des, vis)); */

        // Print All Paths
        /* int src = scn.nextInt(), des = scn.nextInt();
        boolean[] vis = new boolean[vtces];
        printAllPaths(graph, src, des, vis, ""+src); */

        // Get Components 
        /* ArrayList<ArrayList<Integer>> comps = getConnectedComp(graph);
        for(ArrayList<Integer> comp: comps){
            for(Integer vtx: comp){
                System.out.print(vtx);
            }
            System.out.println();
        } */


        // Is Graph Connected
        /* ArrayList<ArrayList<Integer>> comps = getConnectedComp(graph);
       if(comps.size() == 1){
           System.out.println("Graph is connected");
       }
       else{
            System.out.println("Graph is not connected");
       } */

    }
}
