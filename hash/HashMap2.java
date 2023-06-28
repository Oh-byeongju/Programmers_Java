// 23-06-25 자바 해시맵
package hash;

import java.util.HashMap;

class HashMap2 {
    public int solution(String[][] clothes) {
        // HashMap 선언
        HashMap <String, Integer> map = new HashMap<>();

        // 전체 배열 반복
        for (int i = 0; i < clothes.length; i++) {
            // 현재 map안에 값이 없을 경우
            if (!map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], 1);
            }
            else {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            }
        }

        int answer = 1;

        // 경우의 수가 상의 2개 하의 3개가 있으면
        // 상의는 1번입기, 2번입기, 안입기
        // 하의는 1번입기, 2번입기, 3번입기, 안입기가 나오므로
        // 현재 값에서 1씩 더한다음 곱하기 해주면 됨
        // 하지만 다 벗으면 안되니깐 마지막에 -1 하기
        for (String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }

        return answer - 1;
    }
}