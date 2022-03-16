package kevins.fun.demo.repository;

import kevins.fun.demo.entity.Article;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

@Repository("CmsArticleRepository")
public interface ArticleRepository extends CrudRepository<Article, Long>, QueryByExampleExecutor<Article>, JpaSpecificationExecutor<Article> {
}
