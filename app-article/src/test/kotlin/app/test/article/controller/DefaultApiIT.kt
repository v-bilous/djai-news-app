package app.test.article.controller

import app.test.article.domain.Article
import app.test.domain.History
import app.test.article.ArticleApplication
import app.test.article.repository.DefaultRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MvcResult
import org.springframework.util.LinkedMultiValueMap
import java.util.*
import kotlin.test.*

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [ArticleApplication::class])
@AutoConfigureMockMvc
class DefaultApiIT : AbstractIntegrationTest<Article>() {

	private val url = "/articles"

	@Autowired
	lateinit var repository: DefaultRepository

	@Test
	fun `createArticle with required fields`() {
		val res = createWithRequiredFields()
		val result = super.create(url, res)
		val savedRes = repository.getById(findIdentityId(result))
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `createArticle with all fields`() {
		val res = createWithAllFields()
		val result = super.create(url, res)
		val savedRes = repository.getById(findIdentityId(result))
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `deleteArticle api`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)

		val result = super.delete(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `getArticle with required fields`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)

		val result = super.getById(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `getArticle with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)

		val result = super.getById(url, savedRes.id!!)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `getArticles api`() {
		repository.deleteAll()
		val res1 = createWithRequiredFields()
		val res2 = createWithAllFields()

		val savedRes1 = repository.save(res1)
		val savedRes2 = repository.save(res2)

		val params = LinkedMultiValueMap<String, String>()
		params["sort"] = "entity.history.createdDate"
		val result = super.findAll(url, params)

		resourceAsserts(savedRes1, result, 0)
		resourceAsserts(savedRes2, result, 1)
	}

	@Test
	fun `updateArticle with required fields`() {
		val res = createWithRequiredFields()
		val savedRes = repository.save(res)

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}

	@Test
	fun `updateArticle with all fields`() {
		val res = createWithAllFields()
		val savedRes = repository.save(res)

		val result = super.update(url, savedRes.id!!, savedRes)
		resourceAsserts(savedRes, result)
	}


	private fun resourceAsserts(savedResource: Article, result: MvcResult, index: Int = -1) {
		val prefix = if (index == -1) "$" else "$.content[$index]"
		if (savedResource.id != null) {
			assertEquals(savedResource.id, getValue(result, "$prefix.id"))
		} else {
			assertNotNull(getValue(result, "$prefix.id"))
		}
		assertListsEquals(savedResource.authors, getValue(result, "$prefix.authors"))
		assertListsEquals(savedResource.keywords, getValue(result, "$prefix.keywords"))
		assertObjectEquals(savedResource.history, getValue(result, "$prefix.history"))
		assertEquals(savedResource.textContent, getValue(result, "$prefix.textContent"))
		assertEquals(savedResource.shortDescription, getValue(result, "$prefix.shortDescription"))
		assertEquals(savedResource.header, getValue(result, "$prefix.header"))
	}

	private fun createWithRequiredFields(): Article {
	return Article(
				authors = null,
				keywords = null,
				history = null,
				textContent = null,
				shortDescription = null,
				header = null
		)
	}

	private fun createWithAllFields(): Article {
		return Article(
				authors = listOf("test_list_string_value"),
				keywords = listOf("test_list_string_value"),
				history = History(
					createdBy = "test string value",
					updatedBy = "test string value",
					createdOn = "test string value",
					updatedOn = "test string value"
				),
				textContent = "test string value",
				shortDescription = "test string value",
				header = "test string value"
		)
	}

}
