package osGuriEaGuriadaProgramacao.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import osGuriEaGuriadaProgramacao.demo.model.LocalModel;
import osGuriEaGuriadaProgramacao.demo.service.LocalService;

import java.util.List;

@RestController
@RequestMapping("/api/local")
public class LocalController {

    @Autowired
    private LocalService service;

    @PostMapping
    // POST: http://localhost:8080/api/local
    public ResponseEntity<LocalModel> criar(@RequestBody LocalModel local) {
        LocalModel localSalvo = service.salvar(local);
        return ResponseEntity.status(HttpStatus.CREATED).body(localSalvo);
    }

    @GetMapping
    // GET: http://localhost:8080/api/local
    public ResponseEntity<List<LocalModel>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    // GET: http://localhost:8080/api/local/{id}
    public ResponseEntity<LocalModel> buscarPorId(@PathVariable String id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    // PUT: http://localhost:8080/api/local/{id}
    public ResponseEntity<LocalModel> atualizar(@PathVariable String id, @RequestBody LocalModel localAtualizado) {
        LocalModel localNovo = service.atualizar(id, localAtualizado);
        return ResponseEntity.ok(localNovo);
    }

    @DeleteMapping("/{id}")
    // DELETE: http://localhost:8080/api/local/{id}
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
