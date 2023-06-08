package step.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class B_5622 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> dial = Arrays.asList("ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ", "0");
		//각 인덱스 값으로 최소 시간을 구하기 위해, 각 숫자칸의 문자에대해 리스트에 저장해둠 -> 배열리스트 전환 = arrays.asList
		String[] word = br.readLine().split(""); //단어 하나당 처음으로 돌아가야하니, ""을 기준으로 분리
		int time = 0;
		for(int i=0; i<word.length; i++) {
			int t = 0;
			for(int j=0; j<dial.size(); j++) {
				if(dial.get(j).contains(word[i])) {
					t=j+3; break; 
					//총 2칸을 뛰고 1로 시작되고 2부터 알파벳이 포함되니 2를 부르는덴 총 3의 소요시간이 걸림 
					//-> 숫자를 하나 누르면 다시 처음으로 돌아가니, idx+3이 그 문자의 다디얼을 불러오는데 걸리는 소요 시간
				}
			}
			time += t;
		}
		System.out.println(time);
		//1. buffer = 124ms
	}
}
//[다이얼] : 입력받은 문자를 규칙에 맞게 숫자를 더해 출력하는 문제 (다이얼 문자마다 걸리는 시간이 다름, 총 소요시간 출력)
//우선 다이얼의 문자를 리스트에 담은 후, 입력받은 문자열의 문자를 각각 리스트에서 포함되있는지 확인해 그 포함된 리스트의 인덱스+3이 소요시간이니, 이 소요시간을 모두 더하면서 문제를 풀었다.

