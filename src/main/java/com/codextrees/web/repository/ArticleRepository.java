package com.codextrees.web.repository;

import com.codextrees.web.models.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository extends CrudRepository<Article,Long> {
	
	@Query("Select a FROM Article a WHERE a.url = :article_url")
	   public Article getArticleByUrl(@Param("article_url") String article_url);
}
