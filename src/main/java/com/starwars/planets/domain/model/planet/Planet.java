package com.starwars.planets.domain.model.planet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(onConstructor_ = @Builder)
@Document(collection = "planet")
public class Planet {

    @Id
    private String id;
    private String name;
    private String climate;
    private String terrain;
    private Integer numberOfMovies;

}
