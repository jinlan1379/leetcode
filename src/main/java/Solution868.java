//二进制间距
public class Solution868 {
    public int binaryGap(int N) {
        String Ns = Integer.toBinaryString(N);
        int biggerGap = 0;
        int preIndex = -1;
        for(int i=0; i<Ns.length(); i++){
            if(Ns.charAt(i) == '1'){
                if(preIndex==-1) preIndex=i;
                else{
                    int currentGap = i-preIndex;
                    if(currentGap>biggerGap) biggerGap = currentGap;
                    preIndex = i;
                }
            }
        }
        return biggerGap;
    }
}
