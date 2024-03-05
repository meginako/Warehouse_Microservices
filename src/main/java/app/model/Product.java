package app.model;

import app.enums.MeasurementUnit;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "product")
@Data
public class Product {

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    private String code;

    private String description;

    private MeasurementUnit measurementUnit;
}

