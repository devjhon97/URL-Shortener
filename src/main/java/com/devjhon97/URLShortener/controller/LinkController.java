package com.devjhon97.URLShortener.controller;

import com.devjhon97.URLShortener.controller.dto.RequestDTO;
import com.devjhon97.URLShortener.controller.dto.ResponseDTO;
import com.devjhon97.URLShortener.model.Link;
import com.devjhon97.URLShortener.service.LinkService;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.URI;
import java.util.Optional;

@RestController
public class LinkController {

    @Autowired
    private LinkService linkService;

    @PostMapping("/short-link")
    public ResponseEntity<ResponseDTO> create(@RequestBody @Valid RequestDTO request,
                                              HttpServletRequest servletRequest) {

        String shortURL = linkService.createShortURL(request.url());
        String url = servletRequest.getRequestURL().toString().replace("short-link", shortURL);

        return new ResponseEntity<>(new ResponseDTO(url), HttpStatus.CREATED);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Void> redirect(@PathVariable(value = "code") String code) {
        Optional<Link> link = linkService.findById(code);

        if (link.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("https://" + link.get().getRealURL()));
        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
    }
}
