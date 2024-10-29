package de.uniwue.gdp.crypto.basic;

import de.uniwue.gdp.crypto.Encryptor;

public class NeighborEncryptor implements Encryptor {
    @Override
    public String encode(String input) {
        String temp = "";
        int x;
        for(int i = 0; i<input.length()-1;i++){
            if (input.charAt(i) == ' '){
                temp += " ";
            }
            else if (input.charAt(i+1) == ' '){
                temp += input.charAt(i);
            }else {
                x = ((input.charAt(i)-65 + input.charAt(i+1)-65)%26) +65;
                temp += (char)x;
            }
        }
        temp += input.charAt(input.length()-1);
        return temp;

    }

    @Override
    public String decode(String input) {
        String temp = "";
        int x;
        int z = 0;
        temp += input.charAt(input.length()-1);
        for(int i = input.length()-2; 0<=i ; i--){
            if (input.charAt(i) == ' '){
                temp += " ";
            }else if(input.charAt(i+1) == ' '){
                temp += input.charAt(i);
            }else {
                x = ((int)input.charAt(i)) - ((int)temp.charAt(z));
                if (x<0){
                    x += 26;
                }
                temp += (char) (x+ 65);
            }
            z++;
        }
        String zuu = "";
        for(int i = temp.length()-1; i>=0;i--)
            zuu = zuu + temp.charAt(i);
        return zuu;
    }

    @Override
    public String key() {
        return "NEI";
    }
}
