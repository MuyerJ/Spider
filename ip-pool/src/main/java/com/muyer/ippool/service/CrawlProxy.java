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
            "http://www.ip3366.net/free/?stype=1",
            "http://www.ip3366.net/free/?stype=2",
            "http://www.66ip.cn/",
            "https://www.kuaidaili.com/free/",
            "http://www.data5u.com/"
    );

    public static void main(String[] args) {
        List<Proxy> proxyList = new ArrayList<>();
        List<String> urls = Arrays.asList(
                "http://www.ip3366.net/free/?stype=1",
                "http://www.ip3366.net/free/?stype=2"
        );
        for (String url : urls) {
            Request request = new Request();
            String content = request.get(url).getContent();
            Elements es = Jsoup.parse(content).select("#list table tr");
            es.forEach(element -> {
                Elements proxyElement = element.select("td");
                String ip = proxyElement.get(0).toString();
                int port = Integer.parseInt(proxyElement.get(1).toString());
                Proxy proxy = new Proxy(ip, port);
                proxyList.add(proxy);
                System.out.println(proxy);
            });

        }
        ;
    }
}
