//package in.codetech.angulareducloud.portal.serviceImpl;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.LinkedHashSet;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import in.codetech.angulareducloud.portal.model.Exam.Category;
//import in.codetech.angulareducloud.portal.repository.CategoryRepository;
//import in.codetech.angulareducloud.portal.service.CategoryService;
//import junit.framework.TestCase;
//
//class CategoryServiceImplTest extends TestCase {
//	@Mock
//	private CategoryRepository categoryRepository;
//
//	private CategoryService categoryService;
//
//	Category category;
//
//	Optional<Category> category2;
//	AutoCloseable autoCloseable;
//
//	@BeforeEach
//	protected void setUp() throws Exception {
//		autoCloseable = MockitoAnnotations.openMocks(this);
//		categoryService = new CategoryServiceImpl(categoryRepository);
//		category = new Category(1L, "category", "category", null);
//		category2 = Optional.of(category);
//	}
//
//	@AfterEach
//	protected void tearDown() throws Exception {
//		autoCloseable.close();
//	}
//
//	@Test
//	void testAddCategory() {
//		when(categoryRepository.save(category)).thenReturn(category);
//		assertThat(categoryService.addCategory(category).getCid()).isEqualTo(category.getCid());
//	}
//
//	@Test
//	void testGetCategories() {
//		when(categoryRepository.findAll()).thenReturn(
//				new ArrayList<Category>(Collections.singleton(category)));
//	
//		assertThat(categoryService.getCategories().size()).isGreaterThanOrEqualTo(1);
//	}
//
//	@Test
//	void testGetCategory() {
//		when(categoryRepository.findById(1L)).thenReturn(category2);
//		assertThat(categoryService.getCategory(1L).getCid()).isEqualTo(category2.get().getCid());
//	}
//
//	@Test
//	void testDeleteCategory() {
//		categoryService.deleteCategory(1L);
//		verify(categoryRepository).deleteById(category.getCid());
//	}
//
//	@Test
//	void testUpdateCategory() {
//		// Given
//		Long categoryId = 1L;
//		Category updatedCategory = new Category(categoryId, "updatedCategory", "updatedDescription", null);
//
//		when(categoryRepository.findById(categoryId)).thenReturn(category2);
//		when(categoryRepository.save(category)).thenReturn(updatedCategory);
//
//		// When
//		Category result = categoryService.updateCategory(updatedCategory, categoryId);
//
//		// Then
//		verify(categoryRepository).findById(categoryId);
//		verify(categoryRepository).save(category);
//		assertThat(result.getTitle()).isEqualTo(updatedCategory.getTitle());
//		assertThat(result.getDescription()).isEqualTo(updatedCategory.getDescription());
//	}
//
//}
