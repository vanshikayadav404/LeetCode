class Solution {
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> set= new HashSet<>();
        int duplicate=0;
        for(int num:nums)
        {
            if(set.contains(num))
            duplicate=num;
            set.add(num);
        }
        int removed=0;
        for(int i=1;i<nums.length+1;i++)
        {
            if(!set.contains(i))
            removed=i;
        }
        return new int[]{duplicate,removed};
    }
}