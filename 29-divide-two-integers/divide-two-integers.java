class Solution {

    public int divide(int dividend, int divisor) {
        long divi = dividend;
        long div = divisor;
        if(divi == Integer.MIN_VALUE && div == -1){
            return Integer.MAX_VALUE;
        }
        boolean ispositive = true;
        if(divi < 0 && div < 0){
            divi = -divi; div = -div;
        }else if(divi<0 && div>0){
            divi = -divi;
            ispositive = false;
        }else if(divi > 0 && div<0){
            div = -div;
            ispositive = false;
        }

        long quotient = 0;

        while(divi>=div){
            long chunk = div;
            long count = 1;
            while(chunk+chunk<=divi){
                chunk =chunk + chunk;
                count =count + count;
            }
            divi = divi - chunk;
            quotient = quotient + count;
        }
        if(ispositive){
            return (int)quotient;
        }else{
            quotient = -quotient;
            return (int)quotient;
        }
    }
}