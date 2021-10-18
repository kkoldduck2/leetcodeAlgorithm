class Solution {
    int charToInt(char i, char j){
        int a = i-'0';
        int b = j-'0';
        return a*10 + b;
    }
    public int numDecodings(String s) {
        int[] d = new int[s.length()];
        // d[i] : i까지 해석하는 경우의 수
        char start = s.charAt(0);
        if(start=='0') return 0;
        d[0] = 1;
        for(int i=1; i<s.length(); i++){
            // A[i] 만 별개로 해석 가능
            if(s.charAt(i) != '0'){
                d[i] += d[i-1];
            }
            
            // A[i-1]과 합쳐서 해석 가능
            int num = charToInt(s.charAt(i-1), s.charAt(i));
            if(num>=10 && num<=26){
                if(i<2){
                    d[i] += 1;
                }else{
                    d[i] += d[i-2];
                }
            }
            
        }                               
        
        return d[s.length()-1];
    }
}