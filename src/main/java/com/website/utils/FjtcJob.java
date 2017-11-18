package com.website.utils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

/**
 * Created by letrain on 2017/11/14.
 */
@EnableScheduling
public class FjtcJob {




    @Scheduled(fixedRate = 1000*60*10,initialDelay = 1000*60*10)
    public static void getContent(){
        try {
//            URL url = new URL("http://www.fjtc.com.cn/Notice-3607");
//            URLConnection connection =  url.openConnection();
            Connection connection = Jsoup.connect("http://www.fjtc.com.cn/Notice-3607");
            connection.timeout(5000);
            Document document = connection.get();

            Elements elements =  document.select(".tInfo");
            Document infodoc = Jsoup.parse(elements.toString());
            Elements spans = infodoc.getElementsByClass("fc-red");
            for(int i = 0;i<5;i++){
                String content = spans.get(i).select("span").text();
                System.out.println(content);
            }
           List<Element> list = spans.subList(0,5);
            list.get(0);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
