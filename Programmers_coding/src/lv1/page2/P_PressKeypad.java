package lv1.page2;

public class P_PressKeypad {
	static int r;
	static int l;
	static String answer;
	public static String solution(int[] numbers, String hand) {
        answer = "";
        r = 12;
        l = 10;
        int lv = 0;
        int rv = 0;
        if(hand == "left") hand = "L";
        else hand = "R";
        
        for(int i=0; i<numbers.length; i++) {
        	int num = numbers[i];
        	if(num==0) num = 11;
        	
        	if(num == 1 || num == 4 || num == 7) {
        		getHandValue("L", num);
        	}else if(num == 3 || num == 6 || num == 9) {
        		getHandValue("R", num);
        	}else {
        		lv = Math.abs(l-num);
        		rv = Math.abs(r-num);
        		if(lv==rv) {
        			getHandValue(hand, num);
        		}else if(lv>rv) {
        			getHandValue("R", num);
        		}else {
        			getHandValue("L", num);
        		}
        	}
        	
        }
        return answer;
    }
	
	static void getHandValue(String h, int num) {
		System.out.println("바꾸기 전 L는 "+l+" R은 "+r+" 가까운 방향은 "+h);
		if(h=="L") {
			answer += "L";
			l = num;
		}else {
			answer +="R";
			r = num;
		}
		
	}
	public static void main(String[] args) {
		int[] numbers =  {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		System.out.println(solution(numbers, hand));

	}

}

/*
1 2 3
4 5 6
7 8 9
10 11 12

8-3 = 5
8-1 = 7
1
10 - 5 = 5
12 - 5 = 7

*/
