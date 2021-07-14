package brute_force;

// 보글 게임

import java.util.Scanner;

public class Boggle {
   public static final int Size = 5;
   public static char[][] board = new char[Size][Size];
   public static int[] dx = {-1,0,1,-1,1,-1,0,1};
   public static int[] dy = {-1,-1,-1,0,0,1,1,1};

   public static boolean inRange(int y, int x) {
	   return x >= 0 && x < Size && y >=0 && y < Size;
   }
   public static boolean hasWord(int y, int x, String word) {
	   if(!inRange(y,x)) return false; // 시작 위치가 범위 밖이면 실패
	   if(board[y][x] != word.charAt(0)) return false; // 첫 글자가 일치하지 않으면 실패
	   if(word.length() == 1) return true; // 단어 길이가 1이면 성공

	   for(int direction = 0; direction < 8; ++direction) {
		   int nextY = y + dy[direction];
		   int nextX = x + dx[direction];
		   if(hasWord(nextY,nextX, word.substring(1))) return true; // 인덱스 1부터 문자열 끝까지 자르기
	   }

	   return false;
   }
   public static boolean findFirstWord(String word) {
	   for(int y=0; y<Size; y++) {
		   for(int x=0; x<Size; x++) {
			  // if(hasWord(y,x, word))  return true;
			   if(board[y][x] == word.charAt(0)) {
				   if(hasWord(y,x, word))  return true;
			   }
		   }
	   }
	   return false;
   }
   public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   int T = sc.nextInt();
	   for(int k=0; k<T; k++) {
		   for(int i=0; i<Size; i++) {
			   String tmp = sc.next();
			   for(int j=0; j<Size; j++) board[i][j] = tmp.charAt(j);
		   }

		   int N = sc.nextInt();
		   String[] str = new String[N];
		   for(int i=0; i<str.length; i++) str[i] = sc.next();
		   
		   for(int i=0; i<str.length; i++) {
			   System.out.print(str[i] + " ");
			   if(findFirstWord(str[i])) System.out.println("YES");
			   else System.out.println("NO");
		   }
	   }
   }
}
