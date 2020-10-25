package com.woqiyounai.service.impl;

import com.woqiyounai.entity.ArticleEntity;
import com.woqiyounai.mapper.ArticleMapper;
import com.woqiyounai.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, ArticleEntity> implements ArticleService {

    @Autowired
    private ArticleMapper mapper;
    @Override
    public List<ArticleEntity> filter(String sort, Integer currentPage, Integer maxSize) {
        List<ArticleEntity> list = mapper.filter(sort,currentPage,maxSize);
        return list;
    }

    @Override
    public Integer getCount(String sort) {
        Integer count = mapper.getCount(sort);
        return count;
    }
}