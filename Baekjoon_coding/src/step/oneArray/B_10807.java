package step.oneArray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B_10807 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //입력받을 정수의 개수
		int[] arr = new int[n];	//정수를 저장해놀 배열 생성
		
		StringTokenizer st = new StringTokenizer(br.readLine()); //한줄로 공백으로 구분되 입력되니 나누기 위해 StringTokenizer
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int v = Integer.parseInt(br.readLine());	//같은지 판단 할 수
		int count = 0;	//횟수를 담을 변수
		
		for(int j =0; j<n; j++) {
			if(arr[j] == v) count++;
		}
		/*for(int j : arr) {
			if(j == v) count++;
		}*/
		
		System.out.println(count);
		//1. BufferReader + System.out + for(:) - 212ms
		//2. BufferReader + System.out + for(;;) - 128ms
	}

}
//개수 세기 - 입력받은 수 안에서 동일한 수의 개수 세기

/*
   이 문제는 처음에 정수의 개수를 입력받고, 그 후 그만큼의 각각의 수를 입력받는다.
   그리고 하나의 정수를 알려 주는데 그 정수와 입력받았던 수들을 비교해 같은 수가 몇개 있는지 판단하는 문제다.
   여기서 문자열을 비교한다든지 여러가지 방법이 있겠지만, 애초에
   문제의 카테고리가 1차원배열이기도 하고, 가장 효율적인 방법이라 배열로 문제를 풀었다.
   
   ** 해결과정
      1. 정수의 개수를 입력받는다. -> 어려우면 testcase라 생각..
      2. 입력받은 개수만큼 정수를 입력받을 배열을 만든다. = 그 각각의 수를 담을 상자를 배열이라 생각
      3. 배열에 정수를 입력받는다. -> 배열같은 경우는 for문을 이용하면 쉽게 입력받을 수 있음
      4. 비교할 수를 입력받는다.
      5. for문을 통해 배열전체를 비교할 수와 같은지 여부를 판단한다.
         = 간단히 배열전체를 비교하니 for문으로 하나씩 배열에서 값을 가져와 그 값이 수와 같은지 비교한다 생각
  	     + 향상된 for(:)문보다 일반 for(;;)문이 더 속력이 빠르다. 
         
   - 입력방법
 	Scanner,  BufferedReader가 가능하나 buffer가 성능상 훨씬 좋으므로 코드에는 buffer만 사용
  
   - 출력방법
     이 문제의 경우 단순히 횟수 하나만을 출력하기에 버퍼라이터나, 스트링빌더를 사용하는 것보다 단순 system 출력이 더 효율적이고 쉽다
      -> 함수를 부를 경우 이런 단순한 하나의 출력하는 것보다, 함수를 부르는데도 시간이 필요해 오히려 비효율적..
      
      
   ** 배열 
      정의 : 동일한 자료형(Data Type)의 데이터를 연속된 공간에 저장하기 위한 자료구조이다. 
            즉, 연관된 데이터를 그룹화하여 묶어준다고 생각
      장점 : 연관된 데이터를 저장하기 위한 변수의 선언을 줄여주며, 
            반복문 등을 이용하여 계산과 같은 과정을 쉽게 처리할 수 있다.
            
      ! 유의) 배열의 길이는 고정되어있다.
            : 배열의 길이를 먼저 설정하여 배열 변수를 먼저 생성한 다음 그 값은 나중에 대입하는 방법이다.
            즉, 다음과 같은 코드는 불가능하다.
			String[] weeks = new String[];    
			// 길이에 대한 숫자값이 없으므로 컴파일 오류가 발생한다.

   * 일차원 배열
   1. 선언 및 사용법
      - 배열을 선언하는 방법 -> 자료형 [] 배열이름
        int[] intArr1;
        int []intArr2;
        int intArr3[];
        
      - 배열을 초기화하는 방법 -> new 자료형 [배열크기]
        intArr1 = new int[3];	//size 3, index range from 0 to 2
   
 	  - 배열의 선언과 초기화를 동시에 하는 방법 -> 자료형 [] 배열이름 = new 자료형 [배열크기]
 		int[] intArr4 = new int[10];    //size 10, index range from 0 to 9
 		int[] intArr5 = {1, 2, 3, 4, 0}; //size 5, index range from 0 to 4
 	
 	  - 배열의 길이 접근 -> 배열이름.length
 	    System.out.println(intArr5.length) = 5
 	    
 	  - 배열의 값 접근
 	    System.out.println(intArr5[0]); = 1
 	  
 	  - 배열 전체 출력
 	    System.out.println(Arrays.toString(intArr5)); = [1, 2, 3, 4, 0]
 */
