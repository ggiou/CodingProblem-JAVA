package Programmers_coding.lv1.page1;

public class P_SmallSubstring {

	public static int solution(String t, String p) {
        int answer = 0;
        int pLength = p.length();
        Long pLong = Long.parseLong(p);
        
        for(int i=0; i<t.length()-pLength+1; i++) {
        	Long tLong = Long.parseLong(t.substring(i, i+pLength));	//p의 길이만큼 자른 t의 부문문자열 가져오기 (index = 0, 1, 2, ...이런식으로 한칸씩밀리며 자르게)
        	if(tLong<=pLong) {	//p보다 작은 문자열의 개수를 반환해야하니 if문으로 조건
        		answer++;
        	}
        }
        
        
        return answer;
    }
	
	public static void main(String[] args) {
		String t = "10203";
		String p = "15";
		int answer = solution(t, p);
		System.out.println(answer);
			
	}

}
//[크기가 작은 부문문자열] : 주어진 문자열 t를 p문자열의 길이만큼 자른후 잘랐을때 b보다 작은 문자(숫자)의 개수를 구하는 문제
/*
이 문제는 그냥 주어진 문자 t를 p문자열의 길이 만큼 index를 +1해주며 잘랐을때 반환되는 숫자가 p를 숫자로 변환한 것보다
작을 경우의 횟수를 반환하면 되는 간단한문제이다. 여기서 p의 길이가 18까지 이므로 long으로 설정해주는 것과,
for문으로 나눠서 t를 나눠줄때 p의 길이 - t의 길이에 +1을 해주는 만큼 반복하는 부분을 주의하며
해당 문자열을 구할때 split으로 단순히 i, i + p길이 만큼 구해 숫자로 변환해 비교해주면되는 간단한 문제이다.
*/
 