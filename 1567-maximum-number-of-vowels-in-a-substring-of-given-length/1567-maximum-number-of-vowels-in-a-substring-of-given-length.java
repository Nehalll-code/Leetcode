class Solution {
    public boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public int maxVowels(String s, int k) {
        int count = 0;
        //build first window
        for(int i =0;i<k;i++){
            if(isVowel(s.charAt(i))){
                count++;
            }
        }
        int ans = count;
        //slide the window
        for(int i=k;i<s.length();i++){
            if(isVowel(s.charAt(i-k))){
                count--;
            }if(isVowel(s.charAt(i))){
                count++;
            }
            ans = Math.max(ans,count);
        }
        return ans;
    }
}