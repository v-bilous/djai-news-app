package app.test.domain

import javax.persistence.*
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption

/**
* A history properties of an entity
* @param createdBy 
* @param updatedBy 
* @param createdOn 
* @param updatedOn 
*/
@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Embeddable
data class History(

	@Column(name = "created_by")
	var createdBy: String? = null,

	@Column(name = "updated_by")
	var updatedBy: String? = null,

	@Column(name = "created_on")
	var createdOn: String? = null,

	@Column(name = "updated_on")
	var updatedOn: String? = null

) 

