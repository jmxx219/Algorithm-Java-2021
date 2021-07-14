package graph;
import java.util.LinkedList;
import java.util.Scanner;

// 트리의 부모 찾기

public class Parent_11725 {
   public static int N;
   public static LinkedList<Integer>[] adj;
   public static int[] parents;
   public static boolean[] visited;

   private static void dfs(int here) {
      visited[here] = true;
      
      for(var x : adj[here]) {
         if(!visited[x]) {
            parents[x] = here;
            dfs(x);
         }
      }
   }
   
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      visited = new boolean[N+1];
      parents = new int[N+1];
      adj = new LinkedList[N+1];
      for(int i=0; i<=N; i++) adj[i] = new LinkedList<Integer>();
      
      for(int i =0; i<N-1; i++) {
         int a = sc.nextInt();
         int b = sc.nextInt();
         adj[a].add(b);
         adj[b].add(a);
      }
      
      for(int i = 1; i<=N; i++) {
         if(!visited[i]) dfs(i);
      }
      
      for(int i=2; i<=N; i++) System.out.println(parents[i]);
   }
}



