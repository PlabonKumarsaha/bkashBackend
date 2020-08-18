package com.bikash.bikashBackend.util;

public class UrlUtil {
    private static String allPrefix = "/*";
    public static String permitAllUrl[] = {
            UrlConstraint.AuthManagement.ROOT + allPrefix,
            UrlConstraint.CustomerManagement.ROOT + UrlConstraint.CustomerManagement.CREATE,
            UrlConstraint.ProductManagement.ROOT + UrlConstraint.ProductManagement.GET,
            UrlConstraint.ProductManagement.ROOT + UrlConstraint.ProductManagement.GET_ALL
    };
}
