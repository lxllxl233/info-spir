package com.woqiyounai;

import com.woqiyounai.entity.ArticleEntity;
import com.woqiyounai.service.ArticleService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class TemplateTests {

    @Autowired
    ArticleService service;

    @Test
    void contextLoads() {
        System.out.println(service.getCount("tzgg"));
    }


    @Test
    void contextLoadsTest() {
        List<ArticleEntity> list = new ArrayList<>();
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
                        ArticleEntity entity = new ArticleEntity();

                        Document art = Jsoup.connect(u).get();
                        Elements dl = art.body().select("dl");
                        entity.setTitle(dl.select("h1").text());
                        String vsb = dl.select("div[id=vsb_content]")+"";
                        if (vsb.isEmpty()){
                            vsb = dl.select("div[id=vsb_content_2]")+"";
                        }
                        entity.setText(vsb);
                        entity.setReadNum(Jsoup.connect(nums).get().text());
                        entity.setType("xkzy");
                        entity.setArtId(Integer.valueOf(num));
                        list.add(entity);
                    }catch (Exception e){
                        System.out.println(u);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        service.saveBatch(list);
    }

}