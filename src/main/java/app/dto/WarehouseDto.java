package app.dto;

import app.model.Shelf;
import app.model.Warehouse;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class WarehouseDto {

    private String id;
    private String description;
    private List<ShelfDto> shelves = new ArrayList<>();

    public WarehouseDto(Warehouse warehouse) {
        BeanUtils.copyProperties(warehouse, this, "shelves");

        List<Shelf> shelves = warehouse.getShelves();
        if(shelves != null && !shelves.isEmpty()) {
            shelves.forEach(shelf -> {
                ShelfDto shelfDto = new ShelfDto(shelf);
                this.shelves.add(shelfDto);
            });
        }
    }
}
