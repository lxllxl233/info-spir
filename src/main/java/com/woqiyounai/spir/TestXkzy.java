package com.woqiyounai.spir;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TestXkzy {
    public static void main(String[] args) {
        String[] strs = {"","1"};
        String baseUrl = "http://dept7.guat.edu.cn/";
        //Notice 通知
        try {
            for (String str : strs) {
                String url = "";
                if (str.length() != 0) {
                    url = "http://dept7.guat.edu.cn/xkzy/" + str + ".htm";
                }else {
                    url = "http://dept7.guat.edu.cn/xkzy.htm";
                }
                Document document = Jsoup.connect(url).get();
                Elements select = document.body().select("a[href][target]");
                for (Element element : select) {
                    String u = baseUrl+element.attr("href");
                    u = u.replaceAll("\\.\\./","");
                    String[] split = u.split("/");
                    String num = split[split.length - 1];
                    num = num.substring(0,num.indexOf("."));
                    String nums = "http://dept7.guat.edu.cn/system/resource/code/news/click/dynclicks.jsp?clickid="+num+"&owner=1294169589&clicktype=wbnews";
                    try {
                        Document art = Jsoup.connect(u).get();
                        Elements form = art.select("form");
                        Elements h1 = form.select("h1");
                        Elements text = form.select("div[id=vsb_content]");
                        if (text.isEmpty()){
                            text = form.select("div[id=vsb_content_2]");
                        }
                        System.out.println("======================");
                        System.out.println(form.select("div[align=center]"));
                        System.out.println(Jsoup.connect(nums).get().text());
                        System.out.println(h1+"\n"+text);
                        System.out.println("======================");
                    }catch (Exception e){
                        System.out.println(u);
                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
