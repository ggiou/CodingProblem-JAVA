package Programmers_coding.lv1.page2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P_GetReportResults {
	public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        List<String> idIdxList = Arrays.asList(id_list);	//해당 회원에게 처리결과를 보내주기 위해 회원의 idx를 파악하기 위한 리스트
        Map<String, Integer> idIdxMap = new HashMap<String, Integer>(); //회원별 인덱스
        
        Map<String, HashSet<String>> reportsWho = new HashMap<String, HashSet<String>>();		
        //신고당한 사람별 신고한 사람을 담을 Map 		key : 신고당한 id, value : 이용자 id
        
        Set<String> stopIds = new HashSet<String>();	//k번이상 신고를 당해 정지당할 사람들
        
        //1. 신고 내용을 확인해, 정지 시킬 사람을 판별하는 과정
        for(int i=0; i<report.length; i++) {	
        	String[] reports = report[i].split(" ");	//"이용자id 신고한id"로 구분을 한 해당 신고 내역
        	String userId = reports[0];		//이용자 id
        	String reportId = reports[1];	//신고 id
        	
        	HashSet<String> whos = reportsWho.getOrDefault(reportId, new HashSet<String>());	//신고한 사람들        	
      
        	whos.add(userId);	
        	reportsWho.put(reportId, whos);	//해당 id 추가 (set은 중복 안됨)
        	
    		if(whos.size()>=k) {	//신고 횟수가 k 번 이상이면 정지되야함
    				stopIds.add(reportId);	//정지 이름에 더하기
    		}else {
    			continue;	//이미 신고한 사람은 횟수도 그대로 1회이니, 변화없이 다음 신고내용을 확인해야함
    		}
        }
        
        //2. 각 id의 사람들 별, 신고했는데 정지된 id의 개수를 구하는 과정 
        Iterator<String> stopPeoples = stopIds.iterator();	//정지당한 사람들
        while (stopPeoples.hasNext()) {	
			String id = stopPeoples.next(); //정지된 id
			Set<String> whos = reportsWho.get(id);
			
        	
			Iterator<String> userIds = whos.iterator();	//정지당한 사람을 신고한 id들
			while(userIds.hasNext()) {
				String userId = userIds.next();
				
				int userIdx = idIdxMap.getOrDefault(userId, -1);	//이용자 id idx
	        	if(userIdx == -1) {
	        		int idIdx = idIdxList.indexOf(userId);
	        		idIdxMap.put(userId, idIdx);	//idx를 담은 map에 없다면 저장 필요
	        		userIdx = idIdx;
	        	}
	        	
				answer[userIdx] += 1;	//해당 회원은 신고한 사람은, 접수 메일을 받아야하니, 접수메일 횟수 ++
			}
			
		}  
        return answer;
    }
	public static void main(String[] args) {
		String[] id_list = {"con", "ryan"};
		String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
		int k = 3;
		int[] result = solution(id_list, report, k);
		System.out.println(Arrays.toString(result));

	}

}
//[신고 결과 받기] : 주어진 조건과 상황을 통해 각 id_list의 사람들이 신고한 사람중 정지된 id의 개수를 반환하는 문제
/*
  이 문제에서	1. 한 회원은 여러번 신고가 가능하지만, 같은 회원이 신고할 경우 신고 횟수는 1회로 처리한다.
  			2. k번 이상 신고된 유저는 이용이 정지되며, 해당 회원을 신고한 모든 회원들에게 정지 사실을 메일로 발송한다.
  			3. 여기서 구하고자 하는 것은, 주어진 id_list대로 해당 idx의 회원이 받은 정지 메일을 계산해서 숫자 배열을 구하는 것이 목적이다.
  이 3가지 포인트에 집중해서 문제를 풀었다.
  이 세가지에서 , 1번을 통해 set(중복 금지)을 사용해 해당 회원을 신고한 사람들의 id를 저장해둬야겠다 파악하고						== reportsWho의 value
  			, 2번을 통해 해당 set의 size가 k보다 클 경우 정지된 회원의 id를 담아둘 set을 사용하고자 생각했으며 				== stopIds
  			, 3번을 통해 정지가 된 사람을 신고했을 경우 횟수를 +1해줘야하니, answer의 각 idx는 id_list와 동일한 idx에 
  				id_list[idx]라 생각해 빠르게 신고한 회원의 idx를 구하기 위해, map을 사용해 회원별 idx를 저장해야겠다파악했다.	== idIdxMap
  
  이를 통해 총 2번의 과정을 통해 문제를 해결할 수 있게 된다.
  1. report 배열에서 각 신고 내용을 가져와, 정지시킬 사람을 판별하는 과정
  	 -> 이때 report의 크기만큼 for문으로 반복하며, set의 경우 중복 원소는 저장되지 않으니, 신고당한사람/신고한사람들을 넣는 reportsWho에 put으로
  	 	저장해주며, 신고한 사람인 reportsWho.value = whos의 길이가 제한 신고 횟수인 k를 넘는다면 
  	 	정지되야하는 사람으로 판별해 stopIds에 넣어준다. -> 정지된 사람 판별 (이 역시도, set을 통해 중복 방지 - 어처피 정지 id가 동일하면 또 넣을 필요 없으니..)
  	 	
  2. 정지된 사람을 신고한 사람의 경우, 정지 메일을 받을 수 있으니 해당 id의 idx를 찾아 answer[idx] + 1을 해 전체 id_list의 사람들이 받은 정지 메일의 횟수를 구하는 과정
  	-> 이때 구해진 정지된 사람들의 id가 담긴 set인 stopIds를 iterator을 통해 해당 값들을 가져와,
  	   하나씩 정지된 id를 통해 정지 id별 신고한 사람들 id를 저장해둔 reportsWho를 찾아온다. (reportsWho.get(id))
  	   그 후 가져온 신고한 사람들의 id의 idx를 idIdxMap()에서 가져와 (빠르게 찾기 위해.. 없을 경우 저장, 있으면 map에서 가져다 쓰기) 
  	   정지 메일을 받는 횟수를 반환하는 answer 배열의 answer[idx] 값에 메일이 하나 더오는 것이니 +1을 해주는 과정을 반복해 정지메일을 받은 횟수를 저장한 숫자 배열 answer을 반환하며 문제를 해결했다.
  
 */
