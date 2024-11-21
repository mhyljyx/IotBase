package com.tztang.pojo.entity;

import lombok.Data;
import java.io.Serializable;
import com.tztang.data.BaseTableData;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @description  订阅平台 
 * @author  tztang
 * @Date 2024-11-21
 */
@Data
@TableName("platform_dictionary")
public class PlatformDictionary extends BaseTableData implements Serializable {

	private static final long serialVersionUID =  266199334394506293L;

	/**
	 * 平台标识
	 */
	private String sign;

	/**
	 * 平台名称
	 */
	private String name;

}
