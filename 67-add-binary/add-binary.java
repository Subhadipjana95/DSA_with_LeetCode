class Solution {
    public String addBinary(String a, String b) {
        StringBuilder STR = new StringBuilder();

        int A = a.length() -1;
        int B = b.length() -1;
        int carry = 0;

        while(A>=0 || B>=0 || carry==1){
            int sum = carry;

            if(A>=0) sum+=a.charAt(A--) - '0';
            if(B>=0) sum+=b.charAt(B--) - '0';

            STR.append(sum%2);
            carry = sum/2;
        }
        return STR.reverse().toString();
        
    }
}