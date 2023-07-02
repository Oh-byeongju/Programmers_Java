// 23-07-02 자바 그리디
package greedy;

class Greedy1 {
    public int solution(int n, int[] lost, int[] reserve) {
        // -1 도난, 0 도난도 없고 여벌도 없고, 1 여벌
        // 반복문 index 초과 방지를 위해 배열 크기를 2개 크게함
        int [] arr = new int[n+2];

        // 배열값 초기화
        for (int i = 0; i < lost.length; i++) {
            arr[lost[i]]--;
        }
        for (int i = 0; i < reserve.length; i++) {
            arr[reserve[i]]++;
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            // 수업을 들을 수 있는경우 cnt 증가
            if (arr[i] == 0 || arr[i] == 1) {
                answer++;
            }
            // 도난 당한 경우 앞뒤 학생의 여벌옷을 확인
            else {
                if (arr[i-1] == 1) {
                    arr[i-1] = 0;
                    arr[i] = 0;
                    answer++;
                }
                else if(arr[i+1] == 1) {
                    arr[i+1] = 0;
                    arr[i] = 0;
                    answer++;
                }
            }
        }
        return answer;
    }
}