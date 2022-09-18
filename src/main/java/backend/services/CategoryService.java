package backend.services;

import backend.entities.CategoryEntity;
import backend.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CategoryService {
    public boolean isCategoryA(CategoryEntity category){
        return category.getCategory().equals("A");
    }
    public boolean isCategoryB(CategoryEntity category){
        return category.getCategory().equals("B");
    }

    public boolean isCategoryC(CategoryEntity category){
        return category.getCategory().equals("C");
    }

}
