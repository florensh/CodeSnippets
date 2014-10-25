package de.hhn.labswps.ouh.codesnippet.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table( name = "snippets" )
public class Snippet {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Long id;
	
    public Long getId() {
        return id;
    }
	
	public void setId(Long id) {
		this.id = id;
	}

	private String language;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
