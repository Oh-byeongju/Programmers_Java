// 23-06-26 자바 스택
package stack_queue;

import java.util.Stack;

public class Stack1 {
    public int[] solution(int []arr) {
        // 스택 선언
        Stack<Integer> stack = new Stack<>();

        // 배열을 스택으로 변환
        for (Integer num : arr) {
            // 스택이 비었을경우 바로 값을 삽입
            if (stack.isEmpty()) {
                stack.push(num);
            }
            else {
                // 스택의 제일 위의 값과 현재값이 다를 경우 스택에 삽입
                if (!stack.peek().equals(num)) {
                    stack.push(num);
                }
            }
        }

        // 리턴할 배열 및 반복문 size
        int [] answer = new int[stack.size()];
        int size = stack.size() - 1;

        // 스택을 배열로 변환
        for (int i = size; i >= 0; i--) {
            answer[i] = stack.pop();
        }
        return answer;
    }
}