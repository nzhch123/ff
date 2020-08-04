package com.ibeetl.admin.core.entity;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import lombok.Data;
import org.beetl.sql.core.annotatoin.AutoID;
import org.beetl.sql.core.annotatoin.SeqID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ibeetl.admin.core.annotation.Dict;
import com.ibeetl.admin.core.util.ValidateConfig;
import com.ibeetl.admin.core.util.enums.CoreDictType;

/*
*   用户实体
*
*/
@Data
public class CoreUser extends BaseEntity  {

	

	@NotNull(message = "ID不能为空", groups =ValidateConfig. UPDATE.class)
	@SeqID(name = ORACLE_CORE_SEQ_NAME)
	@AutoID
	protected Long id;
	// 删除标识
	@JsonIgnore
	protected Integer delFlag= 0;
	// 创建时间

	protected Date createTime;
	

	// 登录名，编号
	@NotBlank(message = "用户编号不能为空", groups = ValidateConfig.ADD.class)
	@Null(message = "用户编号不能为空", groups = ValidateConfig.UPDATE.class)
	private String code;

	// 用户姓名
	@NotBlank(message = "用户名不能为空")
	private String name;

	// 组织机构id

	private Long orgId;

	// 密码
	@JsonIgnore
	private String password;

	protected Date trialTime;




}
