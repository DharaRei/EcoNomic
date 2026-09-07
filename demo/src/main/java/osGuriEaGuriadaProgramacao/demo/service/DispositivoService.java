package osGuriEaGuriadaProgramacao.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osGuriEaGuriadaProgramacao.demo.model.ConsumoEnergia;
import osGuriEaGuriadaProgramacao.demo.model.DispositivoModel;
import osGuriEaGuriadaProgramacao.demo.repository.DispositivoRepository;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class DispositivoService {

    @Autowired
    DispositivoRepository repository;


    //para salvar a leitura primeiro precisa processar
    public DispositivoModel processarMonitoramento (DispositivoModel dispositivo) {
        // Regra do negócio: Se o dispositivo estiver ativo há monitoramento
        if (dispositivo.getStatus() != null
                && dispositivo.getStatus()
                .equalsIgnoreCase("ATIVO")) {
            System.out.println("Monitoramento iniciado para o dispositivo: " + dispositivo.getEquipamento());

            return repository.save(dispositivo);

        } else {
            throw new RuntimeException("O dispositivo:" + dispositivo.getEquipamento() + "não pode ser monitorado," +
                    " verifique se esta inativo ou em manutenção!");
        }
    }

        //salva leitura no MongoDB
        public DispositivoModel salvar (DispositivoModel dispositivo) {
            // Regra de negócio: Verifica se o status é nulo ou diferente de ATIVO
            if (dispositivo.getStatus() == null || !dispositivo.getStatus().equalsIgnoreCase("ATIVO")) {
                System.out.println("Aviso: Dispositivo cadastrado sem monitoramento ativo.");
            } else {
                System.out.println("Monitoramento habilitado para o dispositivo.");
            }

            return repository.save(dispositivo);
        }

// listar todos os registros de consumo
        public List<DispositivoModel> listarTodos(){
            return repository.findAll();
        }

        // Busca por ID do documento
        public DispositivoModel buscarPorId(String id) {
            return repository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Leitura de consumo não encotrado"));
        }



    // Atualizar/Editar um registro existente
    public DispositivoModel atualizar(String id, DispositivoModel dispositivoAtualizado) {
       DispositivoModel dispositivoExistente = buscarPorId(id);

        // Atualizando os campos necessários
       dispositivoExistente.setStatus(dispositivoAtualizado.getStatus());
       dispositivoExistente.setTipo(dispositivoAtualizado.getTipo());

        // Salvar as alterações no MongoDB
        return repository.save(dispositivoExistente);
    }

    // Deletar por ID
    public void deletar(String id) {
        DispositivoModel dispositivoExistente = buscarPorId(id);
        repository.delete(dispositivoExistente);
    }

}// fecha public class