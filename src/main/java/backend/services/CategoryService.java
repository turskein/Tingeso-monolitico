package backend.services;

import backend.entities.CategoryEntity;
import backend.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public ArrayList<CategoryEntity> obtenerCategorias(){
        return (ArrayList<CategoryEntity>) categoryRepository.findAll();
    }
}
