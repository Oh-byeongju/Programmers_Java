// 23-06-30 자바 구현
package implementation;

import java.util.ArrayList;

class Imple4 {
    public int[] solution(int[] answers) {
        // 정답을 찍는 순서에 맞춰서 배열 생성 및 정답 카운트 선언
        int [] one = new int[]{1, 2, 3, 4, 5};
        int [] two = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int [] three = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int one_cnt = 0;
        int two_cnt = 0;
        int three_cnt = 0;

        // 전체 정답 반복
        for (int i = 0; i < answers.length; i++) {
            // 1번 수포자가 정답인경우
            if (answers[i] == one[i % 5]) {
                one_cnt++;
            }

            // 2번 수포자가 정답인경우
            if (answers[i] == two[i % 8]) {
                two_cnt++;
            }

            // 3번 수포자가 정답인경우
            if (answers[i] == three[i % 10]) {
                three_cnt++;
            }
        }

        // 최대값 추출 후 결과값 가공
        int max_num = Math.max(three_cnt, Math.max(one_cnt, two_cnt));

        ArrayList<Integer> list = new ArrayList<>();
        if (one_cnt == max_num) {
            list.add(1);
        }
        if (two_cnt == max_num) {
            list.add(2);
        }
        if (three_cnt == max_num) {
            list.add(3);
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}