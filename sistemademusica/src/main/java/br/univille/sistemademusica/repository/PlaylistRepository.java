package br.univille.sistemademusica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.univille.sistemademusica.entity.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long>{
    
}
