package Swea_coding.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class S16800 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int tc = Integer.parseInt(br.readLine()); //테스트케이스
		for(int i=0; i<tc; i++) {
			Long n = Long.parseLong(br.readLine()); //셀의 위치 (x, y) -> x*y = n
			Long minMove = n-1; //최대 움직임 횟수로 지정 
			//System.out.println(Math.sqrt(n));
			//(1, 1)에 있으니 셀의 위치까지 움직일려면 (1, n)이 최대, 즉 n-1번 움직이는게 가장 많이 움직임..
			for(Long j=1L; j <= Math.sqrt(n); j++) {
				if(n%j==0){
					Long move = (j-1)+(n/j - 1); //j는 약수중 작은수, n/j는 큰수 -> n = 11일때, j=1, n/j=11
					if(minMove>=move) minMove = move;
				}
			}
			System.out.println("#"+(i+1)+" "+minMove);
		}
		br.close();
	}

}
// (2 <= N <= 10^12)까지니 long으로 받아줘야함..
/* 최적화 약수 구하기
   Math.sqrt(n)은 제곱근 반환 -> 약수는 제곱근을 기준으로 앞뒤로 이루어짐
   ex) 100의 경우 1, 2, 4, 5, 10, 20, 25, 50, 100 이 약수임, 여기서
       제곱근인 10을 기준으로 약수중 작은 수와 큰 수로 대칭으로 앞 뒤로 나눠짐
       즉 for문으로 1부터 제곱근 전까지 구하되 작은 수는 i이고 큰 수는 n/i를 하면 값이 나옴
       이 방식으로 하면 기존 1~n까지 일일히 약수인지 확인해야하는게 제곱근까지만 확인하면 되니 절반 넘게 빨라짐 = 효율 좋음 
 	
 	제곱근이 double 실수로 변환되는데 어처피 int 정수로 값을 구해야하니 형변환만 해주면됨. 
 	만약 제곱근이 4.9여도 실제로 5일 경우 약수를 확인할 필요없음, 그 4.9 전의 숫자들 중 약수가 있을 수 있는거니..
 	즉 그냥 int로 바꿔줘도 이 문제에서는 정상적으로 돌아감. 
 */

