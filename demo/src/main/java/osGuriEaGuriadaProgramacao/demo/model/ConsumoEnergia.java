package osGuriEaGuriadaProgramacao.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.swing.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document (collection = "consumo_energia")
public class ConsumoEnergia {


    @Id
    private String id;  //identificador unico

   private String sensorId;  //refere a qual sensor enviou a leitur
   private Double Kwh; //quantidade de energia consumida
   private Integer tensaoVolts; //voltagem 110 ou 220 de potência4
   private Double correnteAmperes; //opcional amperagem do momento
   private LocalDateTime dataHora; //essencial para relatórios
}
