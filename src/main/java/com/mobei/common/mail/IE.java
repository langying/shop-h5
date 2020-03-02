package com.mobei.common.mail;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class IE {

    private static final Log log = LogFactory.getLog(IE.class);

    public static final int TIME_OUT = 60000;

    public static final int GET = 0;
    public static final int POST = 1;

    public static final String HOST = "Host";
    public static final String COOK = "Cookie";
    public static final String REFE = "Referer";
    public static final String USER = "User-Agent";

    public static final String kHTML = "text/html;charset=UTF-8";
    public static final String kTEXT = "text/plain;charset=UTF-8";
    public static final String kJSON = "application/json;charset=UTF-8";

    public static String get(String url, Map<String, String> headers) {
        String ret = null;
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;

        try {
            Builder config = RequestConfig.custom();
            config.setCookieSpec(CookieSpecs.STANDARD);
            config.setSocketTimeout(TIME_OUT).setConnectTimeout(TIME_OUT).setConnectionRequestTimeout(TIME_OUT);
            client = HttpClients.custom().setDefaultRequestConfig(config.build()).build();

            HttpGet http = new HttpGet(url);
            if (headers == null) {
                headers = new HashMap<>();
            }
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                http.addHeader(entry.getKey(), entry.getValue());
            }
            response = client.execute(http);
            int code = response.getStatusLine().getStatusCode();
            String msg = response.getStatusLine().getReasonPhrase();
            if (code == HttpStatus.SC_OK) {
                ret = EntityUtils.toString(response.getEntity(), "utf-8");
            }
            else {
                log.info(FF.log("url:{} failure. msg:{}, code:{}", url, msg, code));
            }
        }
        catch (Exception e) {
            log.info(FF.log("url:{} exception:{}", url, e.getMessage()));
        }
        finally {
            IO.close(response, client);
        }
        return ret;
    }

    public static String get(String uri, Map<String, String> head, Map<String, String> data) {
        String ret = null;
        try {
            HttpRequestBase http = makeRequest(true, uri, head, data);
            ret = doRequest(http);
            http.releaseConnection();
        }
        catch (Exception e) {
            log.info(FF.log("uri:{} exception:{}", uri, e.getMessage()), e);
        }
        return ret;
    }

    public static String post(String uri, Map<String, String> head, String body) {
        String ret = null;
        try {
            HttpPost http = new HttpPost(uri);
            http.setEntity(new StringEntity(body, "UTF-8"));
            IO.forEach(head, (key, val, idx, stop) -> {
                http.setHeader(key, val);
            });

            ret = doRequest(http);
            http.releaseConnection();
        }
        catch (Exception e) {
            log.info(FF.log("uri:{} exception:{}", uri, e.getMessage()), e);
        }
        return ret;
    }

    public static String post(String uri, Map<String, String> head, Map<String, String> data) {
        String ret = null;
        try {
            HttpRequestBase http = makeRequest(false, uri, head, data);
            ret = doRequest(http);
            http.releaseConnection();
        }
        catch (Exception e) {
            log.info(FF.log("uri:{} exception:{}", uri, e.getMessage()), e);
        }
        return ret;
    }

    private static HttpRequestBase makeRequest(boolean GET, String url, Map<String, String> head, Map<String, String> data) throws Exception {
        List<NameValuePair> nvps = new ArrayList<>();
        IO.forEach(data, (key, val, idx, stop) -> {
            nvps.add(new BasicNameValuePair(key, val));
        });

        HttpRequestBase http = null;
        if (GET) {
            URI uri = new URIBuilder(url).setParameters(nvps).build();
            http = new HttpGet(uri);
        }
        else {
            http = new HttpPost(url);
            ((HttpPost) http).setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
        }

        final HttpRequestBase base = http;
        IO.forEach(head, (key, val, idx, stop) -> {
            base.addHeader(key, val);
        });
        return http;
    }

    private static String doRequest(HttpRequestBase http) throws ClientProtocolException, IOException {
        String ret = null;
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;

        try {
            Builder config = RequestConfig.custom();
            config.setCookieSpec(CookieSpecs.STANDARD);
            config.setSocketTimeout(TIME_OUT).setConnectTimeout(TIME_OUT).setConnectionRequestTimeout(TIME_OUT);
            client = HttpClients.custom().setDefaultRequestConfig(config.build()).build();
            response = client.execute(http);
            response.setLocale(Locale.CHINESE);
            int code = response.getStatusLine().getStatusCode();
            String msg = response.getStatusLine().getReasonPhrase();
            if (code == HttpStatus.SC_OK) {
                ret = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
            else {
                log.info(FF.log("uri:{} failure. msg:{}, code:{}", http.getURI(), msg, code));
            }
        }
        finally {
            IO.close(response, client);
        }
        return ret;
    }
}
