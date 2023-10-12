package app.test.article.controller

import app.test.article.domain.Article
import app.test.article.service.DefaultService
import app.test.article.controller.api.DefaultApi
import app.test.controller.AbstractController
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@RestController
class DefaultController(service: DefaultService)
    : AbstractController<Article, DefaultService>(service), DefaultApi {


    override fun createArticle(
			@RequestBody article: Article): ResponseEntity<Article> {
        return super.create(article)
    }

    override fun deleteArticle(
			@PathVariable("articleId") articleId: Int): ResponseEntity<Article> {
        return super.delete(articleId)
    }

    override fun getArticle(
			@PathVariable("articleId") articleId: Int): ResponseEntity<Article> {
        return super.getById(articleId)
    }

    override fun getArticles(
			@PageableDefault(value=0, size = 50, sort=["id"], direction = Sort.Direction.ASC) page: Pageable): ResponseEntity<Page<Article>> {
        return getAll(search, page)
    }

    override fun updateArticle(
			@PathVariable("articleId") articleId: Int,
			@RequestBody article: Article): ResponseEntity<Article> {
        return super.update(articleId, article)
    }

}
