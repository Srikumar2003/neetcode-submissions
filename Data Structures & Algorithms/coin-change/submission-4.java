class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;

        Queue<Integer> q = new LinkedList<>();
        boolean[] seen = new boolean[amount + 1];
        seen[0] = true;
        q.add(0);

        int res = 0;
        while(!q.isEmpty()){
            res++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                int cur = q.poll();
                for(int coin : coins){
                    int next = cur + coin;
                    if(next == amount) return res;
                    if(next > amount || seen[next]) continue;
                    seen[next] = true;
                    q.add(next);
                }
            }
        }

        return -1;
    }
}
