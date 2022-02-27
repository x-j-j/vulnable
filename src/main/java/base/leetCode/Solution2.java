package base.leetCode;

//股票获利问题
//[1,2,34,7,7,2,5,1]某天买入，某天卖出，求获利最大
class Solution2 {
    public int maxProfit(int[] prices) {
        if(prices.length<=1){
            return 0;
        }
        //记录今天之前的最小值
        //计算今日卖出的获利最大值
        //比较每日获利最大值
        int min = prices[0];
        int max = 0;
        for(int i=1; i<prices.length; i++){
            max = Math.max(max, prices[i]-min);
            min = Math.min(min, prices[i]);
        }
//        HashMap
//        HashSet
        return max;
    }
}
