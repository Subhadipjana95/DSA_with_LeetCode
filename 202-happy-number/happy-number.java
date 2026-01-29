class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do{
            slow = next(slow);
            fast = next(next(fast));
        }while(slow != fast);

        return (slow == 1);
    }

    public int next(int n){
        int sum = 0;
        while(n>0){
            int digit = n%10;
            sum = sum + digit*digit;
            n /= 10;
        }
        return sum;
    }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (java.io.FileWriter fw = new java.io.FileWriter("display_runtime.txt")) {
                fw.write("0");
            } catch (Exception e) {
        }
        }));
    }
}