package step.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B_11718 {

	public static void main(String[] args) throws IOException{
		String str;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while((str=br.readLine())!=null) {
			System.out.println(str);
		}
		//1. buffer = 128ms
		/*
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			System.out.println(sc.nextLine());
		}*/
		//2. scanner = 236ms
	}

}
//[그대로 출력하기] : 입력받은대로 출력하는 문제 (최대 100줄)
//이 문제는 만약 입력이 몇번 일어나는지(테스트케이스) 모를때 출력하는 문제로 
//buffer의 들온 한줄이 null이거나 scanner의 hasNext를 통해 다음 줄 여부를 확인해 while 반복으로 출력해주면 되는 간단한 문제다. 