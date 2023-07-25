// 23-07-26 자바 구현
package implementation;

class Imple11 {
    public String solution(String new_id) {
        // 1단계
        String answer = new_id.toLowerCase();

        // 2단계
        char [] arr = answer.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }

        // 3단계
        answer = sb.toString();
        while (answer.contains("..")) {
            answer = answer.replace("..", ".");
        }

        // 4단계
        arr = answer.toCharArray();
        if (arr.length > 0 && arr[0] == '.') {
            arr[0] = ' ';
        }

        if (arr.length > 0 && arr[arr.length - 1] == '.') {
            arr[arr.length-1] = ' ';
        }

        sb = new StringBuilder();
        for (char c : arr) {
            if (c != ' ') {
                sb.append(c);
            }
        }

        // 5단계
        answer = sb.toString();
        if (answer.equals("")) {
            answer = "a";
        }

        // 6단계
        if (answer.length() > 15) {
            sb = new StringBuilder();

            for (int i = 0; i < 15; i++) {
                if (i == 14 && answer.charAt(i) == '.') {
                    continue;
                }
                sb.append(answer.charAt(i));
            }
            answer = sb.toString();
        }

        // 7단계
        while (answer.length() < 3) {
            answer = answer + answer.charAt(answer.length()-1);
        }

        return answer;
    }
}