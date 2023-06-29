// 23-06-30 자바 우선순위 큐
package heap;

import java.util.PriorityQueue;

class PriorityQueue1 {
    public int solution(int[] scoville, int K) {
        // 낮은 숫자가 우선 순위인 int 형 우선순위 큐 선언(오름차순)
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // 높은 숫자가 우선 순위인 int 형 우선순위 큐 선언(내림차순)
        // PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        // 큐에 모든값 넣기
        for (int num : scoville) {
            queue.offer(num);
        }

        int answer = 0;

        // K 이상 될 때까지 반복
        while (queue.peek() < K && queue.size() > 1) {
            // 처음과 두번째 수 뽑고 연산 후 큐에 넣기
            int A = queue.poll();
            int B = queue.poll();
            queue.offer(A + (B * 2));
            answer++;
        }

        // 스코빌 지수 갱신실패 시
        if (queue.peek() < K) {
            answer = -1;
        }

        return answer;
    }
}