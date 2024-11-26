package com.tztang.pojo.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tztang.data.BaseTableData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description  物联网运营服务机构Vo
 * @author  tztang
 * @Date 2024-11-26
 */
@Data
public class ServiceagencyVo implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name ="id", dataType ="String", value ="运营服务机构唯一编码")
	private String id;

	@ApiModelProperty(name ="serviceagencyName", dataType ="String", value ="物联网运营服务机构名称")
	private String name;

	@ApiModelProperty(name ="companyCode", dataType ="String", value ="统一社会信用代码")
	private String companyCode;

	@ApiModelProperty(name ="address", dataType ="String", value ="单位地址")
	private String address;

	@ApiModelProperty(name ="legalRepresenName", dataType ="String", value ="法定代表人姓名")
	private String legalRepresenName;

	@ApiModelProperty(name ="legalRepresenId", dataType ="String", value ="法定代表人身份证号码")
	private String legalRepresenId;

	@ApiModelProperty(name ="legalRepresenTel", dataType ="String", value ="法定代表人联系电话")
	private String legalRepresenTel;

	@ApiModelProperty(name ="companyNum", dataType ="Integer", value ="接入联网单位总数")
	private Integer companyNum;

	@ApiModelProperty(name ="serviceagencyArea", dataType ="Integer", value ="机构运营场地面积")
	private Integer serviceagencyArea;

	@ApiModelProperty(name ="ondutyPersonNum", dataType ="Integer", value ="值守人员总数")
	private Integer ondutyPersonNum;

	@ApiModelProperty(name ="contactName", dataType ="String", value ="运营机构责任人姓名")
	private String contactName;

	@ApiModelProperty(name ="contactTel", dataType ="String", value ="运营机构责任人联系电话")
	private String contactTel;

	@ApiModelProperty(name ="ak", dataType ="String", value ="ak:用于生成token")
	private String ak;

	@ApiModelProperty(name ="sk", dataType ="String", value ="sk:用于生成token")
	private String sk;

}
