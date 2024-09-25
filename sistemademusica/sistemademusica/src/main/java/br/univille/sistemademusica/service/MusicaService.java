package br.univille.sistemademusica.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.sistemademusica.entity.Musica;
import br.univille.sistemademusica.repository.MusicaRepository;

@Service
public class MusicaService {
    @Autowired
    private MusicaRepository musicaRepository;

    public List<Musica> listarTodasMusicas() {
        return musicaRepository.findAll();
    }

    public Optional<Musica> obterMusicaPorId(Long id) {
        return musicaRepository.findById(id);
    }

    public Musica salvarMusica(Musica musica) {
        return musicaRepository.save(musica);
    }

    public void deletarMusica(Long id) {
        musicaRepository.deleteById(id);
    }
}
