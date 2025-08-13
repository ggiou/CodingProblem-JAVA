package Baekjoon_coding.step.io_calculation;

public class B_10171 {

	public static void main(String[] args) {
		/*System.out.println("\\    /\\");
		System.out.println(" )  ( ')");
		System.out.println("(  /  )");
		System.out.println(" \\(__)|");*/
		//1. println - 120ms

		StringBuilder sb = new StringBuilder();
		sb.append("\\    /\\\n").append(" )  ( ')\n")
		.append("(  /  )\n").append(" \\(__)|");
		System.out.print(sb);
		//2. StringBuilder - 112ms
	}
}
// 기본 출력문제 - sb가 조금 빠름, 출력 문자열이 많아야 더 효과적
/* 출력된 고양이는 귀엽다..
\    /\
 )  ( ')
(  /  )
 \(__)|
*/