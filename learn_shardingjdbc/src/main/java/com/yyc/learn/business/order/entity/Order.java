package com.yyc.learn.business.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yyc
 * @version 1.0
 * @date 2020/5/26 0026 下午 18:33
 */
@TableName("t_order")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Order implements Serializable {
    private Long id;
    private String name;
    private String type;
    private Date gmtCreate;
}
