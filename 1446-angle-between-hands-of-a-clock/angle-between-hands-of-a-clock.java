class Solution {
    public double angleClock(int hour, int minutes) {
        double min = 11 * minutes;
        double hr = 60 * hour;
        double diff = Math.abs(min-hr)/2;
        double reflex = (360.0 - diff);
        return Math.min(diff, reflex);
    }
}