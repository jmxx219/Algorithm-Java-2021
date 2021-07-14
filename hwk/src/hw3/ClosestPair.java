package hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 가장 가까운 쌍 찾기

public class ClosestPair {
	public static void print(Point[] p) {
		for(int j=0; j < p.length; j++) 
			if(p[j]!= null) System.out.print("("+p[j].x+" "+p[j].y+")"+" ");
		System.out.println();
	}
	public static class Point{
		public int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		int getX() {
			return x;
		}
		int getY() {
			return y;
		}
	}
	public static double EuclideanDistance(Point p1, Point p2) { // 거리 구하기
		return Math.sqrt(Math.pow(p1.x-p2.x, 2)+Math.pow(p1.y-p2.y, 2));
	}
	public static double BruteForceDistance(Point[] px) { // 전수 조사
		double min = Double.MAX_VALUE;
		for(int i=0; i<px.length-1; i++) {
			for(int j=i+1; j<px.length; j++) {
				double d = EuclideanDistance(px[i], px[j]);
				if(min > d) min = d;
			}
		}
		return min;
	}	
	public static double closestSplitPair(Point[] px, Point[] py, double delta) {
		int medianX = px[px.length/2].x;
		ArrayList<Point> candidates = new ArrayList<>();
		for(var p: py) {
			if(p.getX()>medianX-delta && p.getX()<medianX+delta)
				candidates.add(p);
		}
		
		for(int i=0; i<candidates.size()-1; i++) {
			for(int j=i+1; j<candidates.size() && j<i+8; j++) {
				double tmp = EuclideanDistance(candidates.get(i),candidates.get(j));
				if(tmp < delta) delta = tmp;
			}
		}
		return delta;
	}
	public static double closestPair(Point[] px, Point[] py) {
		if(px.length<=3) return BruteForceDistance(px); // 3이하 일 때는 전수조사
		
		Point[] pxL = Arrays.copyOf(px, px.length/2);
		Point[] pxR = Arrays.copyOfRange(px, px.length/2, px.length);
		Point[] pyL = Arrays.copyOf(py, py.length/2);
		Point[] pyR = Arrays.copyOfRange(py, py.length/2, py.length);
		
		int mid = pxL.length-1;
	
		int L = 0;
		int R = 0;
		for(int i=0; i<py.length; i++) {
			if(L<pyL.length&&(py[i].x < px[mid].x || (py[i].x == px[mid].x && py[i].y <= px[mid].y)))
				pyL[L++] = py[i];
			else pyR[R++] = py[i];
		}
		
		double delta = Math.min(closestPair(pxL, pyL), closestPair(pxR, pyR));
		return closestSplitPair(px, py, delta);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int i=0; i < T; i++) {
			int N = in.nextInt();
			Point[] px = new Point[N];
			for(int j=0; j < N; j++) {
				int x = in.nextInt();
				int y = in.nextInt();
				px[j] = new Point(x, y);
			}
			Point[] py = px.clone();
			Arrays.sort(px, Comparator.comparing(Point::getX).thenComparing(Point::getY));
			Arrays.sort(py, Comparator.comparing(Point::getY).thenComparing(Point::getX));

			System.out.printf("%.2f\n", closestPair(px, py));
		}
	}
}