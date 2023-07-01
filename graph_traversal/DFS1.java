// 23-07-01 자바 DFS
package graph_traversal;

import java.util.ArrayList;

class DFS1 {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean [] visit;
    static int cnt, a, b;

    public int solution(int n, int[][] wires) {
        // 그래프 선언 및 초기화
        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Integer>());
        }

        // 그래프값 입력
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        int answer = 100;

        // 특정 전선을 끊은 기준으로 값을 구함
        // 모든 노드를 기준으로 탐색을 한뒤 최소값을 계산하면됨
        for (int[] wire : wires) {
            visit = new boolean[n + 1];
            // a값 초기화
            a = 0;
            cnt = 0;
            dfs1(wire[0], wire[1]);

            // b값 초기화
            cnt = 0;
            b = 0;
            dfs2(wire[1], wire[0]);

            answer = Math.min(answer, Math.abs(a - b));
        }

        return answer;
    }

    // dfs 메소드(a 기준)
    public void dfs1(int v1, int v2) {
        visit[v1] = true;
        cnt++;
        a = Math.max(a, cnt);

        for (int next : graph.get(v1)) {
            if (next != v2 && !visit[next]) {
                dfs1(next, v2);
            }
        }
    }

    // dfs 메소드(b 기준)
    public void dfs2(int v1, int v2) {
        visit[v1] = true;
        cnt++;
        b = Math.max(b, cnt);

        for (int next : graph.get(v1)) {
            if (next != v2 && !visit[next]) {
                dfs2(next, v2);
            }
        }
    }
}