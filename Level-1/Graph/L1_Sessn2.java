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

    public static class Pair{
        int vtx;
        String psf;
        
        Pair(int vtx, String psf){
            this.vtx = vtx;
            this.psf = psf;
        }
    }   
    
    public static void bfs(ArrayList<Edge>[] graph, int src){
        Queue<Pair>q = new ArrayDeque<>();
        boolean[] vis = new boolean[graph.length];
        
        q.add(new Pair(src, "" + src));
        
        while(q.size() > 0){
            Pair rem = q.remove();
            
            if(vis[rem.vtx]){
                continue;
            }
            
            vis[rem.vtx] = true;
            
            System.out.println(rem.vtx + "@" + rem.psf);
            
            for(Edge e: graph[rem.vtx]){
                if(vis[e.nbr] == false){
                    q.add(new Pair(e.nbr, rem.psf + e.nbr));
                } 
            }
        }
    }
    
     public static int numberOfIslands(int arr[][]){
      int count = 0;
      for(int r = 0 ; r < arr.length ; r++){
         for(int c = 0 ; c < arr[0].length ; c++){
            if(arr[r][c] == 0){ // univisted land
               floodFill(arr,r,c); // mark all connected land area
               count++;
            }
         }
      }
      return count;
   }
   // 0 : unvisited land area , 1 : water , 2 : visited land area
   public static void floodFill(int arr[][],int r,int c){
      arr[r][c] = 2;
      if(r-1 >= 0 && arr[r-1][c] == 0) floodFill(arr,r-1,c);// top
      if(c-1 >= 0 && arr[r][c-1] == 0) floodFill(arr,r,c-1);// left
      if(r+1 < arr.length && arr[r+1][c] == 0) floodFill(arr,r+1,c);// down 
      if(c+1 < arr[0].length && arr[r][c+1] == 0) floodFill(arr,r,c+1);// right
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

        // bfs(graph, 1);
        
        
        
        /*
        7
        8
        0 3 3
        0 1 10
        1 2 1
        2 3 2
        3 4 4
        4 5 5
        5 6 6
        4 6 6
        */
      

    }
}
