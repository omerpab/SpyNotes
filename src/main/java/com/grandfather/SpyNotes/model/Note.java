package com.grandfather.SpyNotes.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Note")
public class Note 
{
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	
	@Column(name = "text", length = 200, nullable = false)
	private String text;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "lifeTime", nullable = false)
	private LifeTime lifeTime;
	
	@Column(name = "password", length = 64)
    private String password;
	
	@Column(name = "email", length = 30)
	private String email;
	
	public Note()
	{
		lifeTime = LifeTime.MOMENT;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getId()
	{
		return id;
	}

	public void setText(String text)
	{
		this.text = text;
	}
	
	public String getText()
	{
		return text;
	}
	
	public void setLifeTime(LifeTime lifeTime)
	{
		this.lifeTime = lifeTime;
	}
	
	public LifeTime getLifeTime()
	{
		return lifeTime;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getEmail()
	{
		return email;
	}
}
