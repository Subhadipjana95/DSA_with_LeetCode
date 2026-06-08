class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = nums.length;

        // Push all the element less than pivot to list
        for(int i=0; i<n; i++){
            if(nums[i] < pivot){
                list.add(nums[i]);
            }
        }

        // Push the pivot to list after the lesser elements
        for(int i=0; i<n; i++){
            if(nums[i] == pivot){
                list.add(nums[i]);
            }
        }

        // Push all the elements greater than pivot to list after pivot element
        for(int i=0; i<n; i++){
            if(nums[i] > pivot){
                list.add(nums[i]);
            }
        }

        // Copy the order of list into array
        for(int i=0; i<list.size(); i++){
            nums[i] = list.get(i);
        }

        return nums;
    }
}