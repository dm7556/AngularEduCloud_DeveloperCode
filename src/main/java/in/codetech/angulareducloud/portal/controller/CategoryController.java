package in.codetech.angulareducloud.portal.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.codetech.angulareducloud.portal.module.Exam.Category;
import in.codetech.angulareducloud.portal.service.CategoryService;
//sangram
@RestController
@RequestMapping("/api/category")
public class CategoryController {
//aditya
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public Category addCategory(@RequestBody Category category) {
		Category addCategory = this.categoryService.addCategory(category);
		return addCategory;
	}
	
	@PutMapping("/")
	public Category changeCategory(@RequestBody Category category,@PathVariable long cId) {
		Category updateCategory = this.categoryService.updateCategory(category, cId);
		return updateCategory;
	}
	
	@GetMapping("/")
	public Set<Category> getAllCategory(){
		Set<Category> categories = this.categoryService.getCategories();
		return categories;
	}
	
	@GetMapping("/{cId}")
	public Category getCategoryByCategoryId(@PathVariable long cId) {
		Category category = this.categoryService.getCategory(cId);
		return category;
	}
	
}



