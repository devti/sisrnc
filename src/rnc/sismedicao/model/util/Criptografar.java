package rnc.sismedicao.model.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JOptionPane;

public class Criptografar {
	
	
	public static String convertToSHA256(String texto){
		try {
			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = algorithm.digest(texto.getBytes("UTF-8"));
			 
			StringBuilder hexString = new StringBuilder();
			for (byte b : messageDigest) {
			  hexString.append(String.format("%02X", 0xFF & b));
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Erro ao Criptografar", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return null;
	}
	
	public static String convertToHashBigInteger32(byte[] hash) {  
	    return new BigInteger(hash).toString(32);  
	}  
	
	
}
