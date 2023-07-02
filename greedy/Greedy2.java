// 23-07-02 자바 그리디
package greedy;

class Greedy2 {
    public int solution(String name) {
        int answer = 0;
        int index = 0;
        int move = name.length() - 1;  // 좌우 움직임 수 최초값(오른쪽으로 쭉간 횟수)

        for(int i = 0; i < name.length(); i++) {
            // 상하 움직임의 최소값을 구함
            // 초기값이 A로만 이루어져있기 때문에 글자에서 상하값을 구한 뒤 최소값 더하기
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            // 현재 인덱스 이후로 연속되는 A 갯수 확인
            // 다음값이 A가 아닐 경우 while문이 멈춤
            // 이값은 추후 좌우 움직임 계산을 할때 사용
            index = i + 1;
            while(index < name.length() && name.charAt(index) == 'A') {
                index++;
            }

            // 좌우 움직임의 최소값 구하는 법
            // 연속된 A의 값을 제거 후 생각
            // 순서대로 가는 것과, 뒤로 돌아가는 것 중 이동수가 적은 것을 선택
            // ex) ZYXAAAAAB --> YXYZB순이냐 BZYX순이냐를 판단
            // (i * 2) => 연속된 A문자열이 시작하기 전까지 갔다가 되돌아옴
            // (name.length() - index) * 2 => 연속된 A문자열이 끝나는곳까지 갔다가 되돌아옴

            // 오른쪽으로 갔다가 다시 왼쪽으로 가는 것
            move = Math.min(move, (i * 2) + name.length() - index);
            // 왼쪽으로 갔다가 다시 오른쪽으로 가는 것
            move = Math.min(move, (name.length() - index) * 2 + i);
        }
        return answer + move;
    }
}