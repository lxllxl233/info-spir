package com.woqiyounai.controller;

import com.woqiyounai.entity.ArticleEntity;
import com.woqiyounai.resp.ResponseUtil;
import com.woqiyounai.service.ArticleService;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService service;
    //获取分类

    @ApiOperation("获取分类")
    @GetMapping("/api/article/sort")
    public ResponseUtil getSort(){
        Map<String,String> map = new HashMap<>();
        map.put("bmgk","部门概况");
        map.put("djgz","党建工作");
        map.put("jxky","教学科研");
        map.put("tzgg","通知公告");
        map.put("txgz","团学工作");
        map.put("xkzy","学科专业");
        map.put("xyxw","学院新闻");
        return ResponseUtil.ok("获取成功").data("sort",map);
    }
    //获取文章
    @ApiOperation("获取文章")
    @GetMapping("/api/article/article")
    public ResponseUtil getSort(String sort,Integer currentPage,Integer maxSize) {
        List<ArticleEntity> list = service.filter(sort,currentPage,maxSize);
        Integer count = service.getCount(sort);
        return ResponseUtil.ok("获取成功").data("all",list).data("count",count);
    }

}















