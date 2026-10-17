class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder cleaned = new StringBuilder(); 
        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                cleaned.append(ch);
            }
        }
        int l = 0;
        int r = cleaned.length()-1;

        while(l<r){
            if(cleaned.charAt(l) != cleaned.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}