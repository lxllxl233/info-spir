package com.woqiyounai.mapper;

import com.woqiyounai.entity.ArticleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface ArticleMapper extends BaseMapper<ArticleEntity> {

    List<ArticleEntity> filter(String sort, Integer currentPage, Integer maxSize);

    Integer getCount(String sort);
}