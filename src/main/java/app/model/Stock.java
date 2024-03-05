package app.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

/**
 * Stock entity represents the stock db view
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "stock")
@Data
public class Stock {

    @MongoId(FieldType.OBJECT_ID)
    private String id;


    private Long warehouseId;


    private String warehouseDescription;


    private Long shelfId;


    private String shelfCode;


    private Long productId;


    private String productCode;


    private Long totalQuantity;
}
