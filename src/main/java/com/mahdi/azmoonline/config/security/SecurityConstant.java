package com.mahdi.azmoonline.config.security;

public class SecurityConstant {

    private SecurityConstant() {
    }

    public static String[] getPermitAllRestApis() {
        return new String[]{
                "/guest/**", "/guest/login", "/", "/auth/**"
        };
    }

    public static String[] staticFilesUrls() {
        return new String[]{
                "/assets/**", "/components/**", "/index.html"
        };
    }

    public static String[] getPermitAllUrls() {
        String[] staticFilesUrls = staticFilesUrls();
        String[] permitAllUrls = getPermitAllRestApis();

        int staticFilesUrlsLen = staticFilesUrls.length;
        int permitAllUrlsLen = permitAllUrls.length;
        String[] result = new String[staticFilesUrlsLen + permitAllUrlsLen];

        System.arraycopy(staticFilesUrls, 0, result, 0, staticFilesUrlsLen);
        System.arraycopy(permitAllUrls, 0, result, staticFilesUrlsLen, permitAllUrlsLen);

        return result;
    }
}
