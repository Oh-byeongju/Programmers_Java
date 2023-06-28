// 23-06-25 자바 해시셋
package hash;

import java.util.HashSet;

public class HashSet1 {
    public int solution(int[] nums) {
        // HashSet 선언
        HashSet<Integer> set = new HashSet<>();

        // 리스트를 HashSet으로 변환
        for (int num : nums) {
            set.add(num);
        }

        // 결과값 가공
        int answer = 0;
        int nums_size = nums.length / 2;

        if (set.size() > nums_size) {
            answer = nums_size;
        }
        else {
            answer = set.size();
        }

        return answer;
    }
}