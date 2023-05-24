package step.oneArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class B_5597 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] group = new int[31];
		for(int i=1; i<=28; i++) {
			int stu = Integer.parseInt(br.readLine());
			group[stu] = 1; //입력안받은 사람은 int 배열의 초기값 0으로 설정됨
		} //30명 미리 세팅
		
		for(int i=1; i<=30; i++) {
			if(group[i]==0) System.out.println(i); //안 불린 사람 출력
		}
		//1. bufferReader + syso + arr = 136ms
	}

}
