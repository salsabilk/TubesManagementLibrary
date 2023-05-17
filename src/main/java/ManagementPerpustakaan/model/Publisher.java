package ManagementPerpustakaan.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import org.springframework.data.mongodb.core.index.Indexed;

/**
 * 1B D4 - TEKNIK INFORMATIKA
 * Nama Anggota : 
 * Niqa Nabila Nur Ihsani (221524054)
 * Salsabil Khoirunisa    (221524058)
 * Yusuf                  (221524062)
 */

@Document("publisher")
public class Publisher {
    @Id
    private String id;
    @Field(name = "publisherName")
    @Indexed(unique = true)
    private String publisherName;
    @Field(name = "publisherCategory")
    private PublisherCategory publisherCategory;
    
    public Publisher(String id, String publisherName, PublisherCategory publisherCategory){
        this.id = id;
        this.publisherName = publisherName;
        this.publisherCategory = publisherCategory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public PublisherCategory getPublisherCategory() {
        return publisherCategory;
    }

    public void setPublisherCategory(PublisherCategory publisherCategory) {
        this.publisherCategory = publisherCategory;
    }

}