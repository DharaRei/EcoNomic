package osGuriEaGuriadaProgramacao.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import osGuriEaGuriadaProgramacao.demo.model.MetaSustentavelModel;
import osGuriEaGuriadaProgramacao.demo.repository.MetaSustentavelRepository;

import java.util.List;


@Service
public class MetaSustentabilidadeService {

    @Autowired
    MetaSustentavelRepository repository;


    //salva meta
    public MetaSustentavelModel salvar (MetaSustentavelModel metaSalva) {
        // regra do negócio a Margem de redução deve ser entre 1% e 100%
        if (metaSalva.getMetaDeReducao() != null && (metaSalva.getMetaDeReducao() <= 0
                || metaSalva.getMetaDeReducao() > 100)) {
            throw new RuntimeException("A meta de redução percentual deve estar entre 1% e 100%!");
        }
        return repository.save(metaSalva);
    }

    // listar todos os registros de metas
    public List<MetaSustentavelModel> listarTodos(){
        return repository.findAll();
    }

    // Atualizar/Editar um registro existente
    public MetaSustentavelModel buscaPorId(String id){
        return repository.findById(id).orElseThrow(()
                -> new RuntimeException("Meta não encontrada pelo Id" + id));


    }

    public MetaSustentavelModel atualizarMeta ( String id, MetaSustentavelModel metaAtualizada ){
        MetaSustentavelModel metaAtual = buscaPorId(id);

        metaAtual.setAnoMes(metaAtualizada.getAnoMes());
        metaAtual.setMetaDeReducao(metaAtualizada.getMetaDeReducao());
        metaAtual.setPegadaCarbonoAlvo(metaAtualizada.getPegadaCarbonoAlvo());

        return repository.save(metaAtual);
    }


    // Deletar por ID
    public void deletar(String id){
        MetaSustentavelModel metalExistente = buscaPorId(id);
        repository.delete(metalExistente);
    }



    }




