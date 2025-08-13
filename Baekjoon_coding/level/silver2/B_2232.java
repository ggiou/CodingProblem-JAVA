package Baekjoon_coding.level.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B_2232 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); //효율성을 위해 stringBuilder 사용

		int N = Integer.parseInt(br.readLine()); // 지뢰의 개수
		int[] minePower = new int[N]; // 각 지뢰의 힘이 담긴 배열

		for (int i = 0; i < N; i++) { // 입력받은 지뢰의 힘을 담는 과정
			minePower[i] = Integer.parseInt(br.readLine());
		}

		int mpLength = minePower.length; // 지뢰의 개수
		if (mpLength == 1) { // 만약 지뢰가 1개 밖에 없다면
			sb.append(1).append("\n");
		} else {
			for (int i = 0; i < mpLength; i++) { // 그외는 지뢰의 개수만큼 힘을 모두 비교하며 터뜨릴 지뢰를 판단 필요
				int now = minePower[i]; // 현재 지뢰의 힘
				if (i == 0) { // 맨 앞에를 비교해야할 경우
					if (now >= minePower[i + 1]) { // 맨 앞의 지뢰의 경우, 뒤의 지뢰만 비교해 현재 힘이 더크나 같으면 해당 인덱스를 추가해주면 됨
						sb.append(i+1).append("\n");
					}
					continue;
				} else if (i == mpLength - 1) { // 맨 뒤를 비교해야 할 경우
					if (now >= minePower[i - 1]) { // 맨 뒤의 지뢰의 경우, 앞의 지뢰만 비교해 현재 힘이 더크거나 같으면 해당 인덱스를 추가해주면 됨
						sb.append(i+1).append("\n");
						continue;
					}
				} else { // 그외라면
					if (now >= minePower[i - 1] && now >= minePower[i + 1]) { // 앞과 뒤의 지뢰의 힘을 비교해 현재 힘이 더 크거나 같아야 인덱스를
						sb.append(i+1).append("\n");
					}

				}
			}
		}

		System.out.println(sb.toString());
		br.close();
		// 1. Buffer + StringBuilder = 244ms
	}
}
// [지뢰] - 주어진 조건에 맞는 지뢰들의 index를 구해 반환하는 문제 
/* 이 문제는 지뢰의 특성에 통해 최소한의 횟수로 모든 지뢰를 터트리기 위해서 필요한 지뢰들의 index를 반환하는 문제이다.
   여기서 각 지뢰는 자신이 가진 힘이 존재하고, 만약 한 지뢰의 힘이 앞, 뒤로 연결된 힘들보다 크다면 앞뒤 지뢰는 연쇄작용으로 폭발한다.
   + 동일한 힘의 지뢰는 터지지 않는다!
   예를 들면) 1 3 5 5 2 -> 이렇게 지뢰가 존재한다면, 앞위로 힘이 큰 5번을 터트리면
          (1 3 5) 5 2 -> () 부분이 연쇄작용으로 터지게 되고 남은 것중 힘이 큰 5번을 터트리면
 		         (5 2) -> () 부분이 연쇄 폭발해 모두 폭발하게 되므로
 		   정답은 5, 5의 위치인 {3, 4}를 출력해주면 된다.
 		   
   이런 지뢰의 조건에 대해 생각하면, 동일한 힘의 지뢰는 터지지 않는다에 집중하면 = 연속한 동일한 지뢰의 힘은 모두 터져야한다! 는걸 알 수 있다.
   이를 생각하면, 만약 한 지뢰가 있을때,  before <= now >= after 처럼 현재 지뢰의 힘이 이전과 이후 지뢰보다 크거나 같다면 무저건 터져야하는 것을 알 수 있다.
   
   이를 통해 결론적으로 3가지 단계를 거쳐 문제를 해결할 수 있다.
   1. 전체 지뢰를 서로 비교하며 탐색하기 위해 입력받는 지뢰의 힘들을 minePower 라는 배열에 넣어준다. (기본 세팅)
   2. 그 후 minePower을 전체를 탐색하며, 터져야하는 지뢰를 찾는 과정을 반복해야한다.
      여기서 이전에 말했던 지뢰가 터지는 조건에 대해 생각해보면 크게 4가지로 나눠서 비교할 수 있게된다.
      (1) minePower의 길이가 1일 경우 = 무저건 터져야하니, 단순히 1을 반환한다.
      (2) 현재 비교해야할 지뢰의 위치가 맨 앞일 경우 = 뒤를 비교할 수 없으니, 단순히 바로 앞과 비교해 크거나 같다면 터뜨려야한다. 
      (3) 현재 비교해야할 지뢰의 위치가 맨 뒤인 경우 = 앞과 비교할 수 없으니, 단순히 바로 뒤와 비교해 크거나 같다면 터뜨려야한다.
      (4) 그 외의 경우 최소의 횟수를 위해, 연쇄작용을 만드는 힘을 터뜨려야하니, 현 지뢰의 힘의 앞의 힘과 뒤의 힘을 모두 비교해 현재 힘이 앞과 뒤에 크거나 같을 경우 터뜨려야한다.
      이 조건에 맞게 전체 지뢰의 힘의 리스트를 탐색하면서, 해당 조건에 충족할경우 터뜨려야하니
      해당 지뢰의 (index+1)=(위치이니, 인덱스는 0부터 시작해 +1 해줌)을 정답을 담을 stringBuilder에 넣어준다.
  3. 정답을 출력한다 이 과정을 통해 문제를 해결할 수 있다.
*/
 