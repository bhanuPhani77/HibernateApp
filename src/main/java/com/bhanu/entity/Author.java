package com.bhanu.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AUTHOR")
public class Author{

	@Id
	@Column(name = "AUTHOR_ID")
	private Integer authorId;
	
	@Column(name = "AUTHORNAME")
	private String authorName;

}
