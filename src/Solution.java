import java.util.*;

public class Solution {

    public int minimumRecolors(String blocks, int k) {
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

    public String gcdOfStrings(String str1, String str2) {

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

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int maxCandy=0;
        for (int i : candies){
            if (i>maxCandy){
                maxCandy=i;
            }
        }
        List<Boolean> result = new ArrayList<>();
            for (int i : candies) {
                if ((i+extraCandies) < maxCandy) {
                    result.add(false);
                } else {
                    result.add(true);
                }
            }
        return result;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int[] flowerWithBorder=new int[flowerbed.length+2];

        flowerWithBorder[0]=0;
        flowerWithBorder[flowerWithBorder.length-1]=0;

        for(int i=0; i<flowerbed.length;i++){
            flowerWithBorder[i+1]=flowerbed[i];
        }

        int numberCanPlace=0;
        for(int i=1;i<flowerWithBorder.length;){

            if(flowerWithBorder[i-1]==0 && flowerWithBorder[i+1]==0){
               if(flowerWithBorder[i]==0){
                   numberCanPlace++;
               }
               i+=2;
            }else{
                i++;
            }
        }
        return numberCanPlace >= n;
    }

    public int numberOfAlternatingGroups(int[] colors, int k) {
// Time limit exceed
//        for(int i=0; i< colors.length; i++){
//            boolean isvalid=true;
//            int count =0;
//            for(int j=i;j<i+k-1;j++){
//                if(colors[j%colors.length]==colors[(j+1)%colors.length]){
//                    isvalid=false;
//                    break;
//                }
//            }
//            if(isvalid){
//                total++;
//            }
//        }

        int total=0;
        int [] newColorSet= new int[colors.length+k-1];
        System.arraycopy(colors, 0, newColorSet, 0, colors.length);
        for (int i = 0; i < k - 1; i++) {
            newColorSet[colors.length + i] = colors[i];
        }
        int count=1;
        boolean isValid=false;
        for(int i=0;i<newColorSet.length-1;i++){

            if(newColorSet[i]!=newColorSet[i+1]){
                if(isValid){
                    total++;
                    continue;
                }
                count++;
            }else{
                count=1;
                isValid=false;
            }
            if(count==k){
                total++;
                isValid=true;
            }
        }
        return total;
    }
}
