package com.ahea.nurikabe.member;

import lombok.Data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="member")
@Data
public class Member {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
	@Column(length = 20, nullable = false)
	private String userId;
	
	@Column(length = 20, nullable = false)
	private String userPassword;
	
	@CreationTimestamp
	private Date joinDate;
    

	public Member(Integer id, String userId, String userPassword) {
		this.id 			= id;
		this.userId 		= userId;
		this.userPassword 	= userPassword;
	}
	
}
