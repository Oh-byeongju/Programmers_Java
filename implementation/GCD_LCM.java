// 23-07-02 자바 구현
package implementation;

class GCD_LCM {
    public int[] solution(int n, int m) {
        int a = GCD(n, m);
        int b = LCM(n, m);
        int[] answer = {a, b};
        return answer;
    }

    // 최대 공약수 유클리드 호제법
    // 재귀함수를 이용한 방법
    public int GCD(int a, int b) {
        // b가 0일경우 a가 최대공약수임
        if (b == 0) {
            return a;
        }
        else {
            // b값을 매개변수 a로 넣고, 매개변수 b에는 a % b를 매개변수로 주기
            return GCD(b, a % b);
        }
    }

    // 최소공배수는 두 값을 곱한다음 최대공약수로 나누면 됨
    public int LCM(int a, int b) {
        return a * b / GCD(a, b);
    }
}