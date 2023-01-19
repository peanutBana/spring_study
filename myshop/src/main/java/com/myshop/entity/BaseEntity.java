package com.myshop.entity;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@EntityListeners(value = {AuditingEntityListener.class})	//Auditing을 적용하기 위해
@MappedSuperclass		//부모 클래스를 상속받는 자식 클래스에게 매핑정보만 제공
@Getter
@Setter
public class BaseEntity extends BaseTimeEntity{
	
	@CreatedBy
	@Column(updatable = false)
	private String createdBy;	//등록자
	
	@LastModifiedBy
	private String modifiedBy;	//수정자

}
