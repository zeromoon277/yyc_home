package com.yyc.learn.bean;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/5/21 0021 下午 18:33
 */
@Data
@Document(indexName = "t_user")
public class User {

    @Id
    private String id;
    private String name;
    private int age = 18;
    private Date createTime = new Date();
}
