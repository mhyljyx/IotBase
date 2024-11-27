package com.tztang.pojo.vo;

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
public class CommunityVo implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(name ="id", dataType ="Integer", value ="互联网单位id")
	private Integer id;

	@ApiModelProperty(name ="code", dataType ="String", value ="联网单位编码")
	private String code;

	@ApiModelProperty(name ="name", dataType ="String", value ="联网单位名称")
	private String name;

	@ApiModelProperty(name ="parentId", dataType ="String", value ="运营服务机构唯一编码")
	private String parentId;

	@ApiModelProperty(name ="creditCode", dataType ="String", value ="联网单位地址编码")
	private String creditCode;

	@ApiModelProperty(name ="address", dataType ="String", value ="联网单位地址")
	private String address;

	@ApiModelProperty(name ="regionCode", dataType ="String", value ="行政区域编码")
	private String regionCode;

	@ApiModelProperty(name ="phoneNum", dataType ="String", value ="管辖单位联系电话")
	private String phoneNum;

	@ApiModelProperty(name ="managerCompany", dataType ="String", value ="管辖单位")
	private String managerCompany;

	@ApiModelProperty(name ="occaupyArea", dataType ="String", value ="单位占地面积")
	private String occaupyArea;

	@ApiModelProperty(name ="buildArea", dataType ="String", value ="总建筑面积")
	private String buildArea;

	@ApiModelProperty(name ="buildArea", dataType ="String", value ="单位类型（该巡查点位属于联网单位或住宅小区：1-联网单位，2-住宅小区）")
	private String type;

	@ApiModelProperty(name ="mapType", dataType ="Integer", value ="地图类型")
	private Integer mapType;

	@ApiModelProperty(name ="lng", dataType ="String", value ="经度")
	private String lng;

	@ApiModelProperty(name ="lat", dataType ="String", value ="维度")
	private String lat;

	@ApiModelProperty(name ="isOpen", dataType ="Boolean", value ="是否启用上传(false:关闭上传 true:开启上传)")
	private Boolean isOpen;


}
