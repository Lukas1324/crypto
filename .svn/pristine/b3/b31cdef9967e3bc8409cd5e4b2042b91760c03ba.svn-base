package de.uniwue.gdp.crypto;

import de.uniwue.gdp.crypto.basic.ShiftEncryptor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComplexEncryptor implements Encryptor{

    private final List<Encryptor> encryptors;

    private ComplexEncryptor(List<Encryptor> encryptors){
        this.encryptors = encryptors;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private final List<Encryptor> encryptors = new ArrayList<>();

        private Builder(){

        }
        public Builder addEncryptor(Encryptor e){
            encryptors.add(e);
            return this;
        }
        public Builder addEncryptors(List<Encryptor> e){
            encryptors.addAll(e);
            return this;
        }
        public Builder removeEncryptor(Encryptor e){
            encryptors.remove(e);
            return this;
        }
        public Builder reverse(){
            Collections.reverse(encryptors);
            return this;
        }
        public ComplexEncryptor build(){
            return new ComplexEncryptor(new ArrayList<>(encryptors));
        }

    }
    @Override
    public String encode(String input) {
        String temp = input;

        for(Encryptor encryptor : encryptors){
            temp = encryptor.encode(temp);
        }

        return temp;
    }

    @Override
    public String decode(String input) {
        String decoded = input;
        List<Encryptor> reversedEncryptors = new ArrayList<>(encryptors);
        Collections.reverse(reversedEncryptors);

        for (Encryptor encryptor : reversedEncryptors) {
            decoded = encryptor.decode(decoded);
        }
        return  decoded;

    }

    @Override
    public String key() {
        StringBuilder k = new StringBuilder();
        for (Encryptor encryptor : encryptors){
            if(k.length() > 0){
                k.append("-");
                }
            k.append(encryptor.key());
        }
        return k.toString();
    }

}
