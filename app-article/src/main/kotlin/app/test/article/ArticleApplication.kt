package app.test.article

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@javax.annotation.Generated(value = ["org.openapitools.codegen.CodeCodegen"])

@SpringBootApplication(scanBasePackages = ["app.test.article", "app.test.config"])
@EntityScan(value = ["app.test.article.domain", "app.test.domain"])
class ArticleApplication

@Suppress("SpreadOperator")
fun main(args: Array<String>) {
    runApplication<ArticleApplication>(*args)
}
