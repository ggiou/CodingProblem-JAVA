package Programmers_coding.lv2.page3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class P_OpenChatRoom {
	static Map<String, String> user; //회원 이름 정보
	static Map<String, List<Integer>> userRecodInfo; //회원 대화 위치 정보
	static List<String> answer;	//정답 배열
	
	static String behavior; //행동
	static String id;		//회원 고유 id
	static String name;		//회원 이름
	
	public static String[] solution(String[] record) {
		answer = new ArrayList<String>();
        user = new HashMap<String, String>();	
        userRecodInfo = new HashMap<String, List<Integer>>(); 
        
        for(int i=0; i<record.length; i++) {	//record를 바탕으로 행동을 메세지로 세팅화는 과정 (Enter="님이 들어왔습니다." 처럼..) 
        	String[] r = record[i].split(" ");
        	saveUserAction(r);	//행동 저장
        }
        
        Iterator<String> keys = user.keySet().iterator();	//userID들 가져오기
        while(keys.hasNext()) {	//이름을 세팅하는 과정 -> 이름+"님이 (행동)했습니다." 으로 만드는 과정
        	String key = keys.next();
        	String userName = user.get(key);	//해당 회원의 마지막 최종 이름
        	List<Integer> indexList = userRecodInfo.get(key);	//해당 회원의 행동한 index들이 담겨있는 리스트 가져오기
        	for(int i=0; i<indexList.size(); i++) {	
        		int idx = indexList.get(i);	//회원의 행동 index를 가져와서
        		answer.set(idx, userName+answer.get(idx));	//이름을 더해서 다시 메시지 재세팅
        	}
        }
        
        return answer.stream().toArray(String[]::new); //리스트 배열 변환
    }
	
	public static void saveUserAction(String[] action) {	//행동 + 회원최종 이름 설정해주는 함수
		behavior = action[0];
		id = action[1];
		
		if(behavior.equals("Change")) {
			user.put(id, action[2]);	//회원이름 갱신
		}
		else {
			if(behavior.equals("Enter")) {
				user.put(id, action[2]);	//회원이름을 갱신 (회원 아이디, 회원 이름)
				behavior = "님이 들어왔습니다.";
			}else if (behavior.equals("Leave")) {
				behavior = "님이 나갔습니다.";
			}
			answer.add(behavior);	//행동 저장
			List<Integer> indexList = userRecodInfo.getOrDefault(id, new ArrayList<Integer>());
			indexList.add(answer.size()-1);	//기록 index를 저장한다.(어처피 순서대로 진행되니, list.size-1이 index 값)
			userRecodInfo.put(id, indexList);	//회원별 대화 인덱스에 저장한다.
		}
	}
	
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] result = solution(record);
		System.out.println(Arrays.toString(result));
	}

}
//[오픈채팅방] : 이 문제는 주어진 문자열 배열을 제시된 조건에 맞게 변환해서 반환하는 문제
/* 
  이 문제는 주어진 문자 배열 record를 각 입력 키워드에 맞는 행동으로 변환하며, 회원이 수정한 마지막 이름으로 전부 바꾸어 전체 채팅방 기록을 알맞게 변환해야하는 문제이다.
   처음에 보고 글이 많다보니 조금 헷갈렸지만 3가지 포인트에 집중해 생각해 문제를 해결했다.
   1. 회원은 id로 구분한다. = id라는 확실한 구분자가 있으니, 이름이 바뀌더라도 map을 통해 id의 value값을 변경해주면 최종 닉네임을 쉽게 정할 수 있을거라 생각했다.
   2. 회원의 행동은 3가지고 각 행동엔 규칙이 있다.(enter, leave, change) = record의 문자의 1번째에 행동이 나오고, enter,leave일 경우에만 메시지가 기록되며, enter, change일때 닉네임이 변경될 수 있다.
   3. record에 담긴 문자열을 총 100,000개가 가능하므로, 일일히 for문으로 다시 비교하면 시간 초과가 걸릴 것이다 = map과 list를 통해 id-이름, id-기록된 index 위치를 map에 저장해 빠르게 가져와 
      처음엔 기초 행동만 한글로 변환해 answer에 저장해두고, 그다음엔 각각 id를 key로 가져와 해당 id가 말한 index의 answer에 마지막으로 변환된 회원의 이름을 붙이면 속력이 개선되지 않을까 생각했다.
      
  위와 같은 3가지 포인트에 아래와 같은 알고리즘으로 문제를 해결했다.
  [1] 주어진 record의 크기만큼 for문으로 반복하며 
  	  초기 행동 -> 메시지 전환과, 이 행동으로 인해 변환되는 이름을 재설정하는 과정 (띄어쓰기로 구분되, split을 사용해 문자 배열로 변환)
  	  [ 들어온 문자의 행동 action[0]이 ] 
  	  [1-1] change라면 : 이름이 바뀐거니, user map에 .put으로 해당 id의 이름을 재설정해줬다. (이름 전환은 메시지가 없음)
  	  [1-2] Enter라면 : 들어올때 설정한 이름으로 .put으로 id의 이름을 재설정하며 / "님이 들어왔습니다."라고 행동을 설정
            Leave : 나간것은 이름변화는 없으니 / "님이 나갔습니다." 라고 행동을 설정
            -> 한 후, 해당 행동을 answer리스트에 저장한다 -> 저장된 위치를 회원별 메시지 index가 담긴 userRecodInfo에 .put해준다. (어처피 순서대로 넣으니, list.size-1이 해당 메시지의 index)
  [2] 1번을 통해 전체 record에 맞는 행동 문자 세팅과, 마지막 닉네임이 세팅 됬다면
      user의 key들을 가져와(iterator) 각 key에 맞는 id의 사람이 행동한 문자들이 담긴 index의 메시지들을 가져와
      이를 최종 닉네임을 더해 ("이름 + 님이 ~~습니다.")로 재 세팅해 다시 해당 idnex값에 .set으로 value를 변경해준다. == 마지막으로 변경된 이름으로 메시지를 세팅하는 과정
  [3] 그렇게 최종적으로 만들어진 요구사항을 모두 갖춘 문자열 리스트 answer을 
      list이니 stream을 통해 요구하는 문자열 배열로 변환해 return해줘 문제를 해결했다.
 */
 