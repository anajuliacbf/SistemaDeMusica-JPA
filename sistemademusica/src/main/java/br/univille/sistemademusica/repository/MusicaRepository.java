package br.univille.sistemademusica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.univille.sistemademusica.entity.Musica;

public interface MusicaRepository extends JpaRepository<Musica, Long> {
    
}
