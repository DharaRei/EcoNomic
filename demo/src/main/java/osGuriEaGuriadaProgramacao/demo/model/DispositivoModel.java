package osGuriEaGuriadaProgramacao.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "dispositivo_sensor")
public class DispositivoModel {

    @Id
    private String id;

    private Double numeroSerie;
    private String tipo; // trifasico, monofasico, SmartPlug
    private String status; // inativo, ativo, manutenção
    private String equipamento;  // qual o dispositivo
}
