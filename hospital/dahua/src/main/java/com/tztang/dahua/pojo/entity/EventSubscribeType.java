package com.tztang.dahua.pojo.entity;

import com.tztang.data.BaseTableData;
import lombok.Data;

import java.io.Serializable;

/**
 * @description  事件订阅类型关联表 
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
public class EventSubscribeType extends BaseTableData implements Serializable {

	private static final long serialVersionUID =  6211828511225266788L;

	/**
	 * 事件订阅id一致
	 */
	private Integer subscribeId;

	/**
	 * 事件订阅名称
	 */
	private String subscribeName;

	/**
	 * 事件类型
	 */
	private String type;

}
