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
}
