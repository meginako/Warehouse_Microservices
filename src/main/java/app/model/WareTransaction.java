package app.model;

import app.enums.WareTransactionType;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Master entity for massive ware import/export
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "ware_transaction")
@Data
public class WareTransaction {

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    private WareTransactionType wareTransactionType;

    private String description;

    private LocalDateTime transactionDate;

    /**
     * Employee that received/delivered the ware
     */
    private StockClerk stockClerk;

    List<WareTransactionDetail> wareTransactionDetails;

}
