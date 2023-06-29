// 23-06-30 자바 정렬
package sort;

import java.util.Arrays;

class Sort1 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            // 슬라이스할 배열 선언
            int [] temp = new int[commands[i][1] - commands[i][0] + 1];
            int index = 0;

            // 배열 슬라이스
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                temp[index] = array[j];
                index++;
            }

            // 정렬 후 결과값 할당
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] - 1];
        }
        return answer;
    }
}