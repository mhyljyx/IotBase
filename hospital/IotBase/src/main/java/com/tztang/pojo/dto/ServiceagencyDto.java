package com.tztang.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tztang.data.BaseTableData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @description  物联网运营服务机构
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
@ApiModel("新增物联网运营服务机构DTO")
public class ServiceAgencyDto {

	@NotBlank(message = "物联网运营服务机构名称不能为空")
	@Length(max = 32, message = "物联网运营服务机构名称长度不能超过32")
	@ApiModelProperty(name ="name", dataType ="String", value ="物联网运营服务机构名称",required = true)
	private String name;

	@NotBlank(message = "统一社会信用代码不能为空")
	@Length(max = 16, message = "统一社会信用代码长度不能超过16")
	@ApiModelProperty(name ="companyCode", dataType ="String", value ="统一社会信用代码",required = true)
	private String companyCode;

	@NotBlank(message = "单位地址不能为空")
	@Length(max = 255, message = "单位地址长度不能超过255")
	@ApiModelProperty(name ="address", dataType ="String", value ="单位地址",required = true)
	private String address;

	@Length(max = 16, message = "法定代表人姓名长度不能超过16")
	@ApiModelProperty(name ="legalRepresenName", dataType ="String", value ="法定代表人姓名")
	private String legalRepresenName;

	@Length(max = 32, message = "法定代表人身份证号码长度不能超过32")
	@ApiModelProperty(name ="legalRepresenId", dataType ="String", value ="法定代表人身份证号码")
	private String legalRepresenId;

	@Length(max = 16, message = "法定代表人联系电话长度不能超过16")
	@Pattern(regexp = "^1[3-9]\\\\d{9}$", message = "法定代表人联系电话格式不正确")
	@ApiModelProperty(name ="legalRepresenTel", dataType ="String", value ="法定代表人联系电话")
	private String legalRepresenTel;

	@ApiModelProperty(name ="serviceagencyArea", dataType ="Integer", value ="机构运营场地面积")
	private Integer serviceagencyArea;

	@ApiModelProperty(name ="ondutyPersonNum", dataType ="Integer", value ="值守人员总数")
	private Integer ondutyPersonNum;

	@Length(max = 16, message = "运营机构责任人姓名长度不能超过16")
	@ApiModelProperty(name ="contactName", dataType ="String", value ="运营机构责任人姓名")
	private String contactName;

	@Length(max = 16, message = "运营机构责任人联系电话长度不能超过16")
	@Pattern(regexp = "^1[3-9]\\\\d{9}$", message = "运营机构责任人联系电话格式不正确")
	@ApiModelProperty(name ="contactTel", dataType ="String", value ="运营机构责任人联系电话")
	private String contactTel;

	@Length(max = 255, message = "ak长度不能超过255")
	@ApiModelProperty(name ="ak", dataType ="String", value ="ak:用于生成token")
	private String ak;

	@Length(max = 255, message = "sk长度不能超过255")
	@ApiModelProperty(name ="sk", dataType ="String", value ="sk:用于生成token")
	private String sk;

}
