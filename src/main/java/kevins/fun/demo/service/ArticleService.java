package kevins.fun.demo.service;

import kevins.fun.demo.entity.Article;
import kevins.fun.demo.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public Article create(Article article) {
        return articleRepository.save(article);
    }
}
