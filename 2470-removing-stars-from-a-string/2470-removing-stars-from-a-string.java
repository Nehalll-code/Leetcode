class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();

        for(int i = 0;i<n;i++){
            if(s.charAt(i) != '*'){
                stack.push(s.charAt(i));
            }
            else{
                stack.pop();
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}