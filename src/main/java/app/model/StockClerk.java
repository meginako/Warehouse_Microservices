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
@Document(collection = "stock_clerk")
@Data
public class StockClerk {

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    private String registryNumber;

    private String firstName;

    private String lastName;

}
