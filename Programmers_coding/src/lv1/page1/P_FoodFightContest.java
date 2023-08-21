package lv1.page1;

public class P_FoodFightContest {
	
	public static String solution(int[] food) {
        String answer = "";
		StringBuilder foodList = new StringBuilder();
        
        for(int i=1; i<food.length; i++) {
        	int iFoodNum = food[i];		//i번째 음식의 양
        	for(int j=0; j<iFoodNum/2; j++) {	//i번째 음식을 2명이서 먹어야하니, /2한만큼 반복해서 넣기
        		foodList.append(i);
        	}
        }
        answer = foodList.toString() + "0" + foodList.reverse().toString();	//중간에 0을 기준으로 앞뒤 대칭으로 문자열을 만들어준 후 반환해야 함
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] food = {1, 7, 1, 2};
		String result = solution(food);
		System.out.println(result);
	}

}
//[푸드 파이터 대회] : 주어진 숫자 배열을 정해진 규칙에 맞게 배치해 문자열로 반환하는 문제
/* 
이 문제는 주어진 숫자 배열을 규칙에 맞게 배치에 문자로 변환해 제공하는 문제이다.
여기서 주어진 food라는 숫자배열은 각 idx 번호에 해당되는 숫자가 food[i] 개만큼 존재하고, 
이걸 두명이서 똑같이 먹을 수 있도록 앞뒤로 붙여서 문자열을 만드는거다.
이 문제에서 까다로울 수 있는 부분은 앞뒤로 대칭으로 붙여야하는건데, 이건 stringBuffer or Builder의
.reverse() 함수를 사용하면 쉽게 뒤집을 수 있어, for문으로 2를 나눈만큼 반복해서 i번째 문자를 
붙여주고 최종적으로 0 을 가운데 둔채로 만들어진 문자열 버퍼와 그걸 reverse한 걸 문자에 붙여 반환하면 되는 간단한 문제다.
*/
//[문법] .reverse() : 문자열을 대칭으로 뒤집에주는 함수 (String Buffer or Builder에서 사용 가능)