package br.univille.sistemademusica.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.sistemademusica.entity.Artista;
import br.univille.sistemademusica.repository.ArtistaRepository;

@Service
public class ArtistaService {
    @Autowired
    private ArtistaRepository artistaRepository;

    public List<Artista> listarTodosArtistas() {
        return artistaRepository.findAll();
    }

    public Optional<Artista> obterArtistaPorId(Long id) {
        return artistaRepository.findById(id);
    }

    public Artista salvarArtista(Artista artista) {
        return artistaRepository.save(artista);
    }

    public void deletarArtista(Long id) {
        artistaRepository.deleteById(id);
    }
}
