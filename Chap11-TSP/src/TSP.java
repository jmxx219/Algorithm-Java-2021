import java.util.HashSet;
import java.util.Set;

public class TSP {
	public static final int INF = 987564321;
	/**
	 * 집합을 나타내는 비트 표현을 문자열로 바꾸어 줌
	 * 0번째 비트 위치가 1이면 값 i+1 포함
	 * @param mask 집합을 나타내는 비트 표현
	 * @param N 최대 집합의 크기
	 * @return 집합을 표현하는 문자열
	 */
	public static String getSet(int mask, int N) {
		String ret = "{";
		for(int i=0; i<N; i++) {
			int node = 1<<i;
			if((node&mask)==node) {
				if(ret.endsWith("{")) ret += (i+2);
				else ret += ", "+(i+2);
			}

		}
		return ret+"}";
	}
	/**
	 * n개에서 r개를 선택하는 모든 조합을 생성 (비트로 표현)
	 * @param n 전체 수의 개수
	 * @param r 선택하고자 하는 수의 개수
	 * @param index 지금까지 선택한 수의 개수
	 * @param mask 최근에 선택한 수
	 * @param i 선택한 비트 위치
	 * @param set 최종 결과를 모으는 집합
	 */
	public static void getAllSubset(int n, int r, int index, int mask, int i, Set<Integer> set){
		if(index==r) {
			set.add(mask);
			return;
		}
		if(i>=n) return;
		getAllSubset(n, r, index+1, mask | (1 << i), i+1, set);
		getAllSubset(n, r, index, mask, i+1, set);

	}
	// n개에서 r개를 선택하는 모든 조합
	public static Set<Integer> getAllSubset(int n, int r){
		Set<Integer> set = new HashSet<Integer>((int)(n*1.3+1));
		getAllSubset(n, r, 0, 0, 0, set);
		return set;
	}
	public static void tsp(int[][] G) {
		final int N = G.length;
		final int S = (1<<(N-1))+1;
		int[][] D = new int[N][S];
		// 색인은 노드 이름
		for(int i=1; i<N; i++) {
			D[i][0] = G[i][0]; 
			System.out.printf("D[%d][%s]=%d%n", i+1, getSet(0, N-1), D[i][0]);
		}
		// 부분집합의 크기
		for(int s=1; s<=N-2; s++) {
			Set<Integer> set = getAllSubset(N-1, s);
			// s의 크기의 집합 생성 
			for(var mask: set) {
				for(int k=1; k<N; k++) {
					// 노드 k가 포함되지 않은 집합
					if((mask & (1<<(k-1)))==0){
						D[k][mask] = INF;
						// 노드 k에서 노드 j로 가는 간선 + 노드 j에서 노드 1로 가는 경로 (k, j를 이용하지 않는)
						for(int j=1; j<N; j++) {
							// 노드 k 제외
							if((mask >> (j-1) & 1) == 1) {
								int unmask = 0xFFFFFFFF ^ (1<<(j-1));
								// mask & unmask: j 제외
								// System.out.printf("G[%d][%d]: %d + D[%d][%s]: %d%n", k+1, j+1, G[k][j], j+1, getSet(mask & unmask, N-1), D[j][mask & unmask]);
								D[k][mask] = Math.min(D[k][mask], G[k][j]+D[j][mask & unmask]);
							}
						}
						System.out.printf("D[%d][%s]=%d%n", k+1, getSet(mask, N-1), D[k][mask]);
					}
				}
			}
		}
		// V: 노드 1을 제외한 모든 노드의 집합을 나타내는 mask
		int V = (1<<(N-1))-1;
		D[0][V] = INF;
		for(int k=1; k<N; k++) {
			int mask = V;
			int unmask = 0xFFFFFFFF ^ (1<<(k-1));
			D[0][V] = Math.min(D[0][V], G[0][k]+D[k][mask & unmask]);
		}
		System.out.printf("D[1][%s]=%d%n", getSet(V,N-1), D[0][V]);
	}
	public static void main(String[] args) {
		int[][] G = {
			{0,2,9,INF},
			{1,0,6,4},
			{INF,7,0,8},
			{6,3,INF,0}
		};
		tsp(G);
	}
}
