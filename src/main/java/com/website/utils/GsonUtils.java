package com.website.utils;

import com.website.dto.CpDto;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by letrain on 2017/11/18.
 */
public class GsonUtils {
    private static String URL = "http://c.apiplus.net/newly.do?token=t6ef89568868527f9k&format=xml";
    private static List<CpDto> cpDtoList;
    static {
        cpDtoList = new ArrayList<>();

    }
    public static List<CpDto> getResult(){
        Connection connection = Jsoup.connect(URL);
        connection.timeout(3000);
        try {
            Document document =  connection.get();
            Elements elements = document.select("row");
            for (Element element : elements){
                CpDto cpDto = new CpDto();
                cpDto.setCode(element.attr("code"));
                cpDto.setExpect(element.attr("expect"));
                cpDto.setOpencode(element.attr("opencode"));
                cpDto.setOpentime(element.attr("opentime"));
                cpDtoList.add(cpDto);
            }
            return cpDtoList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) {
//        System.out.println(GsonUtils.getResult());
//    }
}
