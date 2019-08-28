public class hindex {
    public int h(int[] citation){
        int count = 0;
        int index = 1;
        for (int i = 0; i<citation.length; i++){
            if(citation[i] >= index && count < i){
                count++;
            }
            else {
                index++;
            count = 0;
            i = 0;
            }
        }
    }
}
