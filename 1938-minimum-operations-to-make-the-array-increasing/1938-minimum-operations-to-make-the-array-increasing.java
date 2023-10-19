class Solution {
    public int minOperations(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                int diff = (arr[i] - arr[i + 1]) + 1;
                arr[i + 1] += diff;
                count += diff;
            }
        }
        return count;
    }
}
