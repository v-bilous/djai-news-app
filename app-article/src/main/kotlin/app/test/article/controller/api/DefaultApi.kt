package app.test.article.controller.api

import app.test.article.domain.Article
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import io.swagger.annotations.ApiParam
import org.springframework.http.HttpStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Api(value = "Default", tags = ["Default"], description = "the Default API")
interface DefaultApi {

	@ApiOperation(value = "Create a Article", nickname = "createArticle", notes = "Creates a new instance of a `Article`.", tags=)
	@ApiResponses(
		ApiResponse(code = 201, message = "Successful response.")
	)
	@PostMapping("/articles")
	fun createArticle(
			@RequestBody article: Article): ResponseEntity<Article> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	@ApiOperation(value = "Delete a Article", nickname = "deleteArticle", notes = "Deletes an existing `Article`.", tags=)
	@ApiResponses(
		ApiResponse(code = 204, message = "Successful response.")
	)
	@DeleteMapping("/articles/{articleId}")
	fun deleteArticle(
			@PathVariable("articleId") articleId: Int): ResponseEntity<Article> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	@ApiOperation(value = "Get a Article", nickname = "getArticle", notes = "Gets the details of a single instance of a `Article`.", tags=)
	@ApiResponses(
		ApiResponse(code = 200, message = "Successful response - returns a single `Article`.")
	)
	@GetMapping("/articles/{articleId}")
	fun getArticle(
			@PathVariable("articleId") articleId: Int): ResponseEntity<Article> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	@ApiOperation(value = "List All Articles", nickname = "getArticles", notes = "Gets a list of all `Article` entities.", tags=)
	@ApiResponses(
		ApiResponse(code = 200, message = "Successful response - returns an array of `Article` entities.")
	)
	@GetMapping("/articles")
	fun getArticles(
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Article>> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

	@ApiOperation(value = "Update a Article", nickname = "updateArticle", notes = "Updates an existing `Article`.", tags=)
	@ApiResponses(
		ApiResponse(code = 202, message = "Successful response.")
	)
	@PutMapping("/articles/{articleId}")
	fun updateArticle(
			@PathVariable("articleId") articleId: Int,
			@RequestBody article: Article): ResponseEntity<Article> {
		return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
	}

}
