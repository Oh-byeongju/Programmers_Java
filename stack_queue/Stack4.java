// 23-07-28 자바 스택
package stack_queue;

import java.util.Stack;

class Stack4 {
    public int solution(int[] ingredient) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for (int num : ingredient) {
            // 값 삽입
            stack.push(num);

            // 스택안에 재료가 4개 이상 들어간 경우
            if (stack.size() >= 4) {

                // 햄버거 순서가 완성되면 4번 pop후 answer값 증가
                if (stack.get(stack.size() - 4) == 1
                        && stack.get(stack.size() - 3) == 2
                        && stack.get(stack.size() - 2) == 3
                        && stack.get(stack.size() - 1) == 1) {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    answer++;
                }
            }
        }
        return answer;
    }
}