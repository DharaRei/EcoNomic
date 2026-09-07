package osGuriEaGuriadaProgramacao.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import osGuriEaGuriadaProgramacao.demo.model.ConsumoEnergia;
import osGuriEaGuriadaProgramacao.demo.model.DispositivoModel;
import osGuriEaGuriadaProgramacao.demo.service.DispositivoService;

import java.util.List;

@RestController
@RequestMapping("/api/dispositivo")
public class DispositivoController {

    @Autowired
    private DispositivoService service;

    @PostMapping ("/processar")
    // POST: http://localhost:8080/api/dispositivo/processar
    public ResponseEntity<DispositivoModel> iniciar (@RequestBody DispositivoModel dispositivo){
        DispositivoModel leituraIniciada = service.processarMonitoramento(dispositivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(leituraIniciada);
    }

    @PostMapping
    //Post  http://localhost:8080/api/dispositivo
    public ResponseEntity<DispositivoModel> criar (@RequestBody DispositivoModel dispositivoAtivo) {
        DispositivoModel dispositivoMonitorado = service.salvar(dispositivoAtivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(dispositivoMonitorado);
    }

    @GetMapping
    // Get:  http://localhost:8080/api/dispositivo
    public ResponseEntity<List<DispositivoModel>> listarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodos());
    }

    @GetMapping("/{id}")
    //GET: http://localhost:8080/api/dispositivo/{id}
    public  ResponseEntity<DispositivoModel> buscaPorId(@PathVariable String id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    // PUT: http://localhost:8080/api/dispositivo/{id}
    public ResponseEntity<DispositivoModel> atualizar(@PathVariable String id,
                                                      @RequestBody DispositivoModel dispositivoAtualizado) {
        DispositivoModel dispositivoNovo = service.atualizar(id, dispositivoAtualizado);
        return ResponseEntity.ok(dispositivoNovo);
    }


    @DeleteMapping("/{id}")
    // DELETE: http://localhost:8080/api/dispositivo/{id}
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}// fecha public class
