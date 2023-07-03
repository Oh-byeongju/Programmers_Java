// 23-07-03 자바 그리디
package greedy;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Greedy4 {
    public int solution(int[] people, int limit) {
        Deque<Integer> deque = new LinkedList<>();
        int answer = 0;

        // 리스트를 오름차순으로 정렬 후 데크로 변환
        Arrays.sort(people);
        for (int num : people) {
            deque.offerLast(num);
        }

        while(!deque.isEmpty()) {
            // 현재 보트에 탑한 사람들의 무게 및 인원
            int temp = 0;
            int people_num = 0;

            // 무거운 인원을 태울 수 있을때까지 반복
            while(!deque.isEmpty() && deque.peekLast() + temp <= limit && people_num < 2) {
                temp += deque.pollLast();
                people_num++;
            }

            // 가벼운 인원을 태울 수 있을때까지 반복
            while(!deque.isEmpty() && deque.peekFirst() + temp <= limit && people_num < 2) {
                temp += deque.pollFirst();
                people_num++;
            }
            answer++;
        }

        return answer;
    }
}