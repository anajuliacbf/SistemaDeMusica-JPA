package br.univille.sistemademusica.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.univille.sistemademusica.entity.Playlist;
import br.univille.sistemademusica.service.PlaylistService;


@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping
    public List<Playlist> listarPlaylists() {
        return playlistService.listarTodasPlaylists();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Playlist> obterPlaylist(@PathVariable Long id) {
        return playlistService.obterPlaylistPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Playlist criarPlaylist(@RequestBody Playlist playlist) {
        return playlistService.salvarPlaylist(playlist);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPlaylist(@PathVariable Long id) {
        playlistService.deletarPlaylist(id);
        return ResponseEntity.noContent().build();
    }
}
