class Solution {
    public String convertToBinary(String str){
      // converting string to int
        int num = Integer.parseInt(str);
        String binary = "";
        while(num > 0){
            int rem = num%2;
          // adding int to string , its get converted itself
            binary = rem + binary;
            num = num/2;
        }
        return binary;
    }

    public String convertDateToBinary(String date) {
        String ans = "";
        String[] arr = date.split("-");
        for(int i=0; i < arr.length; i++){
            String bin = convertToBinary(arr[i]);
            if(i < arr.length-1){
                ans += bin + "-";
            }
            else{
                ans += bin;
            }
        }

        return ans;
    }
}
