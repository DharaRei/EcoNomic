package osGuriEaGuriadaProgramacao.demo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import osGuriEaGuriadaProgramacao.demo.model.LocalModel;

public interface LocalRepository extends MongoRepository<LocalModel, String> {
}
