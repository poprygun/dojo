package io.pivotal.tg;


import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Technique {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    @ApiModelProperty(notes = "The name of the technique", required = true)
    private String name;
    @NonNull
    @ApiModelProperty(notes = "The name of the discipline", required = true)
    private String discipline;
}
