package com.muyer.ippool.service;

import com.muyer.crawl.model.Proxy;
import com.muyer.crawl.util.Request;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: <br/>
 * date: 2020/8/10 23:03<br/>
 *
 * @author MuyerJ<br               />
 */
public class CrawlProxy {

    List<String> urlList = Arrays.asList(
            "http://www.66ip.cn/",
            "https://www.kuaidaili.com/free/",
            "http://www.data5u.com/"
    );

    public static void main(String[] args) {

    }
}
