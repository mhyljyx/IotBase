package com.tztang.dahua.pojo.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tztang.data.BaseTableData;
import lombok.Data;

/**
 * @description  事件订阅表 
 * @author  tztang
 * @Date 2024-11-06
 */
@Data
@TableName("event_subscribe")
public class EventSubscribe extends BaseTableData implements Serializable {

	private static final long serialVersionUID =  8735731648238061419L;

	@TableId(type = IdType.AUTO)
	private Integer id;

	/**
	 * 事件订阅名称
	 */
	private String name;

	/**
	 * 事件大类
	 */
	private String category;

	/**
	 * 接收方ip
	 */
	private String ip;

	/**
	 * 接收方port
	 */
	private Integer port;

	/**
	 * 0未取消 1已取消
	 */
	private Integer status;

	/**
	 * 订阅平台
	 */
	private String platform;

}
