package com.website.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
public class Cplatest implements Serializable {

	private static final long serialVersionUID = -8634459362746715180L;

	@Id
	@GeneratedValue
	private Integer id;

	private Integer typeid;

	private String no;

	private String nums;

	private String specialnums;

	private String createtime;

	private String opendate;

	private String img;

	private String status;

	private BigDecimal money;

	private String comment;

	private Integer newno; // 最新一期开奖的期号是当天的第几期
	
	/***
	 * 下一期
	 */
	private Integer nextno;

}