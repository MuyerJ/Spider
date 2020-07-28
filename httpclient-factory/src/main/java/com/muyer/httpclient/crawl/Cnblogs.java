package com.muyer.httpclient.crawl;

import com.muyer.httpclient.model.CnBlogModel;
import com.muyer.httpclient.util.Request;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 * date: 2020/7/28 23:36
 *
 * @author MuyerJ
 */
public class Cnblogs {
    static HashMap headers = new HashMap() {
        {
            put("X-Requested-With", "XMLHttpRequest");
            put("Accept", "text/plain, */*; q=0.01");
            put("Referer", "https://www.cnblogs.com/cate/java/");
            put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
        }
    };

    public static void main(String[] args) {
        String content = new Request().get("https://www.cnblogs.com/AllBloggers.aspx").getContent();
        List<CnBlogModel> result = Jsoup.parse(content)
                .select("tbody td")
                .stream()
                .map(model -> {
                    CnBlogModel cnBlogModel = new CnBlogModel();
                    cnBlogModel.setName(model.text());
                    cnBlogModel.setUrl(model.attr("href"));
                    return cnBlogModel;
                })
                .collect(Collectors.toList());
        System.out.println(result.size());
    }

    private static void getExpertUserList() {
        Request request = new Request();
        String content = request.get("https://www.cnblogs.com/expert/").setRequestHeadersMap(headers).getContent();
        Elements es = Jsoup.parse(content).select("#blogger_list ul li a");
        List<CnBlogModel> result = new ArrayList<>();
        for (Element e : es) {
            CnBlogModel cnBlogModel = new CnBlogModel();
            cnBlogModel.setName(e.text());
            cnBlogModel.setUrl(e.attr("href"));
            result.add(cnBlogModel);
        }
        System.out.println(result);
    }


}
