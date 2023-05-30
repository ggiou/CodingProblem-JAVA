package step.oneArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1546 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //과목의 수(테스트 케이스)
		int max = 0; //새 평균을 구하기 위한 최대 값 설정
		int [] arr = new int[n]; //시험본 과목들의 점수를 담을 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); //한줄에 시험점수 모두 들어오니 분리를 위해서..
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(max<arr[i]) max = arr[i];
		}//배열 값 담기 + 최고 점수 구하기
		
		double avg = 0; //새로운 평균
		for(double num:arr) {
			avg += num/max*100;
		} //기존 점수/최고 점수*100 -> 으로 변환해 모두 저장함
		
		System.out.println(avg/arr.length); //개수로 나눠, 평균 반환
		//1. 최고값 구해서 변환 후 평균 구해 출력 - 124ms
	}

}
// [평균] : n개의 점수 중 가장큰 점수 m을 구해 = 한 과목점수/m*100 으로 점수를 변환 후 평균을 구하는 문제
// -> 값을 변환하기 위한 max를 찾고 이를 통해 새로운 점수를 구하고 다 더한후, 과목수만큼 나눠주면 평균 반환됨
