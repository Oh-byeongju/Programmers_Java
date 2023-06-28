// 23-06-25 자바 해시셋
package hash;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

class HashSet2 {
    public boolean solution(String[] phone_book) {
        // 입력한 값들을 길이가 짧은 순서부터 출력하기 위해 오름차순 정렬
        Arrays.sort(phone_book, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();   // 이부분 바꾸면 내림차순됨
            }
        });

        // HashSet 선언
        HashSet<String> set = new HashSet<>();

        boolean answer = true;

        // 전체 배열 반복
        for (String str : phone_book) {
            // 문자열 슬라이스 후 검색
            for (int i = 1; i <= str.length(); i++) {
                if (set.contains(str.substring(0, i))) {
                    answer = false;
                }
            }
            set.add(str);
        }

        return answer;
    }
}