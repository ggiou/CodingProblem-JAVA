package level.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B_1946 {
	static class Grade implements Comparable<Grade> { //성적 클래스 선언
		int interview; // 면접 점수
		int document; // 서류 점수

		public Grade(int interview, int document) {
			this.interview = interview;
			this.document = document;
		}

		@Override
		public int compareTo(Grade o) {
			return this.interview - o.interview; // 빠른 속력을 위해 미리 interview 순으로 정렬
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // 효율성을 위해 stringBuilder 사용

		int tc = Integer.parseInt(br.readLine()); // 테스트 케이스

		for (int i = 0; i < tc; i++) { //테스트 케이스 만큼 반복
			int N = Integer.parseInt(br.readLine()); // 성적의 개수
			List<Grade> gradeList = new ArrayList<Grade>(); // 성적을 담을 리스트
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int interview = Integer.parseInt(st.nextToken());
				int document = Integer.parseInt(st.nextToken());
				gradeList.add(new Grade(interview, document));
			}

			Collections.sort(gradeList); // 면접등수를 기준으로 정렬

			int cnt = 1; // 1등은 포함
			int documentGrade = gradeList.get(0).document; //1등의 서류 등수
			for (int k = 1; k < gradeList.size(); k++) {
				if (documentGrade > gradeList.get(k).document) { //두 조건중 하나는 더 높아야하니, 전 등수의 인터뷰등수보다, 서류등수로는 높아야함 
					documentGrade = gradeList.get(k).document; //바로 전 등수보다 서류등수가 높아야하니, 높을경우에는 높은 등수를 저장
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb.toString());
		//1. Buffer + StringBuilder = 1596ms
	}

}
//[신입 사원] : 주어진 두 점수를 비교해, 둘중 하나라도 낮지 않은 경우를 모두 찾아 그 개수를 반환하는 문제
/* 이 문제를 처음보고 하나를 기준으로 정렬한 다음에 비교해야 문제의 제한사항에서 입력이 큰걸 보고 시간초과가 걸리지 않겠다 생각이 들었다.
   이를 인식하고 정렬해 확인하니 예제의 답과 맞지 않아 문제를 다시 신중히 읽어보니, 
   입력으로 들어오는 2가지 수가, 인터뷰와 서류의 등수였고 만약 둘다 등수가 낮은 경우에는 뽑지 않는 것이였다. (나는 등수 대신 점수로 봐서 ㅋㅋ 숫자가 커야 뽑히는 건줄 ㅠㅠ)
   
   이를 이해하고 나서는 비교적 쉽게 생각이 들었다. 만약 이중 for문이나 하나씩 일일히 비교한다면 이미 입력으로 들어올수 있는 수가 
   크므로 시간초과가 뜰거를 인식해 어떻게 해야 두가지 등수에 대해 하나라도 다른 사람의 등수에 비해 커야한다는 조건을 빠르게 만족시킬수 있을까 생각했다.
   그 결과 두가지 등수 중 한가지를 오름차순으로 정렬하고, 만약 자신보다 높은 인터뷰 등수를 가진 사람의 면접 등수보다 높다면 위 조건이 만족되겠단 생각이들었다.
   또한 만약 더 높다면 어처피 그다음에 비교될 애들은 한가지는 이미 낮으니, 높은 등수가 계속해서 조건이 만족될때 갱신되어야된다 생각이 들었다.
   
   이를 통해 총 4가지의 과정을 통해 문제를 해결할 수 있었다.
   1. test case 만큼 반복하며 첫번째로 등수의 개수 (N =지원자의 수)를 입력받고
      입력받은 N 만큼 반복하며 들어오는 등수를 만들어둔 Grade라는 class의 리스트에 차곡차곡 저장해 둔다.
   2. 해당 사람 별 등수가 들어있는 리스트를 인터뷰를 기준으로 오름차순 정렬한다. (한가지가 이미 높은순으로 가면 문서등수를 보고 무저건 전 문서등수보다 더 높아야 가능)
   3. 정렬된 리스트를 바탕으로 for문을 돌며 현재 문서 등수가 전의 문서등수보다 높을 경우 합격되니 합격 사람수를 ++ 해준다. 
   (더 높다면, 그 다음 비교할 등수는 이미 한가지가 낮으니, 무저건 전 등수보다 높아야해 비교할 높은 문서등수도 갱신해줘야함)
   4. 최종적으로 나온 tc별 cnt(합격자수)를 출력해주면 문제를 해결할 수 있다.
 */
 