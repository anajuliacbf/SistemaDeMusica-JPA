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
import br.univille.sistemademusica.entity.Artista;
import br.univille.sistemademusica.service.ArtistaService;

@RestController
@RequestMapping("/api/artistas")
public class ArtistaController {

    @Autowired
    private ArtistaService artistaService;

    @GetMapping
    public List<Artista> listarArtistas() {
        return artistaService.listarTodosArtistas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Artista> obterArtista(@PathVariable Long id) {
        return artistaService.obterArtistaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Artista criarArtista(@RequestBody Artista artista) {
        return artistaService.salvarArtista(artista);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarArtista(@PathVariable Long id) {
        artistaService.deletarArtista(id);
        return ResponseEntity.noContent().build();
    }
}
