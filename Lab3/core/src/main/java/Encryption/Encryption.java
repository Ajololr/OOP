package Encryption;

import Singleton.Singleton;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Encryption {
    private static Encryption instance;
    public static Encryption getInstance(){ // #3
        if(instance == null){
            instance = new Encryption();
        }
        return instance;
    }

    private SecretKey secretKey;

    private Encryption(){
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);
            this.secretKey = keyGenerator.generateKey();

//            byte[] decodedKey = Base64.getDecoder().decode(key);
//            this.secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }



     public byte[] Encrypt(byte[] text) {
         byte[] encipherText = makeAes(text, Cipher.ENCRYPT_MODE);
         //System.out.println(new String(encipherText));

         return encipherText;
    }

    public byte[] Decrypt(byte[] encipherText){
        byte[] sourceText = makeAes(encipherText, Cipher.DECRYPT_MODE);

        return sourceText;
    }

    public byte[] makeAes(byte[] rawMessage, int cipherMode){
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(cipherMode, this.secretKey);
            byte [] output = cipher.doFinal(rawMessage);
            return output;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
