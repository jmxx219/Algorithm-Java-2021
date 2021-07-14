package graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

// �ִܰ��(���ͽ�Ʈ��) ���� - ���� ����Ʈ

public class ShortestPath_1753 { // ����ġ�� �ִ� �ִ� ���
   public static int N; // ������ ��
   public static int V; // ������ ��
   public static List<List<Point>> adj;
   public static int[] dist;
   public static final int init = 987654321;
   
   public static class Point implements Comparable<Point>{
	   public int node;
	   public int cost;
	   
	   Point(int node, int cost){
	      this.node = node;
	      this.cost = cost;
	   }
	   
	   @Override
	   //���Ŀ� �־ �տ� ���� ���� �� ������ �������� �ȴ�.
	   public int compareTo(Point o) {
	      return this.cost - o.cost;
	   }
	}
   
   public static void solve(int start) {
      PriorityQueue<Point> pq = new PriorityQueue<Point>();
      dist[start] = 0;
      pq.offer(new Point(start,0));
      
      while(!pq.isEmpty()){
         Point tmp = pq.poll();
         int cost = tmp.cost;
         int here = tmp.node;
         
         if(dist[here] < cost) continue;
         
         for(var next : adj.get(here)) {
            if(next.cost != 0) {
               int nextDist = next.cost + cost;
               if(nextDist < dist[next.node]) {
                  dist[next.node] = nextDist;
                  pq.offer(new Point(next.node, nextDist));
               }
            }
         }
      }
      for(int i = 1; i<=N; i++) {
          if(dist[i] == init) System.out.println("INF");
          else System.out.println(dist[i]);
       }
   }
   
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      V = sc.nextInt();
      int start = sc.nextInt();
      adj = new ArrayList<List<Point>>();
      for(int i=0; i<=N; i++) adj.add(new LinkedList<Point>());
      
      dist = new int[N+1];
      Arrays.fill(dist, init);
      
      for(int i=0; i<V; i++) {
         int a = sc.nextInt();
         int b = sc.nextInt();
         int c = sc.nextInt();
         adj.get(a).add(new Point(b,c));
      }
      solve(start);
   }
}