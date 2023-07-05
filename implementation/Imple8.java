// 23-07-06 자바 구현
package implementation;

class Imple8 {
    public int solution(String[] babbling) {
        int answer = 0;

        for (int i = 0; i < babbling.length; i++) {
            babbling[i] = babbling[i].replaceFirst("aya", "1");
            babbling[i] = babbling[i].replaceFirst("woo", "1");
            babbling[i] = babbling[i].replaceFirst("ye", "1");
            babbling[i] = babbling[i].replaceFirst("ma", "1");
            babbling[i] = babbling[i].replace("1", "");

            if (babbling[i].equals("")) {
                answer++;
            }
        }

        return answer;
    }
}