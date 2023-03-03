package step.io_calculation;

public class B_10172 {

	public static void main(String[] args) {
		System.out.println("|\\_/|");
		System.out.println("|q p|   /}");
		System.out.println("( 0 )\"\"\"\\");
		System.out.println("|\"^\"`    |");
		System.out.println("||_/=\\\\__|");
		// println - 116ms
	}
}
// 기본 출력문제 + 특수문자 출력 문제 (10171과 같으니 StringBuilder은 생략)
// 특수문자를 문자열로써 출력할려면 \"과 같이 입력하면 됨..
/* 특수문자 출력
 1. Escape 문자 사용
    \(백슬래시)로 같이 사용될 경우 본래의 기능이 아닌 문자로 출력
 	ex) print("\"\'"); -> "'
 	
 2. char 사용
 	char타입으로 표현후 이를 사용해 문자열에 이어붙여 사용
 	ex) char q = """; 
 	    String str = "He "+q+"cute"+q; 
 	    print(str); -> He "cute"
 	    
 3. Unicode
    특수문자에 해당하는 Unicode를 찾아서 직접 입력 -> 읽고 해석이 어려움
    ex) char q = '\u0022'; 
 	    String str = "He "+q+"cute"+q; 
 	    print(str); -> He "cute"  
 	    
  -> 그냥 Escape 문자 \를 사용하는 것이 가장 쉽게 출력 가능
 */
