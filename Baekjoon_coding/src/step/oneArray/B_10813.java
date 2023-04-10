package step.oneArray;

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
		int arr[] = new int[n+1]; //배열 생성 (0부터 시작하니 1을 더해 생성)
		for (int i=1; i<=n; i++) arr[i] = i; //배열 값 기본 설정 (1, 2, 3....)
		
		StringBuilder sb = new StringBuilder(); //출력
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int I = Integer.parseInt(st.nextToken()); //i번 바구니
			int J = Integer.parseInt(st.nextToken()); //j번 바구니
			int temp = arr[I]; //I번째 바구니의 값을 임의로 저장
			
			arr[I] = arr[J];
			arr[J] = temp; //서로의 공을 교환
		}
		
		for(int i=0; i<n; i++) sb.append(arr[i]).append(" ");
		System.out.println(sb);
		//1. 배열 + writer + builder - 120ms
		

	}

}
