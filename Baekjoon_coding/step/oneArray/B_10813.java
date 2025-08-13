package Baekjoon_coding.step.oneArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_10813 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //입력
		StringTokenizer st = new StringTokenizer(br.readLine());	//한 줄에 띄어쓰기 기준으로 2개 같이 입력되니, 분리 필요
		int n = Integer.parseInt(st.nextToken()); //배열 크기 = 바구니 개수
		int m = Integer.parseInt(st.nextToken()); //테스트 케이스
		int arr[] = new int[n]; //배열 생성
		int num = 1;
		for (int i=0; i<n; i++) arr[i] = num++; //배열 값 기본 설정 (1, 2, 3....)
		
		StringBuilder sb = new StringBuilder(); //출력
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int I = Integer.parseInt(st.nextToken())-1; //i번 바구니
			int J = Integer.parseInt(st.nextToken())-1; //j번 바구니
			int temp = arr[I]; //I번째 바구니의 값을 임의로 저장
			
			arr[I] = arr[J];
			arr[J] = temp; //서로의 공을 교환
		}
		
		for(int i=0; i<n; i++) sb.append(arr[i]).append(" ");
		System.out.println(sb);
		//1. 배열 + writer + builder - 120ms
		

	}

}
//공 바꾸기 - 배열에 초기 값 설정후, 입력받은 두 인덱스의 값만 변화하면되는 간단한 문제다.

/*
 이 문제는 단순히 초기 값 설정 후 입력받은 두 인덱스의 값들을 변경해주는 것 반복하는 문제다.
 여기서 미리 초기값이 (i번째 바구니의 값은 i) 정해져있으니 이와 같은 배열을 만들어 얘는
 바구니라 생각해 m번 만큼 반복해 들어오는 두 인덱스의 값을 서로 바꿔만 주면 되는 간단한문제다.
 
 + 수를 바꾸는 알고리즘은 쉽게, 첫 번째 수를 두번째 수로, 두번째 수를 첫번재수로 바꾸는 거다.
   여기서 1번, 첫번째 수를 두 번째 수로 변경하면 첫 번째 수가 사라지니 -> a = b; 기존 a의 값?
   이를 임의의 변수에 넣어 저장한후 이를 두 번째 수에 넣어주는 과정으로 푼다 -> temp = a; a= b; b = a;  
 
 ** 해결과정
    1. 배열의 크기 n, 테스트 케이스 m을 입력 받는다.
    2. 초기 값을 배열에 넣어준다. -> idx 0부터 시작
    3. m번만큼 반복해 변화할 두 인덱스를 입력받고 두 인덱스 값의 위치를 바꿔준다. 
   + 처음에 배열을 그냥 +1해서 0~n번까지 크기로 만들어 풀어도 된다..
   
 ** 주의사항
    : 바구니에 적혀있는 번호와 같은 공이 들어 있다고 주어졌는데 여기서 나는 그냥
      배열의 크기를 입력받은 수로 넣었으니 0부터 시작한다는 것을 인지에
      초기값을 설정할 때 1부터 0번째 인덱스에 넣어줘야한다.
      또한 배열의 인덱스가 0부터 시작하니 교환할 i, j번째 인덱스에 
      각각 -1을 해준 상태로 위치를 바꿔줘야 문제의 의도와 맞게 풀이된다.
           
 - 입력방법
	Scanner,  BufferedReader가 가능하나 buffer가 성능상 훨씬 좋으므로 코드에는 buffer만 사용

 - 출력방법
   좀 더 편하고 실행 시간도 단축되는 stringBuilder를 사용했다.

*/