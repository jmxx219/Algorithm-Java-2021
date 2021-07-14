import java.util.List;
import java.util.Scanner;

// 해밀톤 회로

public class Hamiltonian {
	public static int N;
	public static boolean promising(boolean[][] G, int[] output, int index) {
		if(index == N-1 && G[output[index]][1]) return false;
		if(index < 0 && !G[output[index-1]][output[index]]) return false;
		return true;
	}
	public static void hamiltonian(boolean[][] G, List<Integer> set, int[] output, int index) {
		if(promising(G, output, index)) {
			if(index == N-1) {
				// output 출력
			}
			else {
				for(int j=2; j<=N; j++) {
					if(!set.contains(j)) {
						set.add(j);
						output[index+1] = j;
						hamiltonian(G, set, output, index+1);
						set.remove(j);
					}
				}
			}
		}
	}
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		int[][] G = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				G[i][j] = in.nextInt();
			}
		}
		// hamiltonian(G, set, output, index+1);
	}

}
