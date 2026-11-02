class Solution {
    private int getDayNumber(String date){
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        int month = Integer.parseInt(date.substring(0,2));
        int day = Integer.parseInt(date.substring(3,5));
        int totaldays = 0;
        for(int i=0; i<month-1; i++){
            totaldays += days[i];
        }
        totaldays += day;
        return totaldays;
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int arrivealice = getDayNumber(arriveAlice);
        int leavealice = getDayNumber(leaveAlice);
        int arrivebob = getDayNumber(arriveBob);
        int leavebob = getDayNumber(leaveBob);

        int start = Math.max(arrivealice,arrivebob);
        int end = Math.min(leavealice,leavebob);

        if(start>end){
            return 0;
        }else{
            return end-start+1;
        }
    }
}