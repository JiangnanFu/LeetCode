package 贝壳笔试;

/**
 @author fujiangnan
 @create 2021-08-13-21-47
 @desc 奇特区间，如果a异或b == t,则ab所在区间是奇特区间，求非奇特区间个数
 */
public class Main3 {
    public static void main(String[] args) {
        int[] a = {2,3,4,5,8,10};
        int t = 6;
        System.out.println(section(a, t));
    }
    public static long section (int[] a, int t) {
        // write code here
        //遍历一遍，遍历到 a[i] 时，哈希表保存之前是否有 t ^ a[i]。
        //有相同的数时，保存索引更大的。
        //C++版本
        //long long solve(vector<int> &a, int t) {
        //    int n = a.size();
        //    long long ans = 0;
        //    unordered_map<int, int> index;
        //    int pre = 0;
        //    for (int i = 0; i < n; ++i) {
        //        int b = a[i] ^ t;
        //        int k = index.count(b) ? index[b] + 1 : 0;
        //        k = max(k, pre);
        //        pre = k;
        //        ans += i - k;
        //        index[a[i]] = i;
        //    }
        //    return ans;
        //}
        return 1;

    }
}
