package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {

	public static int[] solution(String s) {
		List<Integer> newAnswer = new ArrayList<Integer>();
		char[] arr = s.toCharArray();
		int count = 0;
		char old = ' ';
		for (int i = 0; i < arr.length; i++) {
			char target = arr[i];
			if (old != target) {
				for (int j = i; j < arr.length; j++) {
					// System.out.println(target+" : "+arr[j]);
					if (target == arr[j]) {
						++count;
						continue;
					} else {
						// System.out.println(target+" "+count);
						newAnswer.add(count);
						count = 0;
						break;
					}
				}
			}
			old = arr[i];
		}

		char f = arr[0];
		char l = arr[arr.length-1];
		System.out.println(l+" "+f);
		if (l == f) {
			System.out.println(newAnswer.get(newAnswer.size() - 1));
			System.out.println(newAnswer.get(0));
			int nums = newAnswer.get(newAnswer.size() - 1) + newAnswer.get(0);
			newAnswer.set(0, nums);
			newAnswer.remove(newAnswer.size() - 1);
		}

		int answer[] = newAnswer.stream().mapToInt(k -> k).toArray();
		// 리스트 배열 변환

		return answer;

	}

	public static void main(String args[]) {
		System.out.println(Arrays.toString(solution("aabbeeea")));
	}
}
