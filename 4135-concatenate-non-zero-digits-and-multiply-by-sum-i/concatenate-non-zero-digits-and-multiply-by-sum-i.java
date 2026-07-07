class Solution {
    public long sumAndMultiply(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int curr = n % 10;
            sb.append(curr);
            n = n / 10;
        }
        sb.reverse();
        int index;
        while ((index = sb.indexOf("0")) != -1) {
            sb.deleteCharAt(index);
        }
        long x = 0;
        if (sb.length() > 0) {
            x = Long.parseLong(sb.toString());
        }
        int sum = 0;
        for (char c : sb.toString().toCharArray()) {
            int digit = Character.getNumericValue(c);
            sum += digit;
        }

        return (long) x * sum;
    }
}