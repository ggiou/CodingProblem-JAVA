package Swea_coding.test;

import java.util.*;

public class Solution {

    public static String[] solution(String[] rooms, int target) {
        Map<String, Integer> seat = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        String tName = "";
        for (String room : rooms) {
            String[] parts = room.split("]");
            int num = Integer.parseInt(parts[0].substring(1));
            String[] employees = parts[1].split(",");
            if(room.contains(String.valueOf(target))) tName = parts[1];
            
            for (String employee : employees) {
                String name = employee.trim();
                seat.put(name, seat.getOrDefault(name, 0) + 1);
                distance.put(name, Math.abs(target - num));
            }
        }

        List<String> answer = new ArrayList<>();

        for (String employee : seat.keySet()) {
            if (seat.get(employee) > 0) {
                answer.add(employee);
            }
        }

        if (!answer.isEmpty()) {
        	if(tName.contains(",")) {
        	 String[] delName = tName.split(",");
        	 for(int k=0; k<delName.length; k++) {
        		 int del = answer.indexOf(delName[k]);
             	answer.remove(del);
        	 }
        	}else {
        		int del = answer.indexOf(tName);
        		answer.remove(del);
        	}
        }
        
        Collections.sort(answer, (a, b) -> {
            int cc = seat.get(a) - seat.get(b);
            if (cc != 0) {
                return cc;
            }

            int dc = distance.get(a) - distance.get(b);
            if (dc != 0) {
                return dc;
            }

            return a.compareTo(b);
        });

        System.out.println(tName);
        return answer.toArray(new String[0]);
    }


    public static void main(String[] args) {
        String[] rooms = {"[403]James", "[484]Azad,Louis,Andy", "[101]Azad,Guard"};
        int target = 403;

        String[] result = solution(rooms, target);
        System.out.println(Arrays.toString(result));
    }
}
