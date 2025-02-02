package de.uniwue.gdp.crypto;
import de.uniwue.gdp.crypto.basic.RevertEncryptor;
import de.uniwue.gdp.crypto.basic.ShiftEncryptor;
import de.uniwue.gdp.crypto.basic.NeighborEncryptor;
import java.util.ArrayList;
import java.util.List;

public class KeyTranslator {
    public static Encryptor fromKey(String key) {
        if (key == null || key.isEmpty() || key.endsWith("-")) {
            return null;
        }

        String[] parts = key.split("-");
        if (parts.length == 1) {
            return en(parts[0]);
        } else {
            List<Encryptor> encryptors = new ArrayList<>();
            for (String part : parts) {
                Encryptor encryptor = en(part);
                if (encryptor != null) {
                    encryptors.add(encryptor);
                } else {
                    return null;
                }
            }
            return ComplexEncryptor.builder().addEncryptors(encryptors).build();
        }
    }

    private static Encryptor en(String part) {
        switch (part) {
            case "RVT":
                return new RevertEncryptor();
            case "NEI":
                return new NeighborEncryptor();
            default:
                if (part.startsWith("SFT")) {
                    try {
                        int offset = Integer.parseInt(part.substring(3));
                        return new ShiftEncryptor(offset);
                    } catch (NumberFormatException e) {
                        return null;
                    }
                }
                return null;
        }
    }
}
