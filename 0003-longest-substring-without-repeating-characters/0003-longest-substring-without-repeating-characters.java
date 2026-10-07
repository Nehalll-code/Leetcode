class Solution {
    public int lengthOfLongestSubstring(String s) {
       HashSet<Character> hash = new HashSet<>();
       int l = 0;
       int maxl = 0;

       for(int right=0;right<s.length();right++){
            while(hash.contains(s.charAt(right))){
                hash.remove(s.charAt(l));
                l++;
            }
            hash.add(s.charAt(right));
            maxl = Math.max(maxl,right-l+1);
       } 
       return maxl;
    }
}