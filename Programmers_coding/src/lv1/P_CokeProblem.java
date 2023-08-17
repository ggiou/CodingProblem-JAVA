package lv1;

public class P_CokeProblem {
	public static int solution(int a, int b, int n) {
        int answer = 0;
        while (n>=a) {
        	int num = n/a; //교환 가능한 개수
        	n = n - (num*a) + (num*b);
			answer += num*b; 
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
