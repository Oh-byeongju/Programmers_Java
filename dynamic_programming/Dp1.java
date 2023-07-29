// 23-07-29 자바 dp
package dynamic_programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Dp1 {
    public int solution(int N, int number) {
        // hashSet 담을 리스트 선언
        List<Set<Integer>> list = new ArrayList<>();

        // 리스트 초기화 (1 ~ 8까지 숫자의 갯수로 만들 수 있는 경우의수를 확인)
        for (int i = 0; i <= 8; i++) {
            list.add(new HashSet<>());
        }

        for (int i = 1; i <= 8; i++) {
            // 현재 hashSet 추출
            Set<Integer> current = list.get(i);

            // N을 그냥 이어붙인 케이스
            StringBuilder sb = new StringBuilder();
            for (int t = 0; t < i; t++) {
                sb.append(N);
            }
            current.add(Integer.parseInt(sb.toString()));

            // 이전 단계의 결과를 서로 사칙연산한 결과
            // [N을 1개 사용한 경우] 사칙연산 [i - 1개 사용한 경우]
            // [N을 2개 사용한 경우] 사칙연산 [i - 2개 사용한 경우]
            // 계속 진행
            for (int j = 1; j < i; j++) {
                for (int case1 : list.get(j)) {
                    for (int case2 : list.get(i - j)) {
                        current.add(case1 + case2);
                        current.add(case1 - case2);
                        current.add(case1 * case2);
                        // 0으로 나누기 예외처리
                        if (case2 != 0) {
                            current.add(case1 / case2);
                        }
                    }
                }
            }

            if (current.contains(number)) {
                return i;
            }
        }
        return -1;
    }
}