// 23-07-25 자바 구현
package implementation;

class Imple10 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        // 전체 배열 반복하면서 true면 더하고 false면 빼기
        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            }
            else {
                answer -= absolutes[i];
            }
        }

        return answer;
    }
}