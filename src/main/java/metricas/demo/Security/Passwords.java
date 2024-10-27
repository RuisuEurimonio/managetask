/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metricas.demo.Security;

import java.security.MessageDigest;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ruisu's
 */
@Service
public class Passwords {
    
    private final SecretKeySpec secretKey;

     public Passwords(@Value("${aes.secret-key}") String secretKeyString) throws Exception {
        // Genera un hash SHA-256 y toma los primeros 16 bytes para la clave AES de 128 bits
        byte[] keyBytes = generateAESKeyFromPassword(secretKeyString);
        this.secretKey = new SecretKeySpec(keyBytes, "AES");
    }

    private byte[] generateAESKeyFromPassword(String password) throws Exception {
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] key = sha.digest(password.getBytes("UTF-8"));
        // Usamos solo los primeros 16 bytes para AES-128
        byte[] aesKey = new byte[16];
        System.arraycopy(key, 0, aesKey, 0, 16);
        return aesKey;
    }

    public String encrypt(String plainText) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}
