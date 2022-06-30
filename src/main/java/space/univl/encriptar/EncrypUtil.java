package space.univl.encriptar;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;

public class EncrypUtil {
//	codifica Password
	public static String encode(final String password) {
		return Base64.encodeBase64String(StringUtils.getBytesUtf8(password));
	}
//	Para Decodifica Password
	public static String decode(final String passwordEncoded) {
		return StringUtils.newStringUsAscii(Base64.decodeBase64(passwordEncoded));
	}


}
