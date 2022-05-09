package leetcode.editor.test;

import java.util.ArrayList;
import java.util.*;

/**
 * @author Acui
 * @date 2021年10月10日 19:41
 */
public class Q2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < s.length(); i++){
            arr[i] = s.charAt(i)-'0';
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (n-i+1<res) break;
            for (int j = i+1; j < n; j++) {
                if (j-i+1<res) continue;
                if (check(arr,i,j)) res = Math.max(res,j-i+1);
            }
        }
        System.out.println(res);
    }
    public static boolean check(int[] arr, int l,int r){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = l; i <= r; i++) list.add(arr[i]);
        while (list.size()>0){
            int len = list.size();
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i)==0&&list.get(i+1)==1||
                        list.get(i)==2&&list.get(i+1)==3){
                    list.remove(i);
                    list.remove(i);
                }
            }
            if (len==list.size()) break;
        }
        return list.size()==0;
    }

}
