package fr.baldir;

import static java.util.stream.Collectors.toList;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class ArticleService {
    @Inject
    EntityManager em;

    public List<Article> list() {
        // return Article.list("");
        Article article = new Article();
        article.description="Description";
        article.id=new BigInteger("1");
        article.type="youtube";
        article.url="https://www.youtube.com/watch?v=lXXp-PVQ0HQ";

        return Stream.of(article).collect(toList());
    }
}