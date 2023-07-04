// 23-07-05 자바 구현
package implementation;

class Imple7 {
    public int solution(int[] numbers) {
        // 0 ~ 9 까지 true, false 체크할 배열 선언
        boolean [] checks = new boolean[10];

        // 숫자가 존재하면 true로 변경
        for (int num : numbers) {
            checks[num] = true;
        }

        // true가 아닌 값들을 더한 뒤 리턴
        int answer = 0;
        for (int i = 0; i < checks.length; i++) {
            if (!checks[i]) {
                answer += i;
            }
        }

        return answer;
    }
}