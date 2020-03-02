package com.mobei.common.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class Http {

    public static final String kUserAgent = "user-agent";

    public static HttpServletRequest request() {
        RequestAttributes bean = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) bean).getRequest();
        return request;
    }

    public static String getUserAgent() {
        try {
            return request().getHeader(kUserAgent);
        }
        catch (Exception e) {
            return null;
        }
    }

    public static String getDevInfo() {
        try {
            HttpServletRequest request = request();
            String ip = getIP(request);
            String ua = request.getHeader(kUserAgent);
            return ip + " " + ua;
        }
        catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    public static String getIP(HttpServletRequest request) {
        String ip = null;
        do {
            ip = request.getHeader("x-forwarded-for");
            if (available(ip)) {
                break;
            }
            ip = request.getHeader("Proxy-Client-IP");
            if (available(ip)) {
                break;

            }
            ip = request.getHeader("WL-Proxy-Client-IP");
            if (available(ip)) {
                break;
            }
            ip = request.getHeader("HTTP_CLIENT_IP");
            if (available(ip)) {
                break;
            }
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            if (available(ip)) {
                break;
            }
            ip = request.getRemoteAddr();
            if (available(ip)) {
                break;
            }
            ip = "127.0.0.1";
        } while (false);
        return ip;
    }

    private static boolean available(String ip) {
        if (ip == null || ip.length() <= 0) {
            return false;
        }
        if ("unknown".equalsIgnoreCase(ip)) {
            return false;
        }
        if ("0:0:0:0:0:0:0:1".equals(ip)) {
            return false;
        }
        return true;
    }

}
