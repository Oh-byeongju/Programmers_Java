// 23-07-25 자바 스택
package stack_queue;

import java.util.Stack;

class Stack3 {
    public int[] solution(int[] numbers) {
        // number index 정보를 담을 스택 생성
        Stack<Integer> stack = new Stack<>();

        int[] answer = new int[numbers.length];

        // 첫 번째 number 인덱스 stack에 push
        stack.push(0);

        // 두 번째 인덱스부터 시작
        for (int i = 1; i < numbers.length; i++) {

            // stack에 값이 있고 그 값(인덱스)이 현재 값보다 작은 경우 뒷큰수가 됨
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }

            // 현재 index push
            stack.push(i);
        }

        // 스택안에 있는 index는 뒷큰수가 없는 수
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        return answer;
    }
}