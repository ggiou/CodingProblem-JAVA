package step.oneArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2562 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//입력 방식 - 효율을 위해 사용  
		
		StringBuilder sb = new StringBuilder();
		//출력 방식 - 젤 효율이 빠른거 하나 채택.. 
		
		int max = 0;	//자연수니 최대 값은 0이상이니, 0으로 설정후 비교하면됨..
		int num = 0;	//몇번째 수인지 
		//기본 설정
		
		int[] arr = new int[9]; //9개의 수가 들어오니 배열 생성
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());	//한줄에 하나씩 들어옴
		}
		for(int i=0; i<9; i++) {
			if(max<arr[i]) {
				max = arr[i];
				num = i+1;	//인덱스는 0부터시작이니.. +1해줘야함
			}
		}
		
		sb.append(max).append("\n").append(num);
		System.out.print(sb);
	}
	//1. bufferWriter + arr + Stringbuilder -> 124ms

}
//최댓값 -> 입력받은 수들중 가장 큰 수를 찾고 몇 번째 위치한 수인지 구하는 문제
/* 
  이 문제는 배열로 받아 수를 저장후 최대값을 찾는 방법과, 들어올때 바로 찾는 방법이 있다.
  ** 해결 과정
  *+ 그 전 단계에서 max찾는 방식, 비교하는거 다양하게 해봐서 이 코드에선 가장 효율좋은것만 적었다.
     1. 배열
        : 10871번 문제와 비슷하게 풀어주면 된다.
        (1) 크기가 9인 배열에 입력받은 수를 저장한다.
        (2) 배열의 첫번째 값을 max라 임의지정해 하나씩 비교하며 max값을 찾는다
        (3) 한번 더 배열을 돌며 max로 지정된 값이 몇번째 값인지 찾는다.
     2. 바로 비교
        : 어처피 수가 9개로 지정되어있으니 바로 비교해도 무관하다.
        (1) 첫번쨰 들어온 값을 max로 지정한다.
        (2) 현재 몇번째 수인지 확인할 num과 max가 몇번째인지 표시할 maxIdx를 지정한다.
        (3) 들어오는 수를 비교하며 max와 maxIdx를 갱신해준다.
            -> max의 값이 바뀔경우 maxIdx를 num으로 변경해주면 됨
            
   ** 주의사항     
      : max가 몇번째 수인지도 같이 적어줘야하는데 여기서 배열의
        idx는 0부터 시작하니 처음에 꼭 +1을 해줘야 하는 것을 주의해야한다.
        -> 첫번째 수가 max인데 첫번째 배열의 idx를 받아오면 1이 아닌 0  
          
   - 입력방법 (입력이 많을 수록 더 버퍼리더가 효율적, 그렇다고 입력이 하나여도 버퍼리더가 좋긴 함..)
 	 Scanner,  BufferedReader가 가능하나 buffer가 성능상 훨씬 좋으므로 코드에는 buffer만 사용
  
   - 출력방법
     출력이 반복되야 하니 stringBuilder로 문자열을 만들어 한번에 출력하든, BufferWriter로
     버퍼에 문자열을 넣어두면서 작성하다가 한번에 flush로 출력하는 방식이 일반출력보다 훨 효율적이다. 
     하지만 사용하기 쉬운 stringBuilder을 통해 여기서는 최대한 효율을 증가 시켰다.
 */
