package app.service;

import app.dto.ShelfDto;

import java.util.List;

public interface ShelfService {

    ShelfDto findById(String id);

    List<ShelfDto> findAll();

    ShelfDto save(ShelfDto shelfDto);

    void deleteById(String id);
}
