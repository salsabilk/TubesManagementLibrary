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

@Document("buku")
public class Buku {
    @Id
    private String id;
    @Field(name = "isbn")
    private String isbn;
    @Field(name = "name")
    @Indexed(unique = true)
    private String bukuName;
    @Field (name = "bukuAuthors")
    private String bukuAuthors;
    @Field(name = "category")
    private BukuCategory bukuCategory;
    @Field (name = "bukuPublisher")
    private String bukuPublisher;
    
    public Buku(String id,String isbn, String bukuName, BukuCategory bukuCategory, String bukuAuthors, String bukuPublisher ){
        this.id = id;
        this.isbn = isbn;
        this.bukuName = bukuName;
        this.bukuAuthors = bukuAuthors;
        this.bukuCategory = bukuCategory;
        this.bukuPublisher = bukuPublisher;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBukuName() {
        return bukuName;
    }

    public void setBukuName(String bukuName) {
        this.bukuName = bukuName;
    }

    public BukuCategory getBukuCategory() {
        return bukuCategory;
    }

    public void setBukuCategory(BukuCategory bukuCategory) {
        this.bukuCategory = bukuCategory;
    }
    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBukuAuthors() {
        return bukuAuthors;
    }
    
    public void setBukuAuthors(String bukuAuthors) {
        this.bukuAuthors = bukuAuthors;
    }
        
    public String getBukuPublisher() {
        return bukuPublisher;
    }
    
    public void setBukuPublisher(String bukuPublisher) {
        this.bukuPublisher = bukuPublisher;
    }
}