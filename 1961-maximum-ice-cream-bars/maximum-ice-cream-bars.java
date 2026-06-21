class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxx = Arrays.stream(costs).max().getAsInt();
        // Frequency map for ice cream costs
        int[] freq = new int[maxx + 1];
        for (int val : costs) {
            freq[val]++;
        }

        int count = 0;

        // Better Approach
        for (int cost = 1; cost <= maxx; cost++) {
            if (freq[cost] == 0)
                continue;

            int canBuy = Math.min(freq[cost], coins / cost); // only can buy minimum of available ice creams vs how many can afford 
            count += canBuy;
            coins -= canBuy * cost;

            if (coins < cost)
                continue; // Can't afford any ice creams
        }

        // ******* 
        // Another Approach

        return count;
    }
}

// *********
// int spend = 0;
// for (int i = 0; i < freq.length; i++) {
//     for (int j = freq[i]; j >= 0; j--) {
//         long curr = (long)i * j;
//         if (spend + curr <= coins) {
//             count += j;
//             spend += curr;
//             break;
//         }
//     }
// }