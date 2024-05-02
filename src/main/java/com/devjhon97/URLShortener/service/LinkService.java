package com.devjhon97.URLShortener.service;

import com.devjhon97.URLShortener.model.Link;
import com.devjhon97.URLShortener.repository.LinkRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;
    CreateCodeService codeService = new CreateCodeService();

    public Optional<Link> findById(String shortURL) {
        return linkRepository.findById(shortURL);
    }

    public String createShortURL(String url) {
        Optional<Link> user;
        String shortURL;

        do {
            shortURL = codeService.createCode();
            user = findById(shortURL);

        } while (user.isPresent());

        Link newLink = new Link(shortURL, url, LocalDateTime.now(), 0L);
        linkRepository.save(newLink);

        return shortURL;
    }
}
