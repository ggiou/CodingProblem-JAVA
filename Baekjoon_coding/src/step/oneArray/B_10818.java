package step.oneArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_10818 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//입력 방식 - 효율을 위해 사용  
		
		int n = Integer.parseInt(br.readLine()); //정수의 개수
		StringTokenizer st = new StringTokenizer(br.readLine()); //정수들 
		br.close();
		// 기본 입력된 내용
		
		
		//출력
		
		int max, min; //비교를 위한 기준 max, min 생성
		
		int[] arr = new int[n];	//배열 생성
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());//배열에 수 저장
		max = arr[0]; min = arr[0]; //임의로 max, min 설정 - (1), (2)에 사용
		for(int i=1; i<n; i++) {
			if(max<arr[i]) max = arr[i]; //max보다 배열의 현재 가르키는 값이 크다면 그 값이 max가 됨
			if(min>arr[i]) min = arr[i]; //작다면 그 값이 min이 됨
		}
			//(1) for문 사용	- 496ms
			
		/*for(int i=1; i<n; i++) {
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]); //Math 함수를 통해 위의 과정 해결..
		}*/
			//(2) Math 라이브러리 사용 - 512ms (메소드 호출시간이 있으니 더걸림..)
		
		/*max = Arrays.stream(arr).max().getAsInt();
		min = Arrays.stream(arr).min().getAsInt();*/
			//(3) Arrays.stream().max.getAsInt() 사용 - 564ms 코드는 짧지만 가장 오래 걸림..
			//삼항연산자도 가능하지만, 이는 패스..  max = arr[i] > max ? arr[i] : max 
		//1. 배열 + BufferReader + StringBuilder
		
		
		
		
		/*max = Integer.parseInt(st.nextToken());
		min = max;	//배열과 달리 바로 넘어오는 첫번째 값을 우선 max, min이라 설정 후 비교
		
		for(int i=1; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num>max) max = num;
			if(num<min) min = num;
		}*/
		//2. 바로 비교 + BufferWriter + BufferWriter - 512ms
		
		System.out.print(min+" "+ max); 
	}
}
//최소, 최대 - 입력받은 수들 중 가장 큰 값과 작은 값을 찾아 출력하는 문제
/*
  이 문제는 주어진 수 중에서 가장 큰 값과 작은 값을 찾아 출력하는 문제이다.
  여기서는 10871처럼 배열에 담아서 푸는 방법과 바로 비교해서 푸는 방법이 가능하다.
  
  ** 해결 과정
  *1. 배열을 이용한 과정
      : 배열에 담은 후, max와 min을 구해주면 된다.
      (1) for문 max, min 변수 -> 변수를 각각 만든 후 거기에 첫번째 값을 설정하고 다음으로 올 수가 작다면 min, 크다면 max..
      (2) Math 라이브러리의 max, min 함수 사용
      (3) Arrays.stream(배열).max.getAsInt() 사용 (배열안에서 큰값을 알아서 반환..)
      -> (1) 방법 외에 나머지는 모두 함수를 불러 조금 더 속도가 느려짐..
      
   2. 바로 비교하는 과정
     : 어처피 수의 개수와, 수들이 주어지니 바로 비교해도 무관
     (1) 역시 max, min 변수를 통해 비교
      
 
  - 입력방법 (입력이 많을 수록 더 버퍼리더가 효율적, 그렇다고 입력이 하나여도 버퍼리더가 좋긴 함..)
 	Scanner,  BufferedReader가 가능하나 buffer가 성능상 훨씬 좋으므로 코드에는 buffer만 사용
 
  - 출력방법
    출력이 간단해 더 효율적이고 쉬운 기본 출력을 사용했다.
    찾아 낸 max, min을 공백 기준으로 하는 것이니, 문자열의 반복출력/enter가 필요없으니
    오히려 bufferWriter, StringBuilder를 사용하면 그 함수를 불러내는게 더 시간이 걸린다.
    -> 실제로 같은 코드에 출력방식만 달리 했을때 
    bufferWriter는 512, StringBuilder 520, print 496으로 일반 출력이 젤 효율적이었다.

*/