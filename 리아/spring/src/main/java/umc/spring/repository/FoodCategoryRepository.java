package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.FoodCategory;

public class FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {

}
