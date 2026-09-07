package osGuriEaGuriadaProgramacao.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "meta_sustentavel")
public class MetaSustentavelModel {

    @Id
    private String id;

    private String setor;
    private Double metaDeReducao;
    private String anoMes;
    private String pegadaCarbonoAlvo;

}



