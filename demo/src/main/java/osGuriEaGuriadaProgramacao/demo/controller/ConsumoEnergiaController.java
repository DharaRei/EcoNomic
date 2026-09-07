package osGuriEaGuriadaProgramacao.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import osGuriEaGuriadaProgramacao.demo.model.ConsumoEnergia;
import osGuriEaGuriadaProgramacao.demo.service.ConsumoEnergiaService;

import java.util.List;


@RestController
@RequestMapping("/api/consumo")
public class ConsumoEnergiaController {

    @Autowired
    private ConsumoEnergiaService service;

    @PostMapping
    //Post  http://localhost:8080/api/consumo
    public ResponseEntity<ConsumoEnergia> criar (@RequestBody ConsumoEnergia consumo){
        ConsumoEnergia novoConsumo = service.salvar(consumo);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(novoConsumo);
    } // fecha post


    @GetMapping
    // Get:  http://localhost:8080/api/consumo
public ResponseEntity<List<ConsumoEnergia>> listarTodos(){
        return  ResponseEntity.ok(service.listarTodos());
    }


    @GetMapping("/{id}")
    //GET: http://localhost:8080/api/consumo/{id}
    public  ResponseEntity<ConsumoEnergia> buscaPorId(@PathVariable String id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // GET: http://localhost:8080/api/consumo/sensor/{sensorId}
    @GetMapping("/sensor/{sensorId}")
    public ResponseEntity<List<ConsumoEnergia>> buscarPorSensor(@PathVariable String sensorId) {
        return ResponseEntity.ok(service.buscarPorSensor(sensorId));
    }


    @PutMapping("/{id}")
    // PUT: http://localhost:8080/api/consumo/{id}
    public ResponseEntity<ConsumoEnergia> atualizar
            (@PathVariable String id, @RequestBody ConsumoEnergia consumo) {
        ConsumoEnergia atualizado = service.atualizar(id, consumo);
        return ResponseEntity.ok(atualizado);
    }

    // DELETE: http://localhost:8080/api/consumo/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<ConsumoEnergia> deletar (@PathVariable String id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }






}
