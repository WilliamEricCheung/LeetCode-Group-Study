public class CompareVersionNumbers {
    public int compare(String version1, String version2){
        String[] version1s = version1.split("\\.");
        String[] version2s = version2.split("\\.");
        for(int i = 0; i < version1s.length || i < version2s.length; i++){
            Integer v1 = i < version1s.length ? Integer.parseInt(version1s[i]) : 0;
            Integer v2 = i < version2s.length ? Integer.parseInt(version2s[i]) : 0;
            int compare = v1.compareTo(v2);
            if(compare != 0) return compare;
        }
        return 0;
    }
}
