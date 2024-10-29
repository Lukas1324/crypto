package de.uniwue.gdp.crypto.basic;

import de.uniwue.gdp.crypto.Encryptor;

public class ShiftEncryptor implements Encryptor {
    int offset;
    public ShiftEncryptor(int offset){
        this.offset = offset;
    }

    private char shiftChar(char c, int shift) {
        if (c >= 'A' && c <= 'Z') {
            int base = c - 'A';
            int shifted = (base + shift + 26) % 26;
            return (char)('A' + shifted);
        } else {
            return c;
        }
    }
    @Override
    public String encode(String input) {
        /*String temp = "";
        int valueChar;
        for(int i = 0; i<input.length();i++){
            if(input.charAt(i) == ' '){
                temp += ' ';
                continue;
            }
            valueChar = (int) input.charAt(i) + offset;
            if (valueChar>90){
                valueChar = valueChar - 25;
            }
            temp += (char) valueChar;
        }
        return temp;*/
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            sb.append(shiftChar(c, offset));
        }
        return sb.toString();
    }

    @Override
    public String decode(String input) {
        /*String temp = "";
        int valueChar;
        for(int i = 0; i<input.length(); i++) {
            if (input.charAt(i) == ' ') {
                temp += ' ';
                continue;
            }
            valueChar = (int) input.charAt(i) - offset;
            if (valueChar < 65) {
                valueChar = valueChar + 25;
            }
            temp += (char) valueChar;
        }
        return temp;*/
        StringBuilder decoded = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                int originalPosition = c - 'A';
                int shiftedPosition = (originalPosition - offset) % 26;
                if (shiftedPosition < 0) {
                    shiftedPosition += 26;
                }
                char originalChar = (char) ('A' + shiftedPosition);
                decoded.append(originalChar);
            } else {
                decoded.append(c);
            }
        }
        return decoded.toString();
    }


    @Override
    public String key() {
        return "SFT" + offset;
    }
}
