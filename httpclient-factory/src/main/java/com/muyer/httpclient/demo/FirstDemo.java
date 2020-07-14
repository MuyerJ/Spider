package com.muyer.httpclient.demo;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 * Description: <br/>
 * date: 2020/7/14 23:20<br/>
 *
 * @author MuyerJ<br   />
 */
public class FirstDemo {

    public static void main(String[] args) throws Exception {
        myFirstHttpClientDemo();
    }

    public static void myFirstHttpClientDemo() throws Exception {
        //第一步：获取一个Http的客户端
        //HttpClients.createDefault();
        CloseableHttpClient client = HttpClientBuilder.create().build();

        //第二步：创建请求（GET/Post）
        HttpGet httpGet = new HttpGet("http://www.baidu.com");

        //第三步：请求，获取相应模型
        CloseableHttpResponse httpResponse = client.execute(httpGet);

        HttpEntity entity = httpResponse.getEntity();
        System.out.println(EntityUtils.toString(entity));
        System.out.println(entity.getContentType());
        System.out.println(httpResponse.getStatusLine());

        //第四步：释放资源
        client.close();
        if (httpResponse != null) {
            httpResponse.close();
        }
    }
}
