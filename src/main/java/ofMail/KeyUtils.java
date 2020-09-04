package ofMail;

import java.util.Random;

public class KeyUtils {
	//a~z == 97~122
	//A~Z == 65~90
	//0~9 == 48~57
	final int keySize=20;
	private String Key;
	public String getKey() {
		return Key;
	}
	public void setKey(String key) {
		Key = key;
	}
	public int getKeySize() {
		return keySize;
	}
	public String makeKey() {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		int temp = 0;
		for(;sb.length()<keySize;) {
			temp =random.nextInt(80)+45;
			if(97<=temp&&temp<=122 || 65<=temp&&temp<=90 || 48<=temp&&temp<=57)
				sb.append((char)temp);
		}
		setKey(sb.toString());
	
		return getKey();
	}
}
