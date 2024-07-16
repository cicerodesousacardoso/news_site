package com.example.news_site;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/noticias")
public class NoticiaController {

    @Autowired
    private NoticiaRepository noticiaRepository;

    @GetMapping
    public List<Noticia> listar() {
        return noticiaRepository.findAll();
    }

    @PostMapping
    public Noticia adicionar(@RequestBody Noticia noticia) {
        return noticiaRepository.save(noticia);
    }

    @PutMapping("/{id}")
    public Noticia atualizar(@PathVariable Long id, @RequestBody Noticia noticiaAtualizada) {
        Noticia noticia = noticiaRepository.findById(id).orElseThrow(() -> new RuntimeException("Notícia não encontrada"));
        noticia.setTitulo(noticiaAtualizada.getTitulo());
        noticia.setConteudo(noticiaAtualizada.getConteudo());
        noticia.setAutor(noticiaAtualizada.getAutor());
        return noticiaRepository.save(noticia);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        noticiaRepository.deleteById(id);
    }
}
