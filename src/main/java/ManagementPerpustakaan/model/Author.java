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

@Document("author")
public class Author {
    @Id
    private String id;
    @Field(name = "authorName")
    @Indexed(unique = true)
    private String authorName;
    @Field (name = "authorBiografi")
    private String authorBiografi;
    
    public Author(String id, String authorName, String authorBiografi){
        this.id = id;
        this.authorName = authorName;
        this.authorBiografi = authorBiografi;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorBiografi() {
        return authorBiografi;
    }

    public void setAuthorBiografi(String authorBiografi) {
        this.authorBiografi = authorBiografi;
    }

}