class Solution {
    // Better Approach
    public long sumAndMultiply(int n) {
        int num = 0;
        int sum = 0;
        long x = 0;
        while (n != 0) {
            if (n % 10 != 0) {
                num = num * 10 + n % 10;
                sum += n % 10;
            }
            n /= 10;
        } // -- this stored the digits of 'n' within 'num' into reverse order

        // Now have to reverse the 'num' into 'x' to make it normal
        while (num != 0) {
            x = x * 10 + num % 10;
            num /= 10;
        }

        return (long) x * sum;
    }

    // public long sumAndMultiply(int n) {
    //     StringBuilder sb = new StringBuilder();
    //     while (n > 0) {
    //         int curr = n % 10;
    //         sb.append(curr);
    //         n = n / 10;
    //     }
    //     sb.reverse();
    //     int index;
    //     while ((index = sb.indexOf("0")) != -1) {
    //         sb.deleteCharAt(index);
    //     }
    //     long x = 0;
    //     if (sb.length() > 0) {
    //         x = Long.parseLong(sb.toString());
    //     }
    //     int sum = 0;
    //     for (char c : sb.toString().toCharArray()) {
    //         int digit = Character.getNumericValue(c);
    //         sum += digit;
    //     }

    //     return (long) x * sum;
    // }
}