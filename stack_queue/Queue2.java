// 23-06-29 자바 큐
package stack_queue;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Queue2 {
    public int solution(int[] priorities, int location) {
        // 큐 선언
        Queue<int[]> queue = new LinkedList<>();

        // 큐에 우선도와 배열의 순서를 넣음
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{priorities[i], i});
        }

        // 형변환 후 우선도를 내림차순으로 정렬
        Integer[] arr = new Integer[priorities.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = priorities[i];
        }
        Arrays.sort(arr, Collections.reverseOrder());
        // 우선도의 index
        int index = 0;

        // 반복문 시작
        while (true) {
            int[] tmp = queue.poll();

            // 큐에서 뽑은 우선도값과 현재 우선도의 값이 같은경우
            if (tmp[0] == arr[index]) {
                index++;
                // 구하려는 프로세스의 값인경우 break
                if (tmp[1] == location) {
                    break;
                }
            } else {
                queue.offer(tmp);
            }
        }
        return index;
    }
}