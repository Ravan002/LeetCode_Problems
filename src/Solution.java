public class Solution {
    public static int minimumRecolors(String blocks, int k) {
        int minReColor=k;
        for(int j=0;j<=blocks.length()-k;j++){
            int changeWhite=0;
            for (int i = j; i < j+k; i++) {
                if(blocks.charAt(i)=='W'){
                    changeWhite++;
                }
            }
            if(changeWhite<minReColor){
                minReColor=changeWhite;
            }
        }
        return minReColor;
    }

    public static String gcdOfStrings(String str1, String str2) {

        int minLength = Math.min(str1.length(), str2.length());
        String minString= str1.length() < str2.length()?str1:str2;

        for(int i=minLength;i>=1;i--){

            if(str1.length()%i==0 && str2.length()%i==0){
                String base = minString.substring(0,i);
                boolean isSub= str1.replace(base,"").isEmpty() && str2.replace(base,"").isEmpty();
                if(isSub){
                    System.out.println(base);
                }
            }
        }
        return null;
    }
}
