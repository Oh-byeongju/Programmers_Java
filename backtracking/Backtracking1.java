// 23-06-30 자바 백트래킹, 소수처리
package backtracking;

import java.util.ArrayList;

class Backtracking1 {
    static char [] result;
    static boolean [] visit;
    static ArrayList<Integer> nums = new ArrayList<>();
    static StringBuilder sb;

    public int solution(String numbers) {
        // 소수 확인 배열 (true면 소수 아님 false면 소수)
        boolean [] check = new boolean[10000000];
        check[0] = true;
        check[1] = true;

        // 2를 제외한 모든 짝수 예외처리
        for (int i = 4; i <= 9999998; i += 2) {
            check[i] = true;
        }

        // 특정 홀수 예외처리
        for (int i = 3; i <= 9999999; i += 2) {
            // 현재수가 소수로 판단될경우 현재수의 배수들을 전부 소수가 아닌수로 처리
            if (!check[i]) {
                for (int j = i + i; j <= 9999999; j += i) {
                    check[j] = true;
                }
            }
        }

        // String을 char로 변환
        char [] arr = numbers.toCharArray();

        // 모든 자릿수의 숫자를 구해서 List에 담는 반복문
        for (int i = 0; i < arr.length; i++) {
            result = new char[i+1];
            visit = new boolean[arr.length];
            dfs(arr, arr.length,i + 1, 0);
        }

        // List안에 값들이 소수인지 판단 후 결과값 가공
        int answer = 0;
        for (Integer num : nums){
            if (!check[num]) {
                answer++;
            }
        }

        return answer;
    }

    // 백트래킹을 이용한 숫자 만드는 메소드
    public void dfs(char [] arr, int end, int length, int depth) {
        // 자릿수 완성이 됐을 경우
        if (length == depth) {
            // 현재 만들어진 숫자를 배열에 넣음 (존재 여부도 확인)
            sb = new StringBuilder();
            for (char word : result) {
                sb.append(word);
            }

            int temp = Integer.parseInt(sb.toString());
            if (!nums.contains(temp)) {
                nums.add(temp);
            }
            return;
        }

        for (int i = 0; i < end; i++) {
            // 현재 숫자를 사용하지 않았을경우
            if (!visit[i]) {
                visit[i] = true;
                result[depth] = arr[i];
                dfs(arr, end, length, depth + 1);
                visit[i] = false;
            }
        }
    }
}