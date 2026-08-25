package com.shopsphere.categoryservice.Repository;

import com.shopsphere.categoryservice.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category ,Long> {

}
