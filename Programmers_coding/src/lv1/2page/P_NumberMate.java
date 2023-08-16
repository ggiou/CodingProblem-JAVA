package lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class P_NumberMate {
	public static String solution(String X, String Y) {
		String answer = "";
		Map<String, Integer> xMap = new HashMap<String, Integer>(); // X 문자열의 수의 개수를 담을 해시맵 <해당 수, 수 몇개 있는지>
		Map<String, Integer> yMap = new HashMap<String, Integer>(); // Y 문자열의 수의 개수를 담을 해시맵 <해당 수, 수 몇개 있는지>
		List<String> list = new ArrayList<String>();	// 공통수를 담을 리스트

		for (String num : X.split("")) {
			xMap.put(num, xMap.getOrDefault(num, 0) + 1);	// xMap에 해당 수가 존재한다면 현재 개수+1, 없다면 1로 존재하는 수들의 개수를 파악한다
		}
		for (String num : Y.split("")) {
			yMap.put(num, yMap.getOrDefault(num, 0) + 1);	// y문자열도 마찬가지로 존재하는 수들의 개수를 파악한다
		}

		Iterator<String> keys = xMap.keySet().iterator();	// 공통수를 찾기 위해 xMap의 key값들을 가져온다
		while (keys.hasNext()) {	// xMap을 기준으로 yMap과 비교
			String key = keys.next();
			if (yMap.getOrDefault(key, -1) != -1) {	// 만약 공통되는 수라면
				int cnt = Math.min(xMap.get(key), yMap.get(key));	// 둘 중 더 작은 횟수를 가져온다 (해당 수를 가지고 있는 횟수이니, 적은 수 가져와야함)
				while (cnt > 0) {
					list.add(key);	// 해당 수의 개수만큼 list에 더해준다
					cnt--;
				}
			}
		}

		if (list.size() <= 0) {	// 만약 공통 수가 없다면 
			return "-1";
		} else {
			Collections.sort(list, Collections.reverseOrder());	// 가장 큰 수를 구해야하니, 역순 정렬
			answer = list.toString().replaceAll("(\\[|\\]|,)| ", "");	// list를 toString할 경우 [,]가 포함되니 이를 변경
			if (answer.indexOf("0") == 0) {
				return "0";	// 첫번째 idx의 값이 0이라면 최대 숫자는 0
			}else {
				return answer;	// 그 외에는 그대로 반환
			}
		}

	}

	public static void main(String[] args) {
		String X = "12321";
		String Y = "42531";
		String result = solution(X, Y);
		System.out.println(result);
	}

}
//[숫자 짝꿍] : 주어진 두 문자열의 공통 숫자를 찾아 해당 숫자들로 최대값을 만드는 문제
/*
 초기 이 문제를 보고 X, Y 둘 중 길이가 작은 문자열을 기준으로 배열로 변경해 긴 문자열이 해당 idx의 문자를 가지고 있다면
 (indexOf로 -1이 아니라면) 기존의 첫번째 반환 문자를 (replaceFirst를 통해 한 문자만 빈문자로 변경..) 빈문자로 변경하고
 공통 문자는 새로운 리스트에 담는 과정을 반복해, 최종적으로 리스트의 문자들을 내림차순해, 문자로 변경하는 방식으로 문제를 풀려했다.
 문제는 풀렸지만 아무래도 조건 "3 ≤ X, Y의 길이(자릿수) ≤ 3,000,000입니다."를 신경쓰지 않은 탓에, 길이가 긴 문자의 경우 시간 초과 오류가 발생했다. 
 
 이 부분에 대해 생각하다가, 그럼 많이 길이를 비교하더라도, 일정한 방식이 뭐가 있을까 고민하다가 hashMap을 이용한 방법이 떠올랐다.
 
 1. 두 문자를 모두 hashMap에 key = 해당 문자, value = 문자의 횟수로 맞게 저장한 후 
 (map.put은 존재한다면 해당 key값의 value만 수정되고, 없음 새로 저장되는 걸 이용) 
 -> .getOrDefault를 통해 존재 하지 않을 경우, 1로 리셋시키고, 있을 경우 +1을 해서 각 문자의 보유 횟수를 map에 저장함
 
 2. map을 완성 후 두 문자열의 map중 xMap의 key 값들을 iterator을 사용해 모두 가져와 
 hasNext로 모둔 key 값을 yMap에 넣어 getOrDefault를 이용해 만약 default 가 아니라면,  
 즉 x, y모두 존재하는 공통 수니, 각 두 map의 value 중 작은 수만큼 반복해 list에 넣어준다. -> 공통 수니, 가지고 있는 개수가 작은 만큼만 공통으로 보유한 것임
 
 3. 위의 과정을 마치면 list에는 공통된 수들이 담겨 있을 텐데, 문제에서 요구하는 것은 공통수로 최대수를 만드는 것이니, 
 list의 sort(Collections.reverseOrder())를 통해 간단히 역순으로 정렬하면 가장 큰 수대로 반환된다.
 -> 여기서 만약 list의 size가 0보다 작거나 같다면, 공통수가 없으니 "-1"을 반환하고
 -> 그렇지 않다면, list를 문자열로 변경한 후 (변경시 list는 [,] 배열 형식 그대로 문자열로 반환되니 이는 replaceAll을 통해 숫자만 빼고 제거 해줘야함..)
 	만약 변경한 문자열의 첫번째 문자가 0 이라면, 내림차순으로 정렬했으니 0으로 이루어진 수이니 "0"을 반환하고
 	0이 아니라면 변경한 문자열을 반환해주며 시간 내에 test case를 모두 통과해 문제를 해결했다.
 */
