package Baekjoon_coding.step.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_9086 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<t; i++) {
            String s = br.readLine();
            sb.append(s.charAt(0)).append(s.charAt(s.length() - 1)).append("\n");
        } //이런식으로 .append.append 문자끼리 나눠서 저장하면 속도가 더 빨라짐
        System.out.println(sb);
        //1. BufferReader + StringBuilder + for = 116ms
    }
}
//[문자열] : 테스트 케이스만큼 입력받은 문자열의 첫 글자와 마지막글자를 연속으로 출력하는 문제
//입력받은 문자를 charAt으로 첫번째와 마지막 idx 글자를 반환해 출력하면되는 간단한 문제 -> stringBuilder를 사용하면 더 속도가 빠르고, while보다 for이 더 빨랐음..