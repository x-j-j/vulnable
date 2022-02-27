package base.leetCode;

public class others {
    public static void main(String[] args) {

    }
    protected int substr(){
        //最长递增子序列
        //{4,6,5,7,3,8,4,5,10} -> {4,5,7,8,10}
        //第i个元素的最长递增子序列是max{dp[i], dp[i]+1}
        int [] nums = new int[]{10,9,2,5,3,7,101,18};
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;

    }
    public void taijie(){
        //1-10个台阶，可一次上一个，一次上两个，所有走步种类
        //动态规划
        int[] a = new int[1000];
        //a[0] = a[1] + a[2]
        //a[1] = a[2] + a[3]
        a[10] = 1;
        a[9] = 1;
        for(int i=8;i>0;i--){
            a[i] = a[i+1] + a[i+2];
        }
        System.out.println(a[1]);
    }
}