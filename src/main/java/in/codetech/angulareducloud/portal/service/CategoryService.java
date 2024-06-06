package in.codetech.angulareducloud.portal.service;

import java.util.Set;

import in.codetech.angulareducloud.portal.model.Exam.Category;

public interface CategoryService {
	public Category addCategory(Category category);

	public Category updateCategory(Category category,long cId);

	public Set<Category> getCategories();

	public Category getCategory(Long categoryId);

	public void deleteCategory(Long categoryId);
}
