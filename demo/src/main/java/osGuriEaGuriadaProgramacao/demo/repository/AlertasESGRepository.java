package osGuriEaGuriadaProgramacao.demo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import osGuriEaGuriadaProgramacao.demo.model.AlertasESGModel;

@Repository
public interface AlertasESGRepository extends MongoRepository<AlertasESGModel, String> {
}
