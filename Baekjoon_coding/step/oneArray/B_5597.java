package Baekjoon_coding.step.oneArray;

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
// [과제 안 내신 분..?] : 전체 30명 학생 중 불리지 않은 2명의 출석번호를 구하는 문제
//  -> 28개의 입력이 들어오니 int 배열은 초기값 0을 이용해, 값이 들어올 경우 1로 체크해 0인 경우만 출력해주면 되는 간단한 문제 