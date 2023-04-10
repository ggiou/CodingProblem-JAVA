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

}
