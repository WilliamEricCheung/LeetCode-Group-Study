public class jumpgameII {
    public int stepfind(int[] nums){
        if()
        int step = 0;
        int curmax = 0;
        int nextmax = 0;
        int index = 0;

        while(index <= curmax) {
            while (index <= curmax) {
                nextmax = Math.max(nextmax, (nums[index] + index));
                index++;
            }
            curmax = nextmax;
            step++;
        }
        return step;
    }
}
