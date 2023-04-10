package step.oneArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_10810 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //입력 방법
		StringTokenizer st;	//한줄로 입력이 들어오니 분리를 위해 설정 

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //바구니 개수
		int m = Integer.parseInt(st.nextToken()); //테스트 케이스
		int[] arr = new int[n];	//바구니 배열
		
		StringBuilder sb = new StringBuilder(); //출력 방법
		
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int I = Integer.parseInt(st.nextToken())-1; //I번 바구니부터
			int J = Integer.parseInt(st.nextToken())-1; //J번 바구니까지
			int K = Integer.parseInt(st.nextToken()); //K번 번호의 공을 넣는다
			
			for(int l=I; l<=J; l++) {
				arr[l] = K;
			}
		}//공 넣는 과정
		
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb);		
		//결과 출력
		//1. BufferWriter + StringBuilder + 배열 - 128ms
		
	}
}
//공 넣기 - 입력받은 수를 반복해서 배열에 입력해주기 = a부터 b까지 인덱스의 배열값 수정하기

/*
 이 문제는 처음에 봤을때는 말로 서술되어있다보니 조금 어려울 수 있다고 생각했다.
 하지만 문제를 읽고 예시 입력과 출력으로 이해한대로 손으로 풀어보니 매운 쉬운 문제였다.
 단순히 해석하면 i부터 j까지에 k라는 수를 집어넣는것을 m번 반복해라 라는 간단한 배열 문제다.
 이 문제는 다양한 방법이 있겠지만 배열을 사용해 테스트 케이스 m번만큼 입력을 받고
 이를 반복해 입력받은 형태대로 배열의 값을 수정하는 것이 
 가장 쉽고 효율적이라 배열을 사용해 푸는 방식을 선택했다.
 
 ** 해결과정
    1. 크기 n, 테스트 케이스 m을 입력받고 배열을 생성하고 m번 반복할 for문을 생성한다.
    2. i, j, k를 입력받아 숫자로 변환해준다.
    3. 배열의 idx i부터 j까지의 값을 k로 변환해준다.
    -> 2, 3번의 과정이 m번 반복 
    4. 저장된 배열을 출력한다.
    
 ** 주의사항
    : 배열은 0부터 시작된다는 것을 인지해 i, j의 ~번째 바구니는 0부터 시작한다는 것을
      인지해야한다. 즉 처음부터 -1을 해서 받아주면 좀 더 편하다. 또한
      j까지 공을 채우니 = j도 포함되는 것을 주의해야 한다.
       
 - 입력방법
	Scanner,  BufferedReader가 가능하나 buffer가 성능상 훨씬 좋으므로 코드에는 buffer만 사용

 - 출력방법
    배열의 내용을 전체 출력해야하니, 즉 반복 출력이니 buffer, builder 중
    더 쉽고, 효율적인 StringBuilder를 통해 출력했다.
    
*/

