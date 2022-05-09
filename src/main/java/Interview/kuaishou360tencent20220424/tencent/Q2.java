package Interview.kuaishou360tencent20220424.tencent;
import java.util.ArrayList;
import java.util.List;


public class Q2 {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4};
        List<Integer> nums = new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        for(int num : a){
            nums.add(num);
        }
        while(nums.size() > 1){
            for(int i = 0; i < nums.size(); ++i){
                if(help(i+1)){
                    ret.add(nums.get(i));
                }
            }
            nums = new ArrayList<>(ret);
            ret.clear();
        }
        System.out.println(nums.get(0));
    }
    public static boolean help(int n){
        if(n <= 1 || n > 2 && n % 2 == 0){
            return false;
        }else if(n == 2){
            return true;
        }
        for(int i = 3; i <= Math.sqrt(n); i += 2){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}