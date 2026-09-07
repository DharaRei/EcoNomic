package osGuriEaGuriadaProgramacao.demo.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Document(collection = "locais")
    public class LocalModel {
        @Id
        private String id;

        private String nome; // Ex: "Bloco A - Andar 3"
        private String setor; // Ex: "TI", "Laboratórios", "Administrativo"
        private Double metaKwhMensal;
        private String responsavel; //tecnico responsavel pelo monitoramento
}
