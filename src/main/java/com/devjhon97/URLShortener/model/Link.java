package com.devjhon97.URLShortener.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = Link.TABLE_NAME)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Link {
    public static final String TABLE_NAME = "links";

    @Id
    @Column(name = "short_url")
    private String shortURL;

    @Column(name = "real_url", nullable = false)
    private String realURL;

    @Column(name = "expire_time")
    private LocalDateTime expireTime;

    @Column(name = "clicks")
    private Long clicks;
}
