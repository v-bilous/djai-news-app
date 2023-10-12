package app.test.article.service

import app.test.article.domain.Article
import app.test.article.repository.DefaultRepository
import app.test.service.AbstractService
import org.springframework.stereotype.Service

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@Service
class DefaultService(
    repository: DefaultRepository
) : AbstractService<Article, DefaultRepository>(repository)
