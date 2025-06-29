import java.util.*;

public class Graphs {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s , int d , int w){
            this.src =  s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        graph[3].add(new Edge(3,1,1));
        //graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,2,1));
        //graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        graph[6].add(new Edge(6,5,1));

        for(int i = 0 ; i < graph[2].size(); i++){
            Edge e = graph[2].get(i);
            System.out.println(e.dest);
        }
    }

    public static void bfs(ArrayList<Edge>[] graph){ //O(E+V) using Adjacency List
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];
        q.add(0);
        
        while (!q.isEmpty()) {
            int curr = q.remove();

            if(!visited[curr]){
                System.out.print(curr+" ");
                visited[curr] =true;
                for(int i = 0; i < graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    public static void dfs(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(!visited[i]){
                dfsUtil(graph, i, visited);
            }
        }
    } // Connected Components : to traverse the non connected graph too
    public static void dfsUtil(ArrayList<Edge>[] graph, int curr , boolean[] visited ){
        System.out.print(curr+" ");
        visited[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                dfsUtil(graph, e.dest, visited);
            }
        }
    }
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph , boolean[] visited , int curr , int parent){
        visited[curr] = true;
        for(int i = 0; i < graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            if(visited[e.dest] && e.dest != parent){
                return true;
            }else if (!visited[e.dest]){
                detectCycleUtil(graph, visited, e.dest, curr);
            }
        }
        return false;
    }
    public static boolean detectCycle(ArrayList<Edge>[] graph){
        int g = graph.length;
        boolean visited[] = new boolean[g];
        for(int i  = 0 ;  i  < g ; i++){
            if(!visited[i]){
                if(detectCycleUtil(graph,visited,i,-1)){
                    return true;
                }
            }
        }
        return false;
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
            System.out.print(curr+" ");
            visited[curr] = true;

            for(int i = 0; i < graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                if(!visited[e.dest]){
                    helper(graph, e.dest, visited);
                }
            }
        }
    public static void main(String args[]){
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        //createGraph(graph);
        int[][] isConnected = {
    {1, 1, 0},
    {0, 1, 0},
    {1, 0, 1}
};
        FindCircleNum(isConnected);
        //bfs(graph);
        // dfsUtil(graph,0,new boolean[graph.length]);
        //System.out.println(detectCycle(graph));
    }
}
