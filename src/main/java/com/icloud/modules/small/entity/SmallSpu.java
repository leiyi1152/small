package com.icloud.modules.small.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品spu
 * 
 * @author zdh
 * @email yyyyyy@cm.com
 * @date 2020-08-13 14:34:02
 */
@Data
@TableName("t_small_spu")
public class SmallSpu implements Serializable {
	private static final long serialVersionUID = 1L;

   	   /*  */
       @TableId(value="id", type= IdType.AUTO)
       private Long id;
   	   	   /* 原价(按分存) */
       @TableField("price")
       private BigDecimal price;
   	   	   /* 现价 */
       @TableField("original_price")
       private BigDecimal originalPrice;
   	   	   /* vip价 */
       @TableField("vip_price")
       private BigDecimal vipPrice;
   	   	   /* 商品名称 */
       @TableField("title")
       private String title;
   	   	   /* 销量 */
       @TableField("sales")
       private Integer sales;
   	   	   /* 商品图片 */
       @TableField("img")
       private String img;
   	   	   /* 商品详情 */
       @TableField("detail")
       private String detail;
   	   	   /* 商品描述 */
       @TableField("description")
       private String description;
   	   	   /* 分类id */
       @TableField("category_id")
       private Long categoryId;
   	   	   /* 运费模板id */
       @TableField("freight_template_id")
       private Long freightTemplateId;
   	   	   /* 计量单位 */
       @TableField("unit")
       private String unit;
   	   	   /* 0下架 1上架 */
       @TableField("status")
       private Integer status;
   	   	   /* 商户id */
       @TableField("supplier_id")
       private Long supplierId;
   	   	   /* 热门 */
       @TableField("ihot")
       private Integer ihot;
   	   	   /* 新品 */
       @TableField("inew")
       private Integer inew;
   	   	   /* 折扣 */
       @TableField("idiscount")
       private Integer idiscount;
   	   	   /* 优选 */
       @TableField("iselect")
       private Integer iselect;
   	   	   /* 创建时间 */
       @TableField("create_time")
       private Date createTime;
   	   	   /* 修改时间 */
       @TableField("modify_time")
       private Date modifyTime;
        /* 零售户id*/
        @TableField("retailer_id")
        private Long retailerId;
        /* 库存 */
        @TableField("stock")
        private Integer stock;
        /* 冻结库存 */
        @TableField("freeze_stock")
        private Integer freezeStock;
        /* 店铺个性分类id */
        @TableField("sellcategory_id")
        private Long sellcategoryId;
        /* 是否展示在烟包支付系统（1展示 0不展示） */
        @TableField("show_flag")
        private Integer showFlag;

        /*关联分类*/
        @TableField(exist = false)
        private SmallCategory smallCategory;
        /*消费商户*/
        @TableField(exist = false)
        private SmallRetail smallRetail;
        /*关联商户个性化分类*/
        @TableField(exist = false)
        private SmallSellCategory smallSellCategory;
        /*增加的库存*/
        @TableField(exist = false)
        private Integer addStock;
        /*剩余库存*/
        @TableField(exist = false)
        private Integer remainStock;
   	
}
