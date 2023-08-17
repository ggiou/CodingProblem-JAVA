package lv1;

import java.util.Arrays;

public class P_DesktopCleanup {

	public static int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int minX = wallpaper.length; int maxX = 0; 
        int minY = wallpaper[0].length(); int maxY = 0;
       for(int i=0; i<wallpaper.length; i++) {
    	   if(wallpaper[i].indexOf("#")!=-1) { //파일이 있다면
    		   if(i<minX) {
    			   minX = i;
    		   } // S점 x 좌표 찾기   		   
    		   if(i>maxX) {
    			   maxX = i;
    		   } // E점 x 좌표 찾기
    		   
    		   int minfileY = wallpaper[i].indexOf("#"); //처음 만나는 파일의index 반환 (minY)
    		   int maxfileY = wallpaper[i].lastIndexOf("#"); //해당 문자열이 존재하는 마지막 index 반환(maxY)
    		   if( minfileY < minY) {
    			   minY = minfileY;
    		   } // S점 y 좌표 찾기
    		   if( maxfileY > maxY) {
    			 // E점 y 좌표 찾기  
    			   maxY = maxfileY;
    		   }
    	   }
       }
       
       answer[0] = minX; answer[1] = minY; // S점 위치 (가장 왼쪽 상단 지점)
       answer[2] = ++maxX; answer[3] = ++maxY; // E점 위치 (가장 오른쪽 하단 지점) - 드래그 해야하는 지점이 오른쪽 밑 꼭지점이니 +1 씩 해줘야함.
        
        return answer;
    }
	
	public static void main(String[] args) {
		String[] wallpaper = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
		int[] answer = solution(wallpaper);
		System.out.println(Arrays.toString(answer));

	}

}
//[바탕화면 정리] : 주어진 문자열 들을 모두 포함할 수 있는 정사각형 만들기 (#을 포함한 가장 왼쪽 상단 좌표와 가장 오른쪽 하단 좌표 구하기 )
/* 
이 문제는 처음에 문제를 보면 복잡해 보일 수 있지만, 천천히 읽어보면 간단히 풀 수 있는 문제였다.
이 문제에서는 정리해야하는 파일의 위치를 나타내는 wallpaper 문자열 배열이 존재한다.
요구하는 것은 바탕화면의 파일(#)을 모두 선택할 수 있는 가장 작은 사각형을 만들기 위해 
드래그 해야할 점 S(시작 점)와 E(끝 점)의 좌표를 구하는 것이다.

-> 처음에는 복잡하게 생각했지만, 모든 파일 삭제를 위해 드래그할때(점 S[사각형의 왼쪽 상단 꼭지점]부터 점 E[사각형의 오른쪽 하단 꼭지점]까지 ) 파일 모두를 선택해야한 다는 조건에
   집중해 생각힌 생각보다 간단히 해결법이 떠올랐다.
   모든 파일 선택 = 가장 왼쪽 상단에 위치한 파일의 좌표(S) 와 가장 오른쪽 하단에 위치한 파일의 좌표 (E)를 구하면 되는 문제였다.
   이를 생각해, 임의로 minX, minY = S를 가장 가질 수 있는 큰 값(wallpaper.length, wallpaper[0].length())으로 지정해 "#" 파일이 존재하는 좌표 중 minX, minY보다 작다면, 더 왼쪽 상단에 위치한 것이니 이 지점을 min 좌표로 지정해주고
   임의로 maxX, maxY = E를 가장 가질 수 있는 작은 값(0,0)으로 지정해 "#" 파일이 존재하는 좌표 중 maxX, maxY 보다 크면, 더 오른쪽 하단에 위치한다는 것이니 재지정해
   파일이 존재하는 중 가장 모서리에 존재하는 좌표를 구해 해결했다.
   ++ 여기서 실수할 수 있는 포인트는, 각 E의 좌표는 가장 오른쪽 하단에 존재하는 파일도 포함되도록, 드래그 되야하니 x, y좌표에 +1 씩해줘야 하는 점을 주의해 문제를 풀어야한다.

-> 후에 생각을 바꿔,(이동길이안에 장애물이 있으면 명령 취소!) 어처피 한칸씩 이동하며, 이동한 좌표에 장애물(X)의
 여부를 확인해야하고, 범위도 2가지 조건모두 확인해야 한다는 점에 집중하고
 1칸 씩 이동하게되면, 동,서,남,북 어처피 방향별로 이동하는 명령어의 위치 변화는 같으니
 static으로 방향별 이동 위치를 지정해, 보기 쉽고 간편하게 이동되는 것을 표현하게 했다.
*/ 
