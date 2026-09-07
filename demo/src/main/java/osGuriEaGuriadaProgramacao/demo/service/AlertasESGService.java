package osGuriEaGuriadaProgramacao.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osGuriEaGuriadaProgramacao.demo.model.AlertasESGModel;
import osGuriEaGuriadaProgramacao.demo.repository.AlertasESGRepository;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class AlertasESGService {

    @Autowired
    AlertasESGRepository repository;

// Criar um alerta
    public AlertasESGModel criarAlerta (AlertasESGModel alerta) {
        //regra de negócio: todo alerta deve ter data e hora!
        if (alerta.getDataHoraDoAlerta() == null ){
        alerta.setDataHoraDoAlerta(LocalDateTime.now());
        }
        return repository.save(alerta);
    }

    // Listar todos
    public List<AlertasESGModel> listarTodosAlertas (){
        return repository.findAll();
    }

    //Busca por ID
    public AlertasESGModel buscarPorID (String id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alerta ESG não encontrado com o ID: " + id));
    }


    //Atualizar e editar
    public AlertasESGModel atualizar (String id, AlertasESGModel alertaAtualizado){
        AlertasESGModel alertaAtual = buscarPorID(id);

        alertaAtual.setNivelSeveridade(alertaAtualizado.getNivelSeveridade());
        alertaAtual.setStatus(alertaAtualizado.getStatus());
        alertaAtual.setTipoDeAlerta(alertaAtualizado.getTipoDeAlerta());

        if (alertaAtualizado.getDataHoraDoAlerta() != null ){
            alertaAtual.setDataHoraDoAlerta(alertaAtualizado.getDataHoraDoAlerta());
        }
        return repository.save(alertaAtual);
    }

    // Deletar por Id
    public void deletar (String id){
        AlertasESGModel alertaExistente = buscarPorID(id);
        repository.delete(alertaExistente);
    }

}
