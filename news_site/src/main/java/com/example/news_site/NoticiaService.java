package com.example.news_site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NoticiaService {
    @Autowired
    private NoticiaRepository noticiaRepository;

    public List<Noticia> listarTodas() {
        return noticiaRepository.findAll();
    }

    public Optional<Noticia> buscarPorId(Long id) {
        return noticiaRepository.findById(id);
    }

    public Noticia salvar(Noticia noticia) {
        return noticiaRepository.save(noticia);
    }

    public void deletar(Long id) {
        noticiaRepository.deleteById(id);
    }
}
