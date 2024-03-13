package app.common.search;

import app.enums.MeasurementUnit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSearchCriteria {

    private Long id;
    private String code;
    private String description;
    private MeasurementUnit measurementUnit;
}
