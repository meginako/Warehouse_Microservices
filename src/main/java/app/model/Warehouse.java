package app.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "warehouse")
@Data
public class Warehouse {

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    private String description;

    List<Shelf> shelves = new ArrayList<>();

}
