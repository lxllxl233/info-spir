package com.woqiyounai.service;

import com.woqiyounai.entity.ArticleEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ArticleService extends IService<ArticleEntity> {

    List<ArticleEntity> filter(String sort, Integer currentPage, Integer maxSize);

    Integer getCount(String sort);
}