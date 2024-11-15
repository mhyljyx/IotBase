package com.tztang.pojo.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * @description  消防物联网运营服务机构表 
 * @author  tztang
 * @Date 2024-11-15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Serviceagency  implements Serializable {

	private static final long serialVersionUID =  6413255241655641495L;

	/**
	 * 运营服务机
构唯一编码
	 */
	private String id;

	/**
	 * 消防物联网运营服务机构名称
	 */
	private String serviceagencyName;

	/**
	 * 统一社会信用代码
	 */
	private String companyCode;

	/**
	 * 单位地址
	 */
	private String address;

	/**
	 * 法定代表人姓名
	 */
	private String legalRepresenName;

	/**
	 * 法定代表人身份证号码
	 */
	private String legalRepresenId;

	/**
	 * 法定代表人联系电话
	 */
	private String legalRepresenTel;

	/**
	 * 接入联网单位总数
	 */
	private Integer companyNum;

	/**
	 * 机构运营场地面积
	 */
	private Integer serviceagency_Area;

	/**
	 * 值守人员总数
	 */
	private Integer ondutyPersonNum;

	/**
	 * 运营机构责任人姓名
	 */
	private String contactName;

	/**
	 * 运营机构责任人联系电话
	 */
	private String contactTel;

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
