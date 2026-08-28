class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int n= asteroids.length;
        
        for(int i=0;i<n;i++){
            int curr = asteroids[i];
            boolean destroyed = false;
            while(!stack.isEmpty() && stack.peek()>0 && curr<0 ){
                if(stack.peek() < Math.abs(curr)){
                    stack.pop();
                }else if(stack.peek() == Math.abs(curr)){
                    stack.pop();
                    destroyed = true;
                    break;
                }else{
                    destroyed = true;
                    break;
                }
            }
            if(!destroyed){
                stack.push(curr);
            }
        }
        int[] ans = new int[stack.size()];
        for(int i =0;i<stack.size();i++){
            ans[i] = stack.get(i);
        }
        return ans;
    }
}