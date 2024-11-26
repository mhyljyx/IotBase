package com.tztang.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tztang.data.BaseTableData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description  物联网运营服务机构表
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
@TableName("serviceagency")
public class ServiceagencyDo extends BaseTableData implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 运营服务机构唯一编码
	 */
	private String id;

	/**
	 * 消防物联网运营服务机构名称
	 */
	private String name;

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
	private Integer serviceagencyArea;

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
	 * ak:用于生成token
	 */
	private String ak;

	/**
	 * sk:用于生成token
	 */
	private String sk;

}
