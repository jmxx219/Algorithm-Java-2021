import java.util.HashSet;
import java.util.Set;

public class TSP {
	public static final int INF = 987564321;
	/**
	 * ������ ��Ÿ���� ��Ʈ ǥ���� ���ڿ��� �ٲپ� ��
	 * 0��° ��Ʈ ��ġ�� 1�̸� �� i+1 ����
	 * @param mask ������ ��Ÿ���� ��Ʈ ǥ��
	 * @param N �ִ� ������ ũ��
	 * @return ������ ǥ���ϴ� ���ڿ�
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
	 * n������ r���� �����ϴ� ��� ������ ���� (��Ʈ�� ǥ��)
	 * @param n ��ü ���� ����
	 * @param r �����ϰ��� �ϴ� ���� ����
	 * @param index ���ݱ��� ������ ���� ����
	 * @param mask �ֱٿ� ������ ��
	 * @param i ������ ��Ʈ ��ġ
	 * @param set ���� ����� ������ ����
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
	// n������ r���� �����ϴ� ��� ����
	public static Set<Integer> getAllSubset(int n, int r){
		Set<Integer> set = new HashSet<Integer>((int)(n*1.3+1));
		getAllSubset(n, r, 0, 0, 0, set);
		return set;
	}
	public static void tsp(int[][] G) {
		final int N = G.length;
		final int S = (1<<(N-1))+1;
		int[][] D = new int[N][S];
		// ������ ��� �̸�
		for(int i=1; i<N; i++) {
			D[i][0] = G[i][0]; 
			System.out.printf("D[%d][%s]=%d%n", i+1, getSet(0, N-1), D[i][0]);
		}
		// �κ������� ũ��
		for(int s=1; s<=N-2; s++) {
			Set<Integer> set = getAllSubset(N-1, s);
			// s�� ũ���� ���� ���� 
			for(var mask: set) {
				for(int k=1; k<N; k++) {
					// ��� k�� ���Ե��� ���� ����
					if((mask & (1<<(k-1)))==0){
						D[k][mask] = INF;
						// ��� k���� ��� j�� ���� ���� + ��� j���� ��� 1�� ���� ��� (k, j�� �̿����� �ʴ�)
						for(int j=1; j<N; j++) {
							// ��� k ����
							if((mask >> (j-1) & 1) == 1) {
								int unmask = 0xFFFFFFFF ^ (1<<(j-1));
								// mask & unmask: j ����
								// System.out.printf("G[%d][%d]: %d + D[%d][%s]: %d%n", k+1, j+1, G[k][j], j+1, getSet(mask & unmask, N-1), D[j][mask & unmask]);
								D[k][mask] = Math.min(D[k][mask], G[k][j]+D[j][mask & unmask]);
							}
						}
						System.out.printf("D[%d][%s]=%d%n", k+1, getSet(mask, N-1), D[k][mask]);
					}
				}
			}
		}
		// V: ��� 1�� ������ ��� ����� ������ ��Ÿ���� mask
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
