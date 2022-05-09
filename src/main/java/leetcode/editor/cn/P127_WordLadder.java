//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列： 
//
// 
// 序列中第一个单词是 beginWord 。 
// 序列中最后一个单词是 endWord 。 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典 wordList 中的单词。 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中
//的 单词数目 。如果不存在这样的转换序列，返回 0。 
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
// Related Topics 广度优先搜索 哈希表 字符串 
// 👍 816 👎 0


package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.*;

public class P127_WordLadder {
    public static void main(String[] args) {
        Solution solution = new P127_WordLadder ().new Solution();
        // TO TEST
        String beginWord =  "hit";
        String endWord =  "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));

        System.out.println(solution.ladderLength(beginWord, endWord, wordList));

    }
    //Java：单词接龙
    //leetcode submit region begin(Prohibit modification and deletion)
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
            List<Integer>[] graphic = buildGraph(wordList);
            return findShortestPath(graphic, start, end);
        }

        private List<Integer>[] buildGraph(List<String> wordList) {
            int N = wordList.size();
            List<Integer>[] graphic = new List[N];
            for (int i = 0; i < N; i++) {
                graphic[i] = new ArrayList<>();
                for (int j = 0; j < N; j++) {
                    if (isConnect(wordList.get(i), wordList.get(j))) {
                        graphic[i].add(j);
                    }
                }
            }
            return graphic;
        }

        private boolean isConnect(String s1, String s2) {
            int diffCnt = 0;
            for (int i = 0; i < s1.length() && diffCnt <= 1; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    diffCnt++;
                }
            }
            return diffCnt ==  1;
        }

        private int findShortestPath(List<Integer>[] graphic, int start, int end) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] marked = new boolean[graphic.length];
            queue.add(start);
            marked[start] = true;
            int path = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                path++;
                while (size-- > 0) {
                    int cur = queue.poll();
                    for (int next : graphic[cur]) {
                        if (next == end) {
                            return path;
                        }
                        if (marked[next]) {
                            continue;
                        }
//                        queue.add(next);
                        marked[next] = true;
                        queue.add(next);
                    }
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

