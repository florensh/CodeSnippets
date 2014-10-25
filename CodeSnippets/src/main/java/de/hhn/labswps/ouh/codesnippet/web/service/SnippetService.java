package de.hhn.labswps.ouh.codesnippet.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.hhn.labswps.ouh.codesnippet.web.repository.SnippetRepository;


@Service
public class SnippetService {
	
    @Autowired
    SnippetRepository snippetDao;

}
