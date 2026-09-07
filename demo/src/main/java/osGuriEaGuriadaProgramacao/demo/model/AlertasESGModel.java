package osGuriEaGuriadaProgramacao.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "alertas_esg")
public class AlertasESGModel {

    @Id
    private String sensorId;

    private String tipoDeAlerta; // por exemplo pico de consumo ou fuga de correntes
    private String nivelSeveridade;
    private LocalDateTime dataHoraDoAlerta;
    private String status; // se foi resolvido ou não

}
