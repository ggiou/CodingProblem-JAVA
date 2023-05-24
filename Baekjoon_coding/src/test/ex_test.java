package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class ex_test {

	public static void main(String[] args) throws IOException {
		/*
		 * Scanner sc = new Scanner(System.in); List<String> userIdList = new
		 * ArrayList<>(); for(int i=0; i<4; i++) { String name = sc.next();
		 * userIdList.add(name); } Collections.sort(userIdList); StringBuilder rn = new
		 * StringBuilder(); for (int i = 0; i < userIdList.size(); i++) {
		 * rn.append(userIdList.get(i)).append(", "); } String roomName =
		 * rn.substring(0, rn.length()-2);
		 * 
		 * System.out.println(roomName);
		 */
		
		
		/*
		 * String name = "?•˜?Š˜"; String viewName = "";
		 * 
		 * String n = "Goose, Yumi, Jiwan, ?‚˜ë¦?, ?¬ë¯?, ?•˜?Š˜"; int index = n.indexOf(name); if
		 * (index >= 0 && n.length() > index + name.length() + 2 && n.substring(index +
		 * name.length(), index + name.length() + 2).equals(", ")) {
		 * System.out.println("There is a \", \" after"); viewName =
		 * n.replaceAll(name+", ", ""); System.out.println("\n"+viewName); } else {
		 * System.out.println("There is no \", \" after"); viewName =
		 * n.replaceAll(", "+name, ""); System.out.println("\n"+viewName); }
		 */
		
		
		/*
		 * String roomName = "?˜?¬, ?ˆ˜? •, ê°??Œ"; String me = "?ˆ˜? •";
		 * 
		 * String[] names = roomName.split(", "); String viewName = "";
		 * 
		 * if (names[names.length - 1].equals(me)) { viewName = roomName.replaceAll(", "
		 * + me, ""); //?‚´ ?´ë¦„ì´ ë§ˆì?ë§‰ì¸ ê²½ìš° ?•?˜ , ?? ?•¨ê»? ? œê±? } else { viewName =
		 * roomName.replaceAll(me + ", ", ""); //?‚´ ?´ë¦„ì´ ë§ˆì?ë§‰ì´ ?•„?‹Œ ê²½ìš° ?’¤?— , ?? ?•¨ê»? ? œê±? }
		 * 
		 * if (!viewName.contains(",")) { viewName = "???™” ?ƒ?? ?—†?Œ"; }
		 * System.out.println(viewName);
		 */
        
		
		/*
		 * int totalPosts = 100; // or any other desired number of posts
		 * 
		 * int[] counts = new int[] {30, 30, 10, 2, 3, 5, 10, 10}; // desired counts for
		 * each category int[] roundCounts = new int[counts.length]; // counts for each
		 * category in each round
		 * 
		 * int roundSize = 8; // number of posts generated per round int numRounds =
		 * (totalPosts + roundSize - 1) / roundSize; // calculate number of rounds
		 * needed
		 * 
		 * List<String> posts = new ArrayList<>(); // array to store generated posts
		 * 
		 * for (int i = 0; i < numRounds; i++) { // generate posts for each category in
		 * order for (int j = 0; j < counts.length; j++) { int count = counts[j]; int
		 * roundCount = roundCounts[j]; if (count > 0) { int numPosts = (int)
		 * Math.ceil((double) count / (numRounds - i)); // calculate number of posts for
		 * this round if (numPosts > roundSize - roundCount) { numPosts = roundSize -
		 * roundCount; // don't generate more than the remaining space in the round }
		 * for (int k = 0; k < numPosts; k++) { // generate a post for this category
		 * posts.add(getPost(j)); } counts[j] -= numPosts; // update count for this
		 * category roundCounts[j] += numPosts; // update count for this round } } //
		 * reset round counts for next round Arrays.fill(roundCounts, 0); }
		 * 
		 * // print out the generated posts for (int i = 0; i < posts.size(); i++) {
		 * System.out.println("Round " + (i / roundSize + 1) + ": " + posts.get(i)); }
		 */
		int total = 210;
		List<int[]> arr = new ArrayList<int[]>();
		int done = total / 20;
		int num = total % 20;
		System.out.println("ë½‘ì•„?•¼ ?•  ê°œìˆ˜ : " + num);
		int[] maxA = {6, 6, 2, 1, 1, 2, 4};
		int[] rearA = {0, 0, 0, 0, 0, 0, 0};

		List<Integer> availableIndexes = new ArrayList<>();
		for (int i = 1; i <= 7; i++) {
		availableIndexes.add(i - 1); // ?¸?±?Š¤?Š” 0ë¶??„° ?‹œ?‘?•˜ê¸? ?•Œë¬¸ì— -1 ?•´ì¤?
		}

		Random random = new Random();
		for (int i = 0; i < num; i++) {
		int availableIndex = random.nextInt(availableIndexes.size());
		int index = availableIndexes.get(availableIndex);

		rearA[index]++; // ?•´?‹¹ ?¸?±?Š¤?— 1 ì¶”ê?
		if (rearA[index] == maxA[index]) { // ?•´?‹¹ ?¸?±?Š¤?— ?“¤?–´ê°? ?ˆ˜ ?ˆ?Š” ì¹´ë“œë¥? ?‹¤ ë½‘ì•˜?‹¤ë©?, ?•´?‹¹ ?¸?±?Š¤?Š” ?”?´?ƒ ë½‘ì? ?•Š?Œ
		    availableIndexes.remove(availableIndex);
		}
		}
		
		for(int i=0; i<done; i++) {
			arr.add(maxA);
		}
		arr.add(rearA);

		
		// ê²°ê³¼ ì¶œë ¥
		System.out.println(Arrays.toString(rearA));
		
		System.out.println("?‹¤? œ");
		System.out.println(Arrays.toString(arr.get(0)));
		
		/*
		 * for (int[] a : arr) { System.out.println(Arrays.toString(a)); }
		 */
    };
}
		

		
	
	



