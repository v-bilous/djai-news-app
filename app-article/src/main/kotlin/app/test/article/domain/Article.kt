package app.test.article.domain

import app.test.domain.BaseDomain
import app.test.domain.History
import org.hibernate.annotations.Type
import com.fasterxml.jackson.annotation.*
import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* An Article model
* @param authors 
* @param keywords 
* @param history 
* @param textContent 
* @param shortDescription 
* @param header 
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"], comments = "version:")

@JsonPropertyOrder("id", "authors", "keywords", "history", "textContent", "shortDescription", "header")

@Entity
@Table(name = "article")
data class Article(

	@Type(type = "json")
	@Column(name = "authors", columnDefinition = "json")
	var authors: List<String>?,

	@Type(type = "json")
	@Column(name = "keywords", columnDefinition = "json")
	var keywords: List<String>?,

	@AttributeOverrides(
		AttributeOverride(name = "createdBy", column = Column(name = "created_by")),
		AttributeOverride(name = "updatedBy", column = Column(name = "updated_by")),
		AttributeOverride(name = "createdOn", column = Column(name = "created_on")),
		AttributeOverride(name = "updatedOn", column = Column(name = "updated_on")),
	)
	@Embedded
	var history: History?,

	@Column(name = "text_content")
	var textContent: String?,

	@Column(name = "short_description")
	var shortDescription: String?,

	@Column(name = "header")
	var header: String?

) : BaseDomain()

