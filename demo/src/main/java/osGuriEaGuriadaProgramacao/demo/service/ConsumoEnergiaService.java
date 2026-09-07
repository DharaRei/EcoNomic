package osGuriEaGuriadaProgramacao.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osGuriEaGuriadaProgramacao.demo.model.ConsumoEnergia;
import osGuriEaGuriadaProgramacao.demo.repository.ConsumodeEnergiaRepository;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class ConsumoEnergiaService {

@Autowired
    ConsumodeEnergiaRepository repository;

//salva leitura no MongoDB
    public ConsumoEnergia salvar (ConsumoEnergia consumo) {
        // Regra do negócio: define a data e hora atual se não for informado
         if (consumo.getDataHora() == null){
             consumo.setDataHora(LocalDateTime.now());
         }
         return repository.save(consumo);
    } // fecha salvar

// listar todos os registros de consumo

    public List<ConsumoEnergia> listarTodos(){
        return repository.findAll();
    }

// Busca por ID do documento
    public ConsumoEnergia buscarPorId(String id){
        return repository.findById(id)
                .orElseThrow(() -> new
                        RuntimeException("Leitura de consumo não encotrado"));
    }

//buscar por leituras de um sensor especifico
    public List<ConsumoEnergia> buscarPorSensor (String  sensorId) {
        return repository.findBySensorId(sensorId);
    }


    // Atualizar/Editar um registro existente
    public ConsumoEnergia atualizar(String id, ConsumoEnergia consumoAtualizado) {
        ConsumoEnergia consumoExistente = buscarPorId(id);

        // Atualizando os campos necessários
        consumoExistente.setKwh(consumoAtualizado.getKwh());
        consumoExistente.setTensaoVolts(consumoAtualizado.getTensaoVolts());
        consumoExistente.setCorrenteAmperes(consumoAtualizado.getCorrenteAmperes());

        // Salvar as alterações no MongoDB
        return repository.save(consumoExistente);
    }

    // Deletar por ID
    public void deletar(String id) {
        ConsumoEnergia consumoExistente = buscarPorId(id);
        repository.delete(consumoExistente);
    }








}
