class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int ans = Integer.MAX_VALUE;

        // Land -> Water
        for (int i = 0; i < n; i++) {
            int landFinish = landStartTime[i] + landDuration[i];
            for (int j = 0; j < m; j++) {
                int waterStart = Math.max(landFinish, waterStartTime[j]);
                int waterFinish = waterStart + waterDuration[j];
                ans = Math.min(ans, waterFinish);
            }
        }

        // Water -> Land
        for (int i = 0; i < m; i++) {
            int waterFinish= waterStartTime[i] + waterDuration[i];
            for (int j = 0; j < n; j++) {
                int landStart = Math.max(waterFinish, landStartTime[j]);
                int landFinish = landStart + landDuration[j];
                ans = Math.min(ans, landFinish);
            }
        }

        return ans;
    }
}