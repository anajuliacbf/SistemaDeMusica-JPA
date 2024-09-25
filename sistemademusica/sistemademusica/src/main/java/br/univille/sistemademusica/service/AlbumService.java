package br.univille.sistemademusica.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.sistemademusica.entity.Album;
import br.univille.sistemademusica.repository.AlbumRepository;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    public List<Album> listarTodosAlbuns() {
        return albumRepository.findAll();
    }

    public Optional<Album> obterAlbumPorId(Long id) {
        return albumRepository.findById(id);
    }

    public Album salvarAlbum(Album album) {
        return albumRepository.save(album);
    }

    public void deletarAlbum(Long id) {
        albumRepository.deleteById(id);
    }
}
