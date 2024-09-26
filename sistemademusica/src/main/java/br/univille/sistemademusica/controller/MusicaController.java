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
import br.univille.sistemademusica.entity.Musica;
import br.univille.sistemademusica.service.MusicaService;

@RestController
@RequestMapping("/api/musicas")
public class MusicaController {

    @Autowired
    private MusicaService musicaService;

    @GetMapping
    public List<Musica> listarMusicas() {
        return musicaService.listarTodasMusicas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musica> obterMusica(@PathVariable Long id) {
        return musicaService.obterMusicaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Musica criarMusica(@RequestBody Musica musica) {
        return musicaService.salvarMusica(musica);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMusica(@PathVariable Long id) {
        musicaService.deletarMusica(id);
        return ResponseEntity.noContent().build();
        
    }
}