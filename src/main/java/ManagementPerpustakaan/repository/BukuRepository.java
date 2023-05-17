package ManagementPerpustakaan.repository;

import ManagementPerpustakaan.model.Buku;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 1B D4 - TEKNIK INFORMATIKA
 * Nama Anggota : 
 * Niqa Nabila Nur Ihsani (221524054)
 * Salsabil Khoirunisa    (221524058)
 * Yusuf                  (221524062)
 */

@Repository
public interface BukuRepository extends MongoRepository<Buku, String>{   
    @Query("{'name': ?0}") 
    public List<Buku> search(String keyword);
}

