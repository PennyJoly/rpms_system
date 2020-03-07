package cn.itsource.basic.util;

import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5Util {
    public static final String ALGORITHMNAME = "MD5";
    public static final String SALT = "itsource";
    public static final int HASHITERATIONS = 10;

    public static String createMd5(String source){
        SimpleHash simpleHash = new SimpleHash(ALGORITHMNAME,source,SALT,HASHITERATIONS);
        return simpleHash.toString();
    }

    public static void main(String[] args) {
        System.out.println(createMd5("1"));
    }
}
