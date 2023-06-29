// 23-06-29 자바 구현
package implementation;

class Imple1 {
    boolean solution(String s) {
        // char 배열로 변경
        char [] arr = s.toCharArray();
        int cnt = 0;
        boolean answer = true;

        for (char c : arr) {
            // 닫힘 괄호가 시작인 경우
            if (c == ')' && cnt == 0) {
                answer = false;
                break;
            }

            // 열리는 괄호일경우 cnt 증가
            if (c == '(') {
                cnt++;
            }

            // 닫히는 괄호일경우 cnt 감소
            if (c == ')') {
                cnt--;
            }
        }

        // cnt가 0이 아니면 괄호가 마무리 안됐으니 false로 변환
        if (cnt != 0) {
            answer = false;
        }

        return answer;
    }
}