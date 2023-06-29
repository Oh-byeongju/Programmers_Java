// 23-06-30 자바 정렬
package sort;

import java.util.Arrays;
import java.util.Comparator;

class Sort2 {
    public String solution(int[] numbers) {
        String [] arr = new String[numbers.length];

        // 스트링 배열로 변환
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        // 스트링을 사전순으로 정렬하는 메소드
        // 정렬 시 비교할 문자가 o1와 o2라면 o1+o2와 o2+o1를 비교한 뒤에 더 큰 수를 반환해줘야 한다.
        // ex) o1 = 3, o2 = 30 -> 330 vs 303을 비교하는 것처럼 말이다.
        // (o2+o1).compareTo(o1+o2) 이 식은 내림차순으로 정렬하겠다는 의미다.
        // o2가 먼저인지 o1이 먼저인지에 따라 오름차순, 내림차순이 결정됨
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        // 예외처리
        if (arr[0].equals("0")) {
            return "0";
        }

        // 결과값 가공
        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            sb.append(str);
        }

        return sb.toString();
    }
}