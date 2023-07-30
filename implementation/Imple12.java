// 23-07-30 자바 구현
package implementation;

class Imple12 {
    public int solution(int n) {
        // 매개변수의 2진수 값을 추출 후 1의 개수를 구함
        String temp = Integer.toBinaryString(n);
        int temp_num = 0;

        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == '1') {
                temp_num++;
            }
        }

        int answer = 0;

        // 다음 큰 숫자가 나올때 까지 반복문 돌림
        for (int i = n + 1; i < 1000001; i++) {
            int temp_num2 = 0;
            temp = Integer.toBinaryString(i);

            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '1') {
                    temp_num2++;
                }
            }

            // 다음 큰수를 찾으면 break 후 값 할당
            if (temp_num == temp_num2) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}