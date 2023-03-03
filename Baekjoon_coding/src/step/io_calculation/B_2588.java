package step.io_calculation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class B_2588 {

	public static void main(String[] args) throws IOException {
		/*Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		System.out.println(num1*(num2%10));       //1의자리 구하기
		System.out.println(num1*((num2%100)/10)); //10의 자리 구하기 
		System.out.println(num1*(num2/100));	  //100의 자리 구하기
		System.out.print(num1*num2);*/
		//1. 수학연산을 통한 각 자리값 구하기+Scanner - 204ms
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num1 = Integer.parseInt(br.readLine());
		String num2 = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		/*sb.append(num1*(num2.charAt(2)-'0')).append("\n"); //문자 '숫자'이아닌 숫자를 위해 '0'을 뺴줌
		sb.append(num1*(num2.charAt(1)-'0')).append("\n");
		sb.append(num1*(num2.charAt(0)-'0')).append("\n");
		sb.append(num1*Integer.parseInt(num2));
		System.out.print(sb);*/
		//2. charAt + br + st - 120ms
		
		
		char[] Num2 = num2.toCharArray();
		System.out.println(num1 * (Num2[2] - '0'));
		System.out.println(num1 * (Num2[1] - '0'));
		System.out.println(num1 * (Num2[0] - '0'));
		System.out.println(num1*Integer.parseInt(num2));
		//2. char[] + br + println - 116ms
		//sb보다 ln은 \n이 포함되어있다보니 더 빠르게 실행..
	}

}
//각 자리수 구해 연산 후 출력문제 - 총 수학연산, charAt(), 배열로 한자리씩 전환 3가지 방법
//실행속도를 줄여 효율성을 올리기 위해 1. 수학연산 외에는 BufferReader을 사용

/* 정수의 각 자리수의 값 구하기 - ex)123 -> 1의 자리 3, 10의 자리 2, 100의 자리 1
 1. 수학연산을 통한 각 자리값 구하기 - % 나머지, / 나누기 를 통해 각 자리수를 구할 수 있다.
 	- int n = 123;
 	   일의 자리 - n%10 = 123%10 = 3
 	   십의 자리 - (n%100)/10 = 23/10 = 2
 	   백의 자리 - n/100 = 123/100 = 1
 	   
 2. 문자열로 입력받아 charAt() - 문자열은 charAt을 통해 인덱스의 하나의 문자열을 얻어올 수 있는 성질 이용
   ** char형으로 받아져 아스키코드형식이므로, 숫자로서가 아닌, 문자열로서 받아와
   ** 값이 실제 수와 다르게된다. 그러니 아스키코드에 따라 -'0'을 해주면 실제 수의 값이 들어온다.  
   - String n = 123;  -> 인덱스는 0부터 시작하는거 주의! [0] = 1, [1] = 2, [2] = 3
       일의 자리 - n.charAt(2) - '0' = '3' - '0' = 51-48 = 3
 	   십의 자리 - n.charAt(1) - '0' = '2' - '0' = 50-48 = 2
 	   백의 자리 - n.charAt(0) - '0' = '1' - '0' = 49-48 = 1
 	   
 3. char[] = char형 배열로 받아와 인덱스로 자리수 얻어오기
   **2번과 마찬가지로 아스키코드니 -'0'을해야 실제 수, 아스키코드 '0' = 48, '9' = 57
	- char[] arr = n.toCharArray;  
       일의 자리 - arr[2] - '0' = 3
 	   십의 자리 - arr[1] - '0' = 2
 	   백의 자리 - arr[0] - '0' = 1 
 */
