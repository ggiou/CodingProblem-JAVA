package Baekjoon_coding.step.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2908 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(br.readLine());
		String[] nums = sb.reverse().toString().split(" "); //reverse함수를 사용해 뒤집은 후, 공백기준 나눔
		System.out.print(Math.max(Integer.valueOf(nums[0]), Integer.valueOf(nums[1]))); //math.max로 더 큰 수 반환
		//1. buffer + stringBuilder = 120ms
	}
	
}
//[상수] : 한줄로 입력받은 2개의 수를 뒤집은 후 둘 중 더 큰 수를 반환하는 문제
//문자를 입력받고 stringBuilder의 reverse 함수를 사용하면 쉽게 문자열을 뒤집을 수 있다, 그 후 split으로 공백으로 분리후 math.max로 더 큰 수 반환하면 쉽게 풀 수 있다.