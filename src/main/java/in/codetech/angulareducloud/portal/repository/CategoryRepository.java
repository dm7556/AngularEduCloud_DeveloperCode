package in.codetech.angulareducloud.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.codetech.angulareducloud.portal.model.Exam.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
