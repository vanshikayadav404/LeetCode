class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {

        List<String> ans = new ArrayList<>();
        int minsum = Integer.MAX_VALUE;

        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {

                if (list1[i].equals(list2[j])) {

                    int sum = i + j;

                    if (sum < minsum) {
                        ans.clear();
                        ans.add(list1[i]);
                        minsum = sum;
                    } else if (sum == minsum) {
                        ans.add(list1[i]);
                    }
                }
            }
        }

        return ans.toArray(new String[0]);
    }
}