package osGuriEaGuriadaProgramacao.demo.repository;

//imports
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import osGuriEaGuriadaProgramacao.demo.model.ConsumoEnergia;

import java.util.List;


@Repository
public interface ConsumodeEnergiaRepository extends MongoRepository<ConsumoEnergia, String> {

    List<ConsumoEnergia> findBySensorId(String sensorId);

}
