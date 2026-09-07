package osGuriEaGuriadaProgramacao.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import osGuriEaGuriadaProgramacao.demo.model.MetaSustentavelModel;

@Repository
public interface MetaSustentavelRepository extends MongoRepository<MetaSustentavelModel, String> {
}
