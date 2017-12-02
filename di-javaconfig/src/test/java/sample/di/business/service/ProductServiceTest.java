package sample.di.business.service;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sample.config.AppConfig;
import sample.di.business.domain.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class ProductServiceTest {
	@Autowired
	ProductService productService;

	@Test
	public void testFindProduct() {
		Product addProduct = new Product("ホチキス", 100);
		productService.addProduct(addProduct);
		Product findProduct = productService.findByProductName("ホチキス");
		assertThat(findProduct, equalTo(addProduct));
	}
}
