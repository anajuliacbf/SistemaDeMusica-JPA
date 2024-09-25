package br.univille.sistemademusica.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.sistemademusica.entity.Playlist;
import br.univille.sistemademusica.repository.PlaylistRepository;

@Service
public class PlaylistService {
    
     @Autowired
    private PlaylistRepository playlistRepository;

    public List<Playlist> listarTodasPlaylists() {
        return playlistRepository.findAll();
    }

    public Optional<Playlist> obterPlaylistPorId(Long id) {
        return playlistRepository.findById(id);
    }

    public Playlist salvarPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public void deletarPlaylist(Long id) {
        playlistRepository.deleteById(id);
    }
}
