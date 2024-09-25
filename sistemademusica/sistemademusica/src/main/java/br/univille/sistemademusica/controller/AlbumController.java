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
import br.univille.sistemademusica.entity.Album;
import br.univille.sistemademusica.service.AlbumService;

@RestController
@RequestMapping("/api/albuns")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @GetMapping
    public List<Album> listarAlbuns() {
        return albumService.listarTodosAlbuns();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> obterAlbum(@PathVariable Long id) {
        return albumService.obterAlbumPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Album criarAlbum(@RequestBody Album album) {
        return albumService.salvarAlbum(album);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAlbum(@PathVariable Long id) {
        albumService.deletarAlbum(id);
        return ResponseEntity.noContent().build();
    }
}
