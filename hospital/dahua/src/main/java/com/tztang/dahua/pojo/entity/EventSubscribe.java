package com.tztang.dahua.pojo.entity;

import com.tztang.data.BaseTableData;
import lombok.Data;

import java.io.Serializable;

/**
 * @description  事件订阅表 
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
public class EventSubscribe extends BaseTableData implements Serializable {

	private static final long serialVersionUID =  404033696802985487L;

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
