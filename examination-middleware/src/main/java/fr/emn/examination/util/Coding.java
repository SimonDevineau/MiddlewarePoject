/**
 * Part of the project : examination fr.emn.examination.model.User.java Created
 * by : pierre
 */
package fr.emn.examination.util;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Cedric Nisio
 * 
 */
public class Coding implements Serializable {

    /**
     * long
     */
    private static final long serialVersionUID = -4883653075164218093L;

    public Coding() {
    }

    public String plainStringToMD5(String input) {

	MessageDigest md = null;
	byte[] byteHash = null;

	StringBuffer resultString = new StringBuffer();

	try {
	    md = MessageDigest.getInstance("MD5");
	}
	catch (NoSuchAlgorithmException e1) {
	    e1.printStackTrace();
	}

	md.reset();

	try {
	    md.update(input.getBytes("UTF-8"));
	}
	catch (UnsupportedEncodingException e) {
	    System.out.println("UnsupportedEncodingException caught!");
	}

	byteHash = md.digest();

	for (int i = 0; i < byteHash.length; i++) {
	    resultString.append(Integer.toHexString(0xF0 & byteHash[i]).charAt(
		    0));
	    resultString.append(Integer.toHexString(0x0F & byteHash[i]));
	}

	return resultString.toString();
    }

}
