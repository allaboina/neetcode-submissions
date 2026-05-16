class Solution {
    public int countSeniors(String[] details) {
        int count = 0;

        for(int i=0; i<details.length; i++){
            String passenger = details[i];
            char tensDigit = passenger.charAt(11);
            char onesDigit = passenger.charAt(12);

            int age = (tensDigit - '0') * 10 + (onesDigit - '0');

            if (age > 60){
            count ++;
            }
        }
        return count;
    }
}