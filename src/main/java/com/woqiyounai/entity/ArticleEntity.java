package com.woqiyounai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableName;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("article")
public class ArticleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "")
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	@ApiModelProperty(value = "")
	private String title;
	@ApiModelProperty(value = "")
	private String text;
	@ApiModelProperty(value = "")
	private String readNum;
	@ApiModelProperty(value = "")
	private String type;
	@ApiModelProperty(value = "")
	private Integer artId;

}