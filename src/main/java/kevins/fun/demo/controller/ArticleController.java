package kevins.fun.demo.controller;

import kevins.fun.demo.entity.Article;
import kevins.fun.demo.repository.ArticleRepository;
import kevins.fun.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController("CMSArticleController")
@RequestMapping("/api/v1/articles")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleService articleService;

    @GetMapping("/{id}")
    public ResponseEntity<Article> getById(@PathVariable Long id) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        if (!optionalArticle.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        return ResponseEntity.ok(optionalArticle.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody Article article) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        if (!optionalArticle.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        article.setArticleId(optionalArticle.get().getArticleId());
        articleRepository.save(article);

        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Article>> getAll(Pageable pageable) {
        return ResponseEntity.ok(articleRepository.findAll(Specification.where(null), pageable));
    }

    @PostMapping("")
    public ResponseEntity<Article> create(@RequestBody Article article) {
        Article savedArticle = articleService.create(article);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedArticle.getArticleId()).toUri();
        return ResponseEntity.created(location).body(savedArticle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        if (!optionalArticle.isPresent()) {
            return ResponseEntity.unprocessableEntity().build();
        }

        articleRepository.delete(optionalArticle.get());

        return ResponseEntity.noContent().build();
    }
}
