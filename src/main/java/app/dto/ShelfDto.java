package app.dto;

import app.model.Shelf;
import app.model.Warehouse;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor
@Data
public class ShelfDto {

    private String id;
    private String code;
    private String warehouseId;

    public ShelfDto(Shelf shelf) {
        BeanUtils.copyProperties(shelf, this, "warehouseId");

        Warehouse warehouse = shelf.getWarehouse();
        if (warehouse != null) {
            this.warehouseId = warehouse.getId();
        }
    }
}
