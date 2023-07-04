// 23-07-04 자바 구현
package implementation;

class Imple6 {
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();

        // 첫번째 배열 인덱스부터 반복
        for (int i = 1; i < numLog.length; i++) {
            // 1을 더한 경우
            if (numLog[i-1] + 1 == numLog[i]) {
                sb.append("w");
            }

            // 1을 뺀 경우
            if (numLog[i-1] - 1 == numLog[i]) {
                sb.append("s");
            }

            // 10을 더한 경우
            if (numLog[i-1] + 10 == numLog[i]) {
                sb.append("d");
            }

            // 10을 뺀 경우
            if (numLog[i-1] - 10 == numLog[i]) {
                sb.append("a");
            }
        }
        return sb.toString();
    }
}