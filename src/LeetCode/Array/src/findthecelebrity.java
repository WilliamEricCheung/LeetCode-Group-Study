public class findthecelebrity {
    public int find(int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        for (int i = 0; i < n; i++){
            if(i != candidate & knows(candidate, i)|| !knows(i, candidates)){
                return -1;
            }
        }
   return candidate; }
}