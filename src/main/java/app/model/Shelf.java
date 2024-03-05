package app.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "shelf")
@Data
public class Shelf {

    @MongoId(FieldType.OBJECT_ID)
    private String id;


    private String code;

    private Warehouse warehouse;
}
