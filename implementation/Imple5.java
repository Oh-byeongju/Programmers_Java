// 23-06-30 자바 구현
package implementation;

class Imple5 {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        int[] answer = new int[2];

        for (int i = 1; i <= sum; i++) {
            // sum의 약수가 아닌 반복문은 continue
            if (sum % i != 0) {
                continue;
            }

            // 가로, 세로 할당
            int width = i;
            int height = sum / i;

            // 문제의 조건이 맞을경우 답을 할당 후 break
            // 노란색 격자의 구간은 (width - 2) * (height - 2) 의 값임
            if (width >= height && ((width - 2) * (height - 2)) == yellow) {
                answer[0] = width;
                answer[1] = height;
                break;
            }
        }
        return answer;
    }
}