package osGuriEaGuriadaProgramacao.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import osGuriEaGuriadaProgramacao.demo.model.MetaSustentavelModel;
import osGuriEaGuriadaProgramacao.demo.service.MetaSustentabilidadeService;

import java.util.List;


@RestController
@RequestMapping("/api/metas")
public class MetaSustentavelController {

    @Autowired
    MetaSustentabilidadeService service;


    //Post  http://localhost:8080/api/metas
    @PostMapping
    public ResponseEntity<MetaSustentavelModel> salvar (@RequestBody MetaSustentavelModel meta){
        MetaSustentavelModel novaMeta = service.salvar(meta);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMeta);
    }

    // Get:  http://localhost:8080/api/metas
    @GetMapping
    public ResponseEntity<List<MetaSustentavelModel>> listarTodos( ){
        return ResponseEntity.ok(service.listarTodos());
    }


    //GET: http://localhost:8080/api/metas/{id}
    @GetMapping("/{id}")
    public ResponseEntity<MetaSustentavelModel>  buscaPorId (@PathVariable String id){
        return ResponseEntity.ok(service.buscaPorId(id));
    }


    // PUT: http://localhost:8080/api/metas/{id}
    @PutMapping("/{id}")
    public ResponseEntity<MetaSustentavelModel>  atualizarMeta (@PathVariable String id, @RequestBody MetaSustentavelModel metaAtualizada){
        MetaSustentavelModel metaAtual = service.atualizarMeta(id, metaAtualizada);
        return ResponseEntity.ok(metaAtualizada);

    }

    // DELETE: http://localhost:8080/api/metas/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<MetaSustentavelModel> deletar (@PathVariable String id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }




}
