package app.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;


/**
 * Detail entity for massive ware import/export
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "ware_transaction_detail")
@Data
public class WareTransactionDetail {

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    private WareTransaction wareTransaction;

    private Product product;

    private Shelf shelf;

    private Long quantity;

}
