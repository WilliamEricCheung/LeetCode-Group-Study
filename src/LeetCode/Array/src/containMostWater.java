public class containMostWater {
    public int contain(int[] bar){
        int max = 0;
        int i = 0;
        int j = bar.length -1;
        while(i < j){
            max = Math.max(max,(j-i) * Math.min(bar[i], bar[j]));
            if (bar[i] <bar[j]) i++;
            else j--;

        }
        return max;
    }
}
