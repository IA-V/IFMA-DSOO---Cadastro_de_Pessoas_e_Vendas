package criptografia;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {
	public static String passwordEncryption(String p) {
		try {
			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = algorithm.digest(p.getBytes("UTF-8"));
			StringBuilder hexString = new StringBuilder();
			for(byte b : messageDigest) {
				hexString.append(String.format("%02X", 0xFF & b));
			}
			String newPassword = hexString.toString();
			return newPassword;
		}catch(NoSuchAlgorithmException e) {
			System.out.println(e.getMessage());
			return null;
		}catch(UnsupportedEncodingException uee) {
			System.out.println(uee.getMessage());
			return null;
		}
	}
}
