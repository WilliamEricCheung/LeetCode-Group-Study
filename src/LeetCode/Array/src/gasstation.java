public class gasstation {
    public int gs( int[] gas, int[] cost) {

        int diff = 0;
        for (int i = 0; i < gas.length; i++) {
            diff +=gas[i] - cost[i];
        }
        if(diff < 0) return -1;

        int sum = 0;
        int start = 0;

        for(int i = 0; i < gas.length; i++){
            sum += gas[i] - cost[i];
            if(sum < 0){
                start = i + 1;
                sum = 0;
            }

        }
      return start;
    }
}
