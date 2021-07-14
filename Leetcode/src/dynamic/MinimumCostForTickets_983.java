package dynamic;

import java.util.Arrays;
//days.length : [1,365]
//days[i] : [1,365]
//costs[i] : [1,1000]
public class MinimumCostForTickets_983 {
	public static int maxDay;
	public static int N;
	public static int[] memo;
	public static boolean[] checked;

	//day일 때의 최적값
	public static int solve(int day, int[] days, int[] costs) {
		if(day > maxDay) return 0;
		if(memo[day] != -1) return memo[day];

		memo[day] = 0;

		if(checked[day]) return memo[day] = Math.min(solve(day+1, days, costs) + costs[0], Math.min(solve(day+7, days, costs) + costs[1], solve(day+30, days, costs) + costs[2]));
		else return memo[day] = solve(day+1, days, costs);
	}

	public static int mincostTickets(int[] days, int[] costs) {
		N = days.length;
		maxDay = days[N-1];
		memo = new int[maxDay+1];
		checked = new boolean[maxDay+1];

		for(int i=0; i<days.length; i++) checked[days[i]] = true;

		Arrays.fill(memo, -1);
		return solve(1, days, costs);
	}
	public static void main(String[] args) {
		int[] days = {1,4,6,7,8,20};
		int[] costs = {2,7,15};
		System.out.println(mincostTickets(days, costs));
	}
}