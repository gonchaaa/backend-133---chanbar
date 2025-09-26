package com.chanbar.backend133_chanbar.repositories;

import com.chanbar.backend133_chanbar.models.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory,Long> {
    Optional<SubCategory> findBySubCategoryName(String subCategoryName);
}
