// 23-07-03 자바 그리디
package greedy;

import java.util.ArrayList;

class Greedy3 {
    public String solution(String number, int k) {
        // String을 int 배열로 변환
        int [] arr = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(number.charAt(i)));
        }

        // 정답 List 및 index
        ArrayList<Integer> result = new ArrayList<>();
        int index = 0;
        int max_num = 0;

        for (int i = 0; i < arr.length - k; i++) {
            max_num = 0;

            // 선택할 수 있는 범위의 수들중 가장 큰 수를 구함
            for (int j = index; j <= k + i; j++) {
                if (max_num < arr[j]) {
                    max_num = arr[j];
                    index = j + 1;
                }
            }
            result.add(max_num);
        }

        // 결과값 가공
        StringBuilder sb = new StringBuilder();
        for (Integer num : result) {
            sb.append(num);
        }
        return sb.toString();
    }
}