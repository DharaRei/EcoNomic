package osGuriEaGuriadaProgramacao.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import osGuriEaGuriadaProgramacao.demo.model.LocalModel;
import osGuriEaGuriadaProgramacao.demo.repository.LocalRepository;

import java.util.List;

@Service
public class LocalService {

    @Autowired
    LocalRepository repository;


    public LocalModel salvar (LocalModel localDoEquipamento) {
        // Regra de Negócio: a meta de consumo deve ser maior que zero
        if(localDoEquipamento.getMetaKwhMensal() != null
                && localDoEquipamento.getMetaKwhMensal() <= 0 ){
            throw new RuntimeException("A meta de kWh mensal deve ser maior que zero!");
        }
        return repository.save(localDoEquipamento);
    }

    public List<LocalModel> listarTodos() {
        return repository.findAll();
    }

    public LocalModel buscarPorId(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Local não encontrado com o ID: " + id));
    }

    public LocalModel atualizar(String id, LocalModel localAtualizado) {
        LocalModel localExistente = buscarPorId(id);

        localExistente.setNome(localAtualizado.getNome());
        localExistente.setSetor(localAtualizado.getSetor());
        localExistente.setMetaKwhMensal(localAtualizado.getMetaKwhMensal());
        localExistente.setResponsavel(localAtualizado.getResponsavel());

        return repository.save(localExistente);
    }

    public void deletar(String id) {
        LocalModel localExistente = buscarPorId(id);
        repository.delete(localExistente);
    }
}
