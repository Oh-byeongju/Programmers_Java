// 23-07-01 자바 백트래킹
package backtracking;

import java.util.Arrays;
import java.util.Comparator;

class Backtracking2 {
    static int answer = 0;
    static int cnt = 0;
    static boolean [] visit;

    public int solution(int k, int[][] dungeons) {
        // 던전을 한번이라도 돌기 위해 배열을 오름차순으로 정렬(최소 피로도가 같은 경우 소모 피로도를 기준으로함)
        Arrays.sort(dungeons, new Comparator<int []>() {
            @Override
            public int compare(int [] o1, int [] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        visit = new boolean[dungeons.length];
        dfs(k, dungeons);

        return answer;
    }

    public static void dfs(int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            // 던전을 돌지 못하는경우 최대값 갱신 후 return
            if (k < dungeons[i][0]) {
                answer = Math.max(answer, cnt);
                return;
            }
            // 방문 기록이 없을경우
            if (!visit[i]) {
                visit[i] = true;
                cnt++;
                dfs(k - dungeons[i][1], dungeons);
                cnt--;
                visit[i] = false;
            }
        }
    }
}