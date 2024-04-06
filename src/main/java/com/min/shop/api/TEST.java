package com.min.shop.api;

public class TEST {
    public static void main(String[] args) {
        String add = "https://naver.com;";
        String pattern = "^(https?://)?([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
        boolean matches = add.matches(pattern);
        System.out.println(matches);
    }
}
