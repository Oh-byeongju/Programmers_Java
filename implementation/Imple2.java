// 23-06-29 자바 구현
package implementation;

import java.util.LinkedList;
import java.util.Queue;

class Imple2 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 변수 선언
        Queue<int []> queue = new LinkedList<>();
        int sum_weight = truck_weights[0];
        int index = 1;
        int loop_num = 1;
        queue.offer(new int[]{truck_weights[0], bridge_length});

        // 모든 트럭이 통과할때 까지 반복
        while(!queue.isEmpty()) {
            // 트럭이 다리를 다 건넜을경우
            if (queue.peek()[1] == loop_num) {
                int [] temp = queue.poll();
                sum_weight -= temp[0];
            }

            // 다리에 트럭이 올라갈 수 있는경우(큐에 삽입)
            if (index < truck_weights.length && weight >= sum_weight + truck_weights[index]) {
                queue.offer(new int[]{truck_weights[index], loop_num + bridge_length});
                sum_weight += truck_weights[index];
                index++;
            }
            loop_num++;
        }

        return loop_num;
    }
}