// 23-07-01 자바 BFS
package graph_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BFS1 {
    static ArrayList<ArrayList<Integer>> graph;

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
            int a = bfs(wire[0], wire[1], n);
            int b = bfs(wire[1], wire[0], n);

            answer = Math.min(answer, Math.abs(a - b));
        }

        return answer;
    }

    // bfs 메소드
    public int bfs(int v1, int v2, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];

        // 리턴할 카운트
        int cnt = 0;

        queue.add(v1);
        visit[v1] = true;

        while (!queue.isEmpty()) {
            // 현재 큐에서 값을 뽑은 뒤 cnt 증가
            int now = queue.poll();
            cnt++;

            // 현재 큐에서 뽑은 값의 노드를 기준으로 간선들 탐색
            for (int next : graph.get(now)) {
                // 선을 끊은곳이 아니면서 아직 탐색을 안했을경우
                if (next != v2 && !visit[next]) {
                    queue.add(next);
                    visit[next] = true;
                }
            }
        }
        return cnt;
    }
}