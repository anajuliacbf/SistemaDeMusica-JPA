package br.univille.sistemademusica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.sistemademusica.entity.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long>{
    
}
