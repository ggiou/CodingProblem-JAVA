package step.oneArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_10811 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //바구니 개수
		int t = Integer.parseInt(st.nextToken()); //테스트 케이스
		
		int arr[] = new int[n+1];
		for(int i=1; i<arr.length; i++) {
			arr[i] = i;
		} //바구니 번호 초기 세팅
	
		for(int k=0; k<t; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			/*
			int reverse[] = new int[j-(i-1)]; //역순을 담을 배열
			int idx = 0;
			for(int J=j; J>=i; J--) {
				reverse[idx++] = arr[J];
			} //해당 i~j 범위의 값을 역순으로 저장해서 세팅
			
			idx = 0;
			for(int I=i; I<=j; I++) {
				arr[I] = reverse[idx++];
			} //해당 i~j 범위에 역순으로 변경해둔 배열 값 집어넣어, 순서를 바꿔주기
			*/ //1. 새 배열에 역순을 저장하고, 기존 배열에 넣기 - 144ms
			
			while(i<j) { //앞뒤로 변경
				int temp = arr[i];
				arr[i++] = arr[j];
				arr[j--] = temp;
			}
			// 2. 앞뒤로 바로, 기존 배열 위치 변경해주기 - 140ms
			
		}
		br.close();
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<arr.length; i++) sb.append(arr[i]+" ");
		System.out.print(sb);
	}
	
}
// [바구니 뒤집기] - 주어진 횟수 만큼 반복해주서 주어지는 범위 i~j의 바구니들을 역순으로 재배치해서 출력하는 문제
// -> 문제 그대로, 바구니 개수만큼 1~N번 번호를 순서대로 세팅 후, 테스트 케이스만큼, 반복해서 입력받은 i~j번째를 서로 대칭에 맞게 값들을 교환해주면 됨
