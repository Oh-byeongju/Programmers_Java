// 23-07-25 자바 스택
package stack_queue;

import java.util.Stack;

class Stack2 {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        // 이동 수 만큼 반복
        for (int num : moves) {
            // 현재 크레인의 위치에서 바닥까지 검사
            for (int i = 0; i < board.length; i++) {
                // 인형이 존재할경우
                if (board[i][num-1] != 0) {
                    // 스택이 비었을 경우 바로 push
                    if (stack.isEmpty()) {
                        stack.push(board[i][num-1]);
                    }
                    else {
                        // 스택의 제일 위의값이랑 현재 크레인이 뽑은 값이랑 같은경우
                        if (stack.peek().equals(board[i][num-1])) {
                            answer += 2;
                            stack.pop();
                        }
                        else {
                            stack.push(board[i][num-1]);
                        }
                    }
                    // 배열값 변경 후 break
                    board[i][num-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}