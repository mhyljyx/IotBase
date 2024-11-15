package com.tztang.pojo.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @description  事件订阅表 
 * @author  tztang
 * @Date 2024-11-15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventSubscribe  implements Serializable {

	private static final long serialVersionUID =  3270385936465538299L;

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

	/**
	 * 更新时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date updateTime;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createTime;

	/**
	 * 0:正常 1:删除
	 */
	private Integer isDel;

}
