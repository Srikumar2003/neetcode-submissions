class Solution {
    public int maxArea(int[] heights) {
        int maxarea = 0;

        for(int i = 0; i < heights.length; i++){
            for(int j = i + 1; j < heights.length; j++){
                maxarea = Math.max(maxarea, Math.min(heights[i], heights[j])*(j - i));
            }
        }
        return maxarea;    
    }
}
