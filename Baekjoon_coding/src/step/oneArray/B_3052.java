package step.oneArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class B_3052 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] arr = new boolean[42]; // 42로 나누니 최대 41까지 나머지로 남을 수 있음.. & boolean 배열의 초기값은 false
		int count = 0; // 다른 값 count
		
		/*
		for (int i = 0; i < 10; i++) {
			arr[Integer.parseInt(br.readLine()) % 42] = true; //다른 값을 찾으면 되니, 나머지가 있는 곳을 true 설정
		}
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == true) count++;
		}*/ //1. arr[] 사용 - 124ms
		
		HashSet<Integer> set = new HashSet<Integer>(); //hashset은 중복값을 저장하지 않음..
		
		for(int i=0; i<10; i++) {
			set.add(Integer.parseInt(br.readLine()) % 42);
		}
		count = set.size();
		//2. hashSet 사용 - 120ms
		
		System.out.print(count);
	}

}
// [나머지] : 입력받은 10개의 수를 42로 나눈 나머지 값들 중 다른 값들이 몇개 있는지 반환해주는 문제
/* 1. 배열 사용
 *   : 42로 나눈 나머지 값이니, 가능 한 나머지의 범위는 0~41까지다.
 *     이를 생각하면, 나머지 값에 해당되는 부분을 true로 설정한다면 중복된 값이라도, true인 값을 true로 
 *     저장하니, 즉 동일 값을 하나로 표현하며 저장됨 -> 여기서 true인 값의 개수를 구하면, 다른 값들 개수 반환됨
 * 
 * 2. HashSet 사용
 *   : hashSet은 중복 값을 가질 수 없다는 점을 생각하면 된다.
 *     즉 중복값을 자동으로 제외하고 저장하기에, 저장된 값의 개수가 다른 값 개수 = hashSet의 길이를 반환해주면 됨
 */
 