package br.com.fiap.main.model;

import br.com.fiap.main.controller.dto.matter.MatterDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Matter {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Course course;

    public Matter(MatterDTO matterDTO){
        this.name = matterDTO.name();
        this.description = matterDTO.description();
    }
}
