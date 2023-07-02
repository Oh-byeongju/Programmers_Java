// 23-07-02 자바 백트래킹
package backtracking;

class Backtracking3 {
    static char [] temp = new char[5];
    static int result = 0;
    static int cnt = 0;

    public int solution(String word) {
        // A,E,I,O,U가 들어간 배열 선언
        char [] arr = new char[]{'A', 'E', 'I', 'O', 'U'};
        // 재귀함수 호출
        recur(arr, 0, word);

        return result;
    }

    public static void recur(char [] arr, int depth, String word) {
        // 6글자가 넘어갈경우 return
        if (depth == 5) {
            return;
        }

        // 중복을 허용하고 백트래킹 실행
        for (int i = 0; i < arr.length; i++) {
            cnt++;
            temp[depth] = arr[i];

            // 현재 배열의 글자가 매개변수 글자랑 같은경우 result에 값 할당
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < depth + 1; j++) {
                sb.append(temp[j]);
            }
            if (word.equals(sb.toString())) {
                result = cnt;
            }

            recur(arr, depth + 1, word);
        }
    }
}