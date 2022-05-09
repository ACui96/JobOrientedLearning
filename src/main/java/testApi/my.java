package testApi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Acui
 * @date 2022年05月01日 17:09
 */
public class my {
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            wordList.add(beginWord);
            int N = wordList.size();
            int start = N - 1;
            int end = 0;
            while (end < N && !wordList.get(end).equals(endWord)) {
                end++;
            }
            if (end == N) {
                return 0;
            }
            List<Integer>[] graphic = buildGraphic(wordList);
            return getShortestPath(graphic, start, end);
        }

        private List<Integer>[] buildGraphic(List<String> wordList) {
            int N = wordList.size();
            List<Integer>[] graphic = new List[N];
            for (int i = 0; i < N; i++) {
                graphic[i] = new ArrayList<>();
                for (int j = 0; j < N; j++) {
                    if (isConnected(wordList.get(i), wordList.get(j))) {
                        graphic[i].add(j);
                    }
                }
            }
            return graphic;
        }

        private boolean isConnected(String s1, String s2) {
            int diffCnt = 0;
            for (int i = 0; i < s1.length() && diffCnt <= 1; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    diffCnt++;
                }
            }
            return diffCnt == 1;
        }

        private int getShortestPath(List<Integer>[] graphic, int start, int end) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] marked = new boolean[graphic.length];
            queue.add(start);
            marked[start] = true;
            int pathLenth = 1;
            while (!queue.isEmpty()) {
                pathLenth++;
                int size = queue.size();
                while (size-- > 0) {
                    int cur = queue.poll();
                    for (int next : graphic[cur]) {
                        if (next == end){
                            return pathLenth;
                        }
                        if (marked[next]) {
                            continue;
                        }
                        queue.add(next);
                        marked[next] = true;
                    }
                }
            }
            return 0;

        }
    }
}
