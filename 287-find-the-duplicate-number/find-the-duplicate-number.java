class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Frequency Map  
        for(int val: nums){
            freq.put(val, freq.getOrDefault(val, 0)+1);
        }

        // Iterate Freq corresponding to nums to find the frequency
        for(int val: nums){
            if(freq.get(val) > 1){
                return val;
            }
        }

        return -1;
    }
}