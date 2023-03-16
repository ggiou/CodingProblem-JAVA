package step.condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B_2884 {

	public static void main(String[] args) throws IOException {
		/*Scanner sc = new Scanner(System.in);
		int h = sc.nextInt(); //시
		int m = sc.nextInt(); //분
		
		if(m<45) {
			h--;	//시 1 감소
			m = 60 + (m - 45); //분 감소
		}else m -= 45;
		
		if(h<0) h = 24 + h;
		
		System.out.println(h+" "+m);*/
		//1. 단순 조건문 - 232ms
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); //시, 분이 한줄로 들어오니 토큰라이저로 분리해 저장..
		int h = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		m -= 45; //현재 보다 45분 일찍 일어나야하니..
		if(m<0) {
			h--;	//0보다 작다는것은 1시간을 뺴줘야함
			m+=60;	//1시간을 빼줬으니 60분기준이니 더해주면 됨
		}
		if(h<0) h += 24; //0보다 작아지면 하루는 24시간이니..
		System.out.println(h+" "+m);
		//2. // + buffer - 152ms
	}
}
// 시간을 변화해 출력하는 문제
/* 이 문제에서 입력을 받는 경우에는 
   Scanner, 
   bufferReader - StringTokenizer, 
   bufferReader - 문자열 배열로 받아 - .split 
   3가지가 있지만 성능은 split, tokenizer 크게 차이가 안나 tokenizer만 적어뒀다.
   
   출력은 그대로 System.out과  StringBuilder로 만들어 System.out이 있지만
   출력되는 양이 많다면 StringBuilder가 유리하지만 2개만 출력하면 되므로 그냥 편한 그대로 출력을 사용했다.
   
   ** 여기서는 크게 2가지 조건을 확인해주면된다. 시간은 하루는 24시간이라는점과 한시간은 60분이라는 점,
      이를 확인하면 만약.. 
      1. 조건에 맞게 입력 받은 분에서 45분을 뺐을 경우 0보다 작을 경우는
      한시간 전으로 돌아갔다는 것이니 입력받은 시간에서 1시간을 빼주면 된다.
      그러면서 분은 현재 분에서 -45한것을 60을 더해주면 된다.
      =  60 + (분 - 45) = 60 - (45 - 분)
      2. 만약 위의 연산으로 시간이 0보다 작아진다면
      하루전에 알람을 맞춰야하는 것이므로 하루는 24시간이니 현재 음수가된 시간에서 24를 더해주면된다.
      하지만 여기서는 이경우의 경우 무저건 0에서 전날밖에 없으니 그냥 23으로 고정시켜줘도된다.
   
   위 조건은 일반적인 if문을 통해 풀을 수 있으며, switch문을 통해서도 가능하다.
   하지만 if문이 상대적으로 간단하니 if문으로만 해결했다.
   또한! 삼항 연산자를 사용할려해도 입력받은 분이 0보다 작아질 경우는
   시간도 1시간이 줄어들어야해 이로 표현하면 복잡할 뿐더러 애초에 시와 분이
   따로 적용하게 되 이는 제외 하였다. 
    because - 삼항연산자의 경우 조건에 따라 결과값을 하나만 얻을 수 있음, 다른 해의 연산 동시 안됨.. 
    결과 = 조건 ? 참일 경우 값 : 거짓일 경우 값
    
   - 아니면 분은 if, 시간은 삼항으로도 가능하지만 통일성을 해쳐 제외..
   시간 삼항연산자 -  h = h < 0 ? 24 - h : h
   */
