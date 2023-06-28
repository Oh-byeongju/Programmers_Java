// 23-06-25 자바 해시맵
package hash;

import java.util.HashMap;

public class HashMap1 {
    public String solution(String[] participant, String[] completion) {
        // 완주자들 HashMap으로 변환
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : completion) {
            // HahsMap에 이미 들어가있으면 동명이인이니깐 카운트를 올림
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            }
            else {
                map.put(str, 1);
            }
        }

        String answer = "";

        // 참가자들 기준으로 검색
        for (String str : participant) {
            // 키가 없거나 카운트를 전부 소진한 경우
            if (!map.containsKey(str) || map.get(str) == 0) {
                answer = str;
                break;
            }

            // HashMap 값 갱신
            map.put(str, map.get(str) - 1);
        }
        return answer;
    }
}