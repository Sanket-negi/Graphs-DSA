import java.util.ArrayList;

public class NumberOfProvinces {
    // By Converting @-D array to adjacent list i.e. list<Edge>[] graph
    // TC - O(n*n) , SC - O(n*n)
    /* static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s , int d , int w){
            this.src =  s;
            this.dest = d;
            this.wt = w;
        }
    }
    public static void FindCircleNum(int[][] isConnected){
        int n = isConnected.length;
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j  < isConnected[0].length ; j++){
                if(isConnected[i][j]==1 && i!=j){
                    graph[i].add(new Edge(i, j, 1));
                    graph[j].add(new Edge(j, i, 1));
                }
            }
        }
        int count = 0 ;
        boolean[] visited = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(!visited[i]){
                count++;
                helper(graph, i, visited);
            }
        }
        System.out.println(count);
    } 
    public static void helper(ArrayList<Edge>[] graph, int curr , boolean[] visited ){
    //     visited[curr] = true;
    //     for(int i = 0; i < graph[curr].size(); i++){
    //         Edge e = graph[curr].get(i);
    //         if(!visited[e.dest]){
    //             helper(graph, e.dest, visited);
    //         }
    //     }
    // }
    */ 
    
    
    // Method 2 : Directly using the input array
    public static void FindCircleNum(int[][] isConnected){
        int n = isConnected.length;
        boolean [] vis = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                count +=1 ;
                helper(isConnected,i,vis);
            }
        }
        System.out.println(count);  
    }
    public static void helper(int [][] isConnected , int i , boolean[] vis){
        vis[i] = true;
        for(int j = 0 ; j < isConnected[0].length ; j++){
            if(isConnected[i][j] == 1 && !vis[j]){
                helper(isConnected, j, vis);
            }
        }
    }
    public static void main(String[] args) {
        int[][] isConnected = {{1, 0, 0},{0, 1, 0},{0, 0, 1}};
        FindCircleNum(isConnected);
    }
}
