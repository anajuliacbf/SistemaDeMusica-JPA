package br.univille.sistemademusica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.univille.sistemademusica.entity.Artista;

public interface ArtistaRepository extends JpaRepository<Artista, Long>{
    
}
