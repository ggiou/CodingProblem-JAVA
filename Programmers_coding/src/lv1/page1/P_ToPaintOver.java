package lv1.page1;

public class P_ToPaintOver {
	
	public static int solution(int n, int m, int[] section) {
		int answer = 0;
		int paintCount = 0; //페인트질 횟수 (처음 1회 칠함)
		
		int startP = 0; //페인트질 시작 위치
		int endP = 0; //페인트질 끝 위치 
		
		for(int i=0; i<section.length; i++) {
			if(endP<section[i]) { //페인트 칠이 필요한 구역에 페인트 칠이 되어있지 않을 때, 그 구역을 start 지점으로 지정하면됨 = 최소 횟수를 구해야하기 때문.. 
				startP = section[i];
				endP = startP+(m-1); //index는 0부터 시작이니 롤러 길이 m에 -1 해줘야함
				paintCount++; //페인트칠 한번 할때마다 count++
			}
		}		
		
		answer = paintCount;
		return answer;
	}

	public static void main(String[] args) {
		int n = 4;
		int m = 1;
		int[] section = {1, 2, 3, 4};
		int result = solution(n, m, section);
		System.out.println(result);
	}

}
//[덧칠하기] : 주어진 범위(n)안에 주어진 내부의 구간(section)을 모두 지나가는 최소 회수를 구하는 문제 
/* 
이 문제는 주어진 길이 n 미터의 벽에 section 배열에 있는 지점을 주어진 롤러로 (m) 모두 최소 한번씩 칠하게 할때, 
최소 페인트칠 횟수를 구하는 문제이다. 이 문제에 규칙이 존재하기에 이 부분에 집중하다보면, 간단한 문제를 어렵게 생각하게 된다.
여기서 중점은, section의 배열 내부의 숫자를 모두, 최소 한번씩은 지나가는 최소횟수! 를 구하는 것과
롤러를 통해 지나가는데, 이때 롤러는 연속된 m 칸 만큼 움직일 수 있다는 것이 포인트다.
이 부분을 인지하면 문제는 매우 쉬워진다. 

-> 우선 연속된 m칸 만큼 움직인다는 것을 중점을 두면, 롤러가 지나가는 첫 지점 + m 만큼은 무저건 지나갈 수 밖에 없게 된다.
   그렇게 되면, 만약 이 지나간 지점에 section 배열의 지점이 지나간다면 지나간거니 무시해도된다.
   그럼 롤러가 지나간 끝 부분보다 뒤에 있는 section부분의 지점만 지나가면 되는 것이다. 여기서 최소 한번만 지나가면 되고, 
   중복해서 지나갈 때에 대한 조건이 없으므로 단순히 section의 부분이 롤러의 지점보다 클 경우, 
   해당 부분을 start 부분으로 지정해주고, 이때마다 횟수를 +1 해주면 최소한의 횟수를 구할 수 있게된다. 
   (어처피 페인트칠 횟수만 구하는 것이며, 이미 지나간 부분을 지나가도 되니 start+m이 범위를 벗어나도, 신경쓸 필요 없음)
   
-> 즉 for문으로 section안을 모두 순회하면서 내부 숫자가 start와 end(start+m) 지점의 내부면 이미 칠해진거니
   무시하고, 외부라면 해당 지점을 start로 설정하며 횟수에 +1을 해주면 되는 간단한 문제이다.
   (주의 사항!) 나는 index를 기준으로 문제를 풀었기에 index는 0부터 시작이니 m에 -1을 해줘야 맞는 end 범위가 된다. 
*/
