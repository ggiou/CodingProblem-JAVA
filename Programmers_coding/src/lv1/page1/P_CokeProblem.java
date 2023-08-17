package lv1.page1;

public class P_CokeProblem {
	public static int solution(int a, int b, int n) {
        int answer = 0;
        while (n>=a) {
        	int num = n/a; //교환 가능한 개수
        	n = n - (num*a) + (num*b);	//빈 병의 개수 = 기존 병의 개수 - (교환한 병의 개수) + (교환해서 얻은 병의 개수)
			answer += num*b;	//받을 수 있는 콜라병 += 교환가능 개수 * 빈병당 얻을 수 있는 병의 개수 
		}
        return answer;
    }
	public static void main(String[] args) {
		int a = 2;
		int b = 1;
		int n = 20;
		int result = solution(a, b, n);
		System.out.println(result);

	}

}
//[콜라 문제] : 주어진 조건에 맞는 공식을 구현하는 문제
/*		
이 문제는 단순하게 주어진 공식을 코드로 구현하면 되는 쉬운 문제이다. 문제 옆에 적은 주석대로,
여기서 구하고자하는 교환해 얻은 병의 개수는 내가 가지고 있는 빈병의 개수가 더이상 교환할 수 없을 때까지 반복해 구해주며 answer에 더해주면 된다.
*/
