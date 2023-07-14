// 23-07-14 자바 구현
package implementation;

import java.util.LinkedList;
import java.util.Queue;

class Imple9 {
    public int solution(String dartResult) {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb;
        int before = 0;
        int now = 0;
        int answer = 0;

        for (int i = 0; i < dartResult.length(); i++) {
            // 싱글 케이스
            if (dartResult.charAt(i) == 'S') {
                // 큐에 담긴 숫자를 추출
                sb = new StringBuilder();
                while (!queue.isEmpty()) {
                    sb.append(queue.poll());
                }

                // 이전값 저장 후 현재값 더하기
                before = now;
                now = Integer.parseInt(sb.toString());

                // 제곱없이 그냥 더하기
                answer += now;
                continue;
            }

            // 더블 케이스
            if (dartResult.charAt(i) == 'D') {
                // 큐에 담긴 숫자를 추출
                sb = new StringBuilder();
                while (!queue.isEmpty()) {
                    sb.append(queue.poll());
                }

                // 이전값 저장 후 현재값 더하기
                before = now;
                // 제곱 후 더하기
                now = Integer.parseInt(sb.toString()) * Integer.parseInt(sb.toString());
                answer += now;
                continue;
            }

            // 트리플 케이스
            if (dartResult.charAt(i) == 'T') {
                // 큐에 담긴 숫자를 추출
                sb = new StringBuilder();
                while (!queue.isEmpty()) {
                    sb.append(queue.poll());
                }

                // 이전값 저장 후 현재값 더하기
                before = now;
                // 세 제곱 후 더하기
                now = Integer.parseInt(sb.toString()) * Integer.parseInt(sb.toString()) * Integer.parseInt(sb.toString());
                answer += now;
                continue;
            }

            // 스타상인 경우 이전값과 현재값 한번 더 더하고 현재값 갱신
            if (dartResult.charAt(i) == '*') {
                answer += before;
                answer += now;
                now = now + now;
                continue;
            }

            // 아차상일 경우 빼기 후 현재값 마이너스 처리하기
            if (dartResult.charAt(i) == '#') {
                answer -= (now * 2);
                now = now - (now * 2);
                continue;
            }

            // 숫자면 queue에 숫자 삽입
            queue.offer(Integer.parseInt(String.valueOf(dartResult.charAt(i))));
        }
        return answer;
    }
}