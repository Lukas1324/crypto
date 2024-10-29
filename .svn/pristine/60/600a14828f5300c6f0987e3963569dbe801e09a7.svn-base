package de.uniwue.gdp.crypto.basic;

import de.uniwue.gdp.crypto.Encryptor;

import javax.crypto.EncryptedPrivateKeyInfo;

public class RevertEncryptor implements Encryptor {
    @Override
    public String encode(String input) {
        String temp = "";
        for(int i = input.length()-1; i>=0;i--)
            temp = temp + input.charAt(i);
        return temp;
    }

    @Override
    public String decode(String input) {
        String temp = "";
        for(int i = input.length()-1; i>=0;i--)
            temp = temp + input.charAt(i);
        return temp;
    }

    @Override
    public String key() {
        return "RVT";
    }
}
