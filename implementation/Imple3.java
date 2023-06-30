// 23-06-30 자바 구현
package implementation;

class Imple3 {
    public int solution(int[][] sizes) {
        // 가로 세로중 긴길이와 짧은 길이를 다른 배열로 구분
        int [] high_cm = new int[sizes.length];
        int [] low_cm = new int[sizes.length];
        int high = 0;
        int low = 0;

        for (int i = 0; i < sizes.length; i++) {
            high = Math.max(sizes[i][0], sizes[i][1]);
            low = Math.min(sizes[i][0], sizes[i][1]);
            high_cm[i] = high;
            low_cm[i] = low;
        }

        // 가로 세로 배열중 제일 큰값을 찾은 뒤 곱하고 리턴
        for (int i = 0; i < high_cm.length; i++) {
            high = Math.max(high, high_cm[i]);
            low = Math.max(low, low_cm[i]);
        }

        return high * low;
    }
}