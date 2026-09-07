package osGuriEaGuriadaProgramacao.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import osGuriEaGuriadaProgramacao.demo.model.DispositivoModel;
import java.util.List;


@Repository
public interface DispositivoRepository
        extends MongoRepository<DispositivoModel, String> {

}
