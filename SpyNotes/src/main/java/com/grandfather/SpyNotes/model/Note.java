package com.grandfather.SpyNotes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Note")
public class Note 
{
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_gen")
	@SequenceGenerator(name = "note_gen", sequenceName = "note_seq")
	private long id;
	
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
	
	public void setId(long id)
	{
		this.id = id;
	}
	
	public long getId()
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
