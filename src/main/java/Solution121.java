//买卖股票的最佳时机
public class Solution121 {
    public int maxProfit(int[] prices) {
        int biggestGap = 0;
        for(int i=(prices.length -1); i>-1; i--){
            for(int j=i-1; j>-1; j--){
                if(prices[i]>prices[j] && biggestGap<(prices[i]-prices[j])){
                    biggestGap = prices[i]-prices[j];
                }
            }
        }
        return biggestGap;
    }
}
