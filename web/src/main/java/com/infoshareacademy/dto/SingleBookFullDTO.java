package com.infoshareacademy.dto;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped

public class SingleBookFullDTO {

    /*wszystkie DAO powinny być @Stateless, interfejsów nie potrzebujecie więc będą domyślnie lokalne
EM wstrzykujemy w każdym z DAO bądź w analogii do nowej pracy domowej tworzycie generyczne DAO
DAO zawsze zwracać będzie encje
i przyjmować będzie encje


Servlet natomiast, przyjmuje HttpServletRequest,
następnie sam bądź za pomocą jakiegoś beana RequestScoped przepisuje HttpServletRequest.getParameter na DTO i
wysyła go do service.
Servlet również przyjmuje od service DTO i następnie samodzielnie bądź za pomocą beana RequestScoped
przepisuje jeden lub więcej DTO na mapę modelu danych Freemarkera.
Mapper natomiast ma dwie formy metod: mapRequestToEntity oraz mapEntityToView

     */
    private Long id;
    private String title;
    private String cover;
    private Boolean has_audio;
    private String simple_thumb;
    private String cover_thumb;
    private Long epoch_id;
    private String genre_id;
    private Long author_id;

    @Inject
    public SingleBookFullDTO(Long id, String title, String cover, Boolean has_audio, String simple_thumb, String cover_thumb, Long epoch_id, String genre_id, Long author_id) {
        this.id = id;
        this.title = title;
        this.cover = cover;
        this.has_audio = has_audio;
        this.simple_thumb = simple_thumb;
        this.cover_thumb = cover_thumb;
        this.epoch_id = epoch_id;
        this.genre_id = genre_id;
        this.author_id = author_id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCover() {
        return cover;
    }

    public Boolean getHas_audio() {
        return has_audio;
    }

    public String getSimple_thumb() {
        return simple_thumb;
    }

    public String getCover_thumb() {
        return cover_thumb;
    }

    public Long getEpoch_id() {
        return epoch_id;
    }

    public String getGenre_id() {
        return genre_id;
    }

    public Long getAuthor_id() {
        return author_id;
    }
}
