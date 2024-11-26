package com.tztang.pojo.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tztang.data.BaseTableData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @description  互联网单位信息
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
@ApiModel("新增互联网单位信息DTO")
public class CommunityDto {

	@NotBlank(message = "联网单位编码不能为空")
	@Length(max = 32, message = "联网单位编码长度不能超过32")
	@ApiModelProperty(name ="code", dataType ="String", value ="联网单位编码",required = true)
	private String code;

	@NotBlank(message = "联网单位名称不能为空")
	@Length(max = 16, message = "联网单位名称长度不能超过16")
	@ApiModelProperty(name ="name", dataType ="String", value ="联网单位名称",required = true)
	private String name;

	@NotBlank(message = "运营服务机构唯一编码不能为空")
	@Length(max = 32, message = "运营服务机构唯一编码长度不能超过32")
	@ApiModelProperty(name ="parentId", dataType ="String", value ="运营服务机构唯一编码",required = true)
	private String parentId;

	@NotBlank(message = "联网单位地址编码不能为空")
	@Length(max = 32, message = "联网单位地址编码长度不能超过32")
	@ApiModelProperty(name ="creditCode", dataType ="String", value ="联网单位地址编码",required = true)
	private String creditCode;

	@NotBlank(message = "联网单位地址不能为空")
	@Length(max = 64, message = "联网单位地址长度不能超过64")
	@ApiModelProperty(name ="address", dataType ="String", value ="联网单位地址",required = true)
	private String address;

	@NotBlank(message = "行政区域编码不能为空")
	@Length(max = 16, message = "行政区域编码长度不能超过16")
	@ApiModelProperty(name ="regionCode", dataType ="String", value ="行政区域编码",required = true)
	private String regionCode;

	@NotBlank(message = "管辖单位联系电话不能为空")
	@Length(max = 16, message = "管辖单位联系电话长度不能超过16")
	@ApiModelProperty(name ="phoneNum", dataType ="String", value ="管辖单位联系电话",required = true)
	private String phoneNum;

	@NotBlank(message = "管辖单位不能为空")
	@Length(max = 32, message = "管辖单位长度不能超过32")
	@ApiModelProperty(name ="managerCompany", dataType ="String", value ="管辖单位",required = true)
	private String managerCompany;

	@Length(max = 16, message = "单位占地面积长度不能超过16")
	@ApiModelProperty(name ="occaupyArea", dataType ="String", value ="单位占地面积")
	private String occaupyArea;

	@Length(max = 16, message = "总建筑面积长度不能超过16")
	@ApiModelProperty(name ="buildArea", dataType ="String", value ="总建筑面积")
	private String buildArea;

	@Length(max = 16, message = "单位类型长度不能超过16")
	@ApiModelProperty(name ="buildArea", dataType ="String", value ="单位类型（该巡查点位属于联网单位或住宅小区：1-联网单位，2-住宅小区）")
	private String type;

	@ApiModelProperty(name ="mapType", dataType ="Integer", value ="地图类型")
	private Integer mapType;

	@Length(max = 16, message = "经度长度不能超过16")
	@ApiModelProperty(name ="lng", dataType ="String", value ="经度")
	private String lng;

	@Length(max = 16, message = "维度长度不能超过16")
	@ApiModelProperty(name ="lat", dataType ="String", value ="维度")
	private String lat;

	@ApiModelProperty(name ="isOpen", dataType ="Boolean", value ="是否启用上传(false:关闭上传 true:开启上传)")
	private Boolean isOpen;

}
