class Solution {
    public double separateSquares(int[][] squares) {
        double minY = Double.MAX_VALUE;
        double maxY = Double.MIN_VALUE;
        for(int[] s: squares){
            minY = Math.min(minY, s[1]);
            maxY = Math.max(maxY, s[1]+s[2]);
        }
        
        double precision = 1e-5;

        while(maxY - minY > precision){
            double midY = (minY + maxY)/2;
            if(isLowerHalfLarger(squares, midY)){
                maxY = midY;
            }
            else{
                minY = midY;
            }
        }
        return minY;
    }

    boolean isLowerHalfLarger(int[][] squares, double midY){
        double lowerArea = 0;
        double upperArea = 0;
        for(int[] s: squares){
            double bottomY =s[1];
            double side = s[2];
            double topY = bottomY + side;

            if(topY <= midY){
                lowerArea += side*side;
            }
            else if(bottomY >= midY){
                upperArea += side*side;
            }
            else{
                double belowSide = midY - bottomY;
                double aboveSide = topY - midY;
                lowerArea += side*belowSide;
                upperArea += side*aboveSide;
            } 
        }
        return lowerArea >= upperArea;
    }
}