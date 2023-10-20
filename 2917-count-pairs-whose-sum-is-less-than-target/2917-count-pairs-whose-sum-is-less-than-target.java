class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int i = 0; 
        int j = nums.size() - 1;
        int count = 0;

        int a[]=new int[nums.size()];
        
        for(int ind=0;ind<nums.size();ind++)
        {
             a[ind]=nums.get(ind);
        }
        Arrays.sort(a);

        while(i < j){
            if(a[i] +a[j] < target){
                count += j-i;
                i++;
            }else{
                j--;
            }
        }
        return count;
    }
}
