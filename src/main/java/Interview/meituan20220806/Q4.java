package Interview.meituan20220806;

import java.util.*;

/**
 * 小美的数据拆分时间限制：
 * 3000MS内存限制：
 * 589824KB题目描述：
 * 小美非常热衷于数据竞赛，数据竞赛是当下非常流行的一种比赛形式，在这种比赛中往往会给出一个练集和一个测试集，由于测试集是没有标注的，
 * 因此大家为了线下评测模型的性能，通常会将动训练集拆分成两个部分，即自建的训练集和测试集。
 * 现在给出某比赛的一个训川陈集，小美需要按照如下规则将其拆分为训川练集和测试集。
 * 已知该训练集包含个样本，每个样本有一个样本编号和一个类别编号。
 * 假设某一类别的样本共有个，则将编号最小的m/2（向上取整个样本作为训练集，将其他样本作为测试集。)
 *
 * 输入描述
 * 输入第一行包含两个正整数和k，分别表示样本数量和类别数量。
 * （1<=n<=10000,1<=k<=100）
 * 输入第二行包含个正整数，第i个正整数表示第i个样本的类别编号是j。
 *
 * 输出描述
 * 输出包合两行，第一行是训川练集样本编号，编号从小到大输出，中间用空格隔开。第二行是测试集的样本编号，编号从小到大输出，中间用空格隔开。
 *
 * Input
 * 10 3
 * 3, 2, 2, 1, 2, 3, 1, 3, 3, 3
 * Output
 * 1 2 3 4 6 8
 * 5 7 9 10
 * @author Acui
 * @date 2022年08月06日 10:54
 */
public class Q4 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(), k = sc.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();
//        }
        int[] nums = new int[]{3, 2, 2, 1, 2, 3, 1, 3, 3, 3};
        int k = 3;
        List<List<Integer>> ans = solve(nums, k);
        List<Integer> train = ans.get(0);
        List<Integer> test = ans.get(1);
        train.sort((Comparator.comparingInt(o -> o)));
        test.sort((Comparator.comparingInt(o -> o)));
        for (int tr : train) {
            System.out.print(tr + " ");
        }
        System.out.println();
        for (int te : test) {
            System.out.print(te + " ");
        }

    }

    private static List<List<Integer>> solve(int[] nums, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> train = new ArrayList<>();
        List<Integer> test = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        for (int i = 1; i <= k; i++) {
            int amount = map.get(i);
            int testSize = amount / 2;
            int trainSize = amount - testSize;

            for (int j = 0, m = trainSize; j < n; j++) {
                if (nums[j] == i) {
                    if (m != 0) {
                        train.add(j + 1);
                        m--;
                    } else {
                        test.add(j + 1);
                    }
                }
            }
        }
        ans.add(train);
        ans.add(test);
        return ans;
    }
}
