class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int minTime = Integer.MAX_VALUE;

        int landFirstTime = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int landTime = landStartTime[i] + landDuration[i];
            for (int j = 0; j < m; j++) {
                int landFinish = Math.max(landTime, waterStartTime[j]);
                int landAfterWaterTime = landFinish + waterDuration[j];
                if (landAfterWaterTime < landFirstTime) {
                    landFirstTime = landAfterWaterTime;
                }
            }
        }

        int waterFirstTime = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int waterTime = waterStartTime[i] + waterDuration[i];
            for (int j = 0; j < n; j++) {
                int waterFinish = Math.max(waterTime, landStartTime[j]);
                int waterAfterLandTime = waterFinish + landDuration[j];
                if (waterAfterLandTime < waterFirstTime) {
                    waterFirstTime = waterAfterLandTime;
                }
            }
        }
        return landFirstTime < waterFirstTime ? landFirstTime : waterFirstTime;
    }
}