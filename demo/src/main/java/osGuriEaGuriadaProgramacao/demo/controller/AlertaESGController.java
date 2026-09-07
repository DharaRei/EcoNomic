package osGuriEaGuriadaProgramacao.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import osGuriEaGuriadaProgramacao.demo.model.AlertasESGModel;
import osGuriEaGuriadaProgramacao.demo.service.AlertasESGService;

import java.util.List;

@RestController
@RequestMapping("/api/alerta")
public class AlertaESGController {

    @Autowired
    AlertasESGService service;


    // POST: http://localhost:8080/api/alerta
    @PostMapping
    public ResponseEntity<AlertasESGModel> criarAlerta (@RequestBody AlertasESGModel alerta) {
        AlertasESGModel novoAlerta = service.criarAlerta(alerta);
        return new ResponseEntity<>(novoAlerta, HttpStatus.CREATED);
    }

    // GET: http://localhost:8080/api/alerta
    @GetMapping
    public ResponseEntity<List<AlertasESGModel>> listarTodosAlertas(){
        List<AlertasESGModel> alertas = service.listarTodosAlertas();
        return ResponseEntity.ok(alertas);
    }


    // GET por ID: http://localhost:8080/api/alerta/{id}
    @GetMapping("/{id}")
    public  ResponseEntity<AlertasESGModel> buscarPorID( @PathVariable  String id){
        return ResponseEntity.ok(service.buscarPorID(id));
    }


    // PUT: http://localhost:8080/api/alerta/{id}
    @PutMapping("/{id}")
    public ResponseEntity<AlertasESGModel> atualizar(@PathVariable String id, @RequestBody AlertasESGModel alertaAtualizado) {
        AlertasESGModel alertaEditado = service.atualizar(id, alertaAtualizado);
        return ResponseEntity.ok(alertaEditado);
    }

    // DELETE: http://localhost:8080/api/alerta/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
            service.deletar(id);
            return ResponseEntity.noContent().build();
    }


}


