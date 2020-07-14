package com.muyer.httpclient.demo;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: <br/>
 * 获得HttpClient的方式有很多：
 *  1.常见的有通过HttpClients这个类
 *  2.通过HttpClientBuilder这个工厂
 * date: 2020/7/14 23:40<br/>
 *
 * @author MuyerJ<br />
 */
public class GetParamsDemo {
    public static void main(String[] args) throws IOException, URISyntaxException {
//        appendUrl();
        byNameValuePair();
    }

    public static void appendUrl() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        String params = "wd="+ URLEncoder.encode("杭州什么爱下雨","utf-8");

        HttpGet httpGet = new HttpGet("http://www.baidu.com/s" + "?" + params);

        CloseableHttpResponse response = httpClient.execute(httpGet);

        HttpEntity entity = response.getEntity();
        System.out.println(EntityUtils.toString(entity));
        System.out.println(response.getStatusLine());

        httpClient.close();
        response.close();
    }

    public static void byNameValuePair() throws URISyntaxException, IOException {
        CloseableHttpClient httpClient = HttpClients.custom().build();

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("wd", URLEncoder.encode("杭州什么爱下雨","utf-8")));
        URI uri = new URIBuilder("http://www.baidu.com/s").addParameters(params).build();

        HttpGet httpGet = new HttpGet(uri);

        //httpGet.setConfig(RequestConfig.custom().build());
        httpGet.setConfig(RequestConfig.custom()
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setSocketTimeout(5000)
                .setRedirectsEnabled(true)
                .build());

        CloseableHttpResponse response = httpClient.execute(httpGet);

        HttpEntity entity = response.getEntity();
        System.out.println(EntityUtils.toString(entity));
        System.out.println(response.getStatusLine());

        httpClient.close();
        response.close();
    }
}
