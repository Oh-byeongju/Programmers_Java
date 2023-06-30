// 23-06-30 자바 정렬
package sort;

import java.util.Arrays;

class Sort3 {
    public int solution(int[] citations) {
        // 배열을 오름차순으로 정렬
        Arrays.sort(citations);

        int answer = 0;

        for (int i = 0; i < citations.length; i++) {
            // h가 될수있는 최대값
            int max_num = Math.min(citations.length - i, citations[i]);

            // 나머지 논문이 h번 이하 인용되었다면 결과값 갱신
            if (i <= max_num) {
                answer = Math.max(answer, max_num);
            }
        }
        return answer;
    }
}