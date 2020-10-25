package com.woqiyounai.spir;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Tes> strs = new ArrayList<>();
        strs.add(new Tes());
        strs.add(new Tes());
        strs.forEach(e-> System.out.println(e._a+e._b));
    }
}

class Tes{
    String _a = "01";
    String _b = "02";
    String _c = "03";
}
