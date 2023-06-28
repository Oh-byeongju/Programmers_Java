// 23-06-28 자바 큐
package stack_queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Queue1 {
    public static void main(String[] args) {
        Queue1 solution = new Queue1();
        int[] result = solution.solution(new int[]{97, 98, 95, 94, 96}, new int[]{1, 1, 1, 1, 1});
        System.out.println(Arrays.toString(result));
    }

    public int[] solution(int[] progresses, int[] speeds) {
        // 변수 선언
        int day = 1;
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();

        // 전체 배열 반복(출발점은 계속 바뀜)
        for (int i = 0; i < progresses.length; i += count) {
            count = 0;

            // 현재 기능이 작업이 완료된경우를 판단
            while (progresses[i] + (speeds[i] * day) < 100) {
                day = day + 1;
            }

            // 완료된 기능들 추출
            for (int j = i; j < progresses.length; j++) {
                // 조건이 맞는 경우 count
                if (progresses[j] + (speeds[j] * day) >= 100) {
                    count++;
                } else {
                    break;
                }
            }
            // 현재 count 삽입
            queue.offer(count);
        }

        // 결과값 가공
        int[] answer = new int[queue.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = queue.poll();
        }

        return answer;
    }
}
