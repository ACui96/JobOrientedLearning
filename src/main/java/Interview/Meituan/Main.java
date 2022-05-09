package Interview.Meituan;


import java.util.*;

class Solution {
    public List<String> func(int n, List<Integer> h, List<String> names) {

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(names.get(i), h.get(i));
        }
        names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1) != map.get(o2)) {
                    return map.get(o1) - map.get(o2);
                } else {
                    return o1.compareTo(o2);
                }
            }
        });
//        names.sort(((o1, o2) -> map.get(o1).equals(map.get(o2)) ? o1.compareTo(o2) : map.get(o1) - map.get(o2)));
//        names.sort(((o1, o2) -> map.get(o1) == map.get(o2) ? o1.compareTo(o2) : map.get(o1) - map.get(o2)));


       return names;
    }
}

/**
 * @author Acui
 * @date 2022年04月09日 16:11
 */
public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt(); // 士兵数
//        List<Integer> h = new ArrayList<>();
//        List<String> names = new ArrayList<>();


//        String[] s = sc.nextLine().split(" ");
//        for (int i = 0; i < n; i++) {
//            h[i] = Integer.parseInt(s[i]);
//        }
//        names = sc.nextLine().split(" ");
//        for (int i = 0; i < n; i++) {
//            h.add(sc.nextInt());
//        }
//        for (int i = 0; i < n; i++) {
//            names.add(sc.next());
//        }

        int n = 4;
        List<Integer> h = new ArrayList<>();
        h.add(176);
        h.add(170);
        h.add(176);
        h.add(176);
        List<String> names = new ArrayList<>();
        names.add("beta");
        names.add("tom");
        names.add("alpha");
        names.add("bamma");
// 176 170 176 176 beta tom alpha bamma

        List<String> ret = new Solution().func(n, h, names);
        for (int i = 0; i < ret.size(); i++) {
            if (i < ret.size())
                System.out.print(ret.get(i) + " ");
            else System.out.print(ret.get(i));
        }

    }
}
