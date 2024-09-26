package org.example.productmanager.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(exported = false)
public interface ProductRepository extends JpaRepository<ProductData, Long> {

    // Find by CategoryData object
    @Query("SELECT pd FROM ProductData pd WHERE pd.category.id = :categoryId")
    List<ProductData> findByCategory(@Param("categoryId") Long category);

}