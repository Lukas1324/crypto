package de.uniwue.gdp.crypto;

/**
 * Interface for key-based symmetric text encryption
 */
public interface Encryptor {
    /**
     * Encrypts the given String {@code input}. Every implementing class should be able to undo the encryption by
     * executing its {@code decode} method.
     * @param input The text which needs to be encrypted
     * @return The encrypted text
     */
    String encode(String input);

    /**
     * Decrypts the given String {@code input}.
     * @param input The text which needs to be decrypted
     * @return The decrypted text
     */
    String decode(String input);

    /**
     * Returns an identification String with represents the encryption technique and (if necessary) its parameters
     * @return Identification String of the encryption technique
     */
    String key();
}
