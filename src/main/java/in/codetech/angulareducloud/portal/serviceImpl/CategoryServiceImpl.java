package in.codetech.angulareducloud.portal.serviceImpl;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codetech.angulareducloud.portal.model.Exam.Category;
import in.codetech.angulareducloud.portal.model.Exam.Question;
import in.codetech.angulareducloud.portal.repository.CategoryRepository;
import in.codetech.angulareducloud.portal.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository; 

	

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		Category save = this.categoryRepository.save(category);
		return save;
	}

	@Override
	public Set<Category> getCategories() {
		// TODO Auto-generated method stub
//		Iterable<Category> findAll = this.categoryRepository.findAll();	
//		return (Set<Category>) findAll;
		return new LinkedHashSet<>(this.categoryRepository.findAll());
	}

	@Override
	public Category getCategory(Long categoryId) {
		// TODO Auto-generated method stub
		Category orElseThrow = this.categoryRepository.findById(categoryId).orElseThrow(null);
		return orElseThrow;
	}

	@Override
	public void deleteCategory(Long categoryId) {
		// TODO Auto-generated method stub
		this.categoryRepository.deleteById(categoryId);
	}

	@Override
	public Category updateCategory(Category category, long cId) {
		// TODO Auto-generated method stub
//		Optional<Category> findById = this.categoryRepository.findById(cId);
//		long cId2 = findById.get().getcId();
//		this.categoryRepository.deleteById(findById.get().getcId());
//		category.setcId(cId2);
//		Category save = this.categoryRepository.save(category);
//		return save;
		Category existingCategory = categoryRepository.findById(cId).orElse(null);
        if (existingCategory != null) {
            existingCategory.setTitle(category.getTitle());
            existingCategory.setDescription(category.getDescription());
            existingCategory.setQuizess(category.getQuizess() );
            return categoryRepository.save(existingCategory);
        }
        return null;
	}

}
