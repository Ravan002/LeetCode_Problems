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

    public String reverseVowels(String s) {
        int left=0;
        int right=s.length()-1;
        char[] sArray= s.toCharArray();

        while(left<right){
            if(!isValid(sArray[left])){
                left++;
            }
            if(!isValid(sArray[right])){
                right--;
            }
            if(isValid(sArray[left]) && isValid(sArray[right])){
                char temp = sArray[left];
                sArray[left++]=sArray[right];
                sArray[right--]=temp;
            }
        }
        return new String(sArray);
    }
    private boolean isValid(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    public String reverseWords(String s) {
        String[] words= s.trim().split("\\s+");
        int left = 0, right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;

            left++;
            right--;
        }
        return String.join(" ",words);
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int[] prefix = new int[n];
        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = prefix[i] * suffix;
            suffix *= nums[i];
        }

        return result;
    }

    public int numberOfSubstrings(String s) {
        int [] numberOfLetters= new int[3];
        int totalSubstring=0;
        int start=0;
        int end=0;

        while(end<s.length()){
            numberOfLetters[s.charAt(end)-'a']++;
            while(numberOfLetters[0]>0 && numberOfLetters[1]>0 && numberOfLetters[2]>0){

                totalSubstring+=s.length()-end;
                numberOfLetters[s.charAt(start) - 'a']--;
                start++;
            }
            end++;
        }

        return totalSubstring;
    }

    // Not Complete
    public boolean increasingTriplet(int[] nums) {
        for(int i=1; i<nums.length-1;i++ ){

            if(nums[i-1]<nums[i] && nums[i]<nums[i+1]){
                System.out.println(nums[i-1]+" "+nums[i]+" "+nums[i+1]);
                return true;
            }
        }
        return false;
    }

    public void moveZeroes(int[] nums) {

        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int temp=nums[i];
                nums[i]=nums[cnt];
                nums[cnt]=temp;
                cnt++;
            }
        }
    }

    public boolean isSubsequence(String s, String t) {

        // s is empty return true
        if (s.isEmpty())
            return true;

        // if s length is more than t length it is false
        if (s.length() > t.length())
            return false;
        // if both equal length, both should be same string for being true
        if (s.length() == t.length())
            return s.equals(t);
        int i=0;
        int j=0;
        while(j<s.length() && i<t.length()){
            if(s.charAt(j) == t.charAt(i++)){
                j++;
            }
        }
        return j==s.length();
    }

    public boolean isPowerOfFour(int n) {
        if(n==0)
            return false;
        if(n==1)
            return true;
        if(n%4==0)
            return isPowerOfFour(n/4);
        return false;
    }

    public boolean isPowerOfTwo(int n) {
        if(n==0)
            return false;
        if(n==1){
            return true;
        }
        if(n%2!=0){
            return false;
        }
        return isPowerOfTwo(n/2);
    }
}

