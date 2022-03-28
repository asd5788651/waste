package com.waste.my.util;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

import java.security.MessageDigest;

/**
 * MD5技术加密解密
 */
public class MD5Tools {
    /***
     * MD5加码 生成32位md5码
     */
    //随机生成密钥

    private final static byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();

    //构建

    private final static SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);

    public static String string2MD5(String inStr) {
//加密
        String encryptHex = aes.encryptHex(inStr);
        return encryptHex;

    }

    /**
     * 加密解密算法 执行一次加密，两次解密
     */
    public static String convertMD5(String inStr) {
        return aes.decryptStr(inStr, CharsetUtil.CHARSET_UTF_8);
    }
}