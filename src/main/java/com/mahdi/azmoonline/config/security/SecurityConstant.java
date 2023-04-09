package com.mahdi.azmoonline.config.security;

public class SecurityConstant {

    private SecurityConstant() {

    }

    public static String[] getPermitAllUrls() {
        return new String[]{
                "/guest/**"
        };
    }

    public static String[] staticFilesUrls() {
        return new String[]{
                "/assets/**", "/components/**", "/index.html"
        };
    }
}
