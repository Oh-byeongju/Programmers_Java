// 23-07-30 자바 해시맵
package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class HahsMap3 {
    public int[] solution(String msg) {
        HashMap<String, Integer> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        // A ~ Z까지 map에 삽입
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf((char) (65 + i)), i + 1);
        }

        // 문자열을 큐에 삽입
        for (int i = 0; i < msg.length(); i++) {
            queue.add(msg.charAt(i));
        }

        // 추가할 인덱스 값
        int index = 27;

        // 큐가 빌때까지 반복
        while (!queue.isEmpty()) {
            StringBuilder sb = new StringBuilder();

            // 현재 사전 기준으로 최대한 긴 단어를 검색
            while (!queue.isEmpty() && map.containsKey(sb.toString() + queue.peek())) {
                sb.append(queue.poll());
            }

            // 제일 긴 단어의 인덱스 list에 추가
            list.add(map.get(sb.toString()));

            // 다음 글자가 남았으면 단어사전에 새롭게 추가
            if (!queue.isEmpty()) {
                map.put(sb.toString() + queue.peek(), index);
            }

            // 인덱스 값 증가
            index++;
        }

        // 결과값 가공
        int [] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}