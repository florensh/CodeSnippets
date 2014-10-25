package de.hhn.labswps.ouh.codesnippet.web.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.hhn.labswps.ouh.codesnippet.web.entity.Snippet;

public interface SnippetRepository extends CrudRepository<Snippet, Long> {
	
    List<Snippet> findSnippetsByLanguage(String l);
}