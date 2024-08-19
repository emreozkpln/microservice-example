package dev.buddly.factorycrm.educator;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document
public class Educator {

    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private List<Integer> lessonsId;
}
