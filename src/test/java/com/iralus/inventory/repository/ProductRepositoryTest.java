package com.iralus.inventory.repository;

import com.iralus.inventory.entity.Brand;
import com.iralus.inventory.entity.Model;
import com.iralus.inventory.entity.Product;
import com.iralus.inventory.entity.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;


@DataJpaTest
@ActiveProfiles("test")
class ProductRepositoryTest {

    private final ProductRepository productRepository;
    private final TestEntityManager entityManager;

    @Autowired
    ProductRepositoryTest(ProductRepository productRepository, TestEntityManager entityManager) {
        this.productRepository = productRepository;
        this.entityManager = entityManager;
    }

    @BeforeEach
    void setUp() {
        Brand brand =
                Brand.builder()
                        .name("Geely")
                        .status(Status.ACTIVE)
                        .build();

        Model model =
                Model.builder()
                        .name("Panda 1.0")
                        .brand(brand)
                        .status(Status.ACTIVE)
                        .build();

        Product product =
                Product.builder()
                        .name("Alternator 1.0")
                        .tagName("Panda 1.0 (90A) Alternator(Newdon)")
                        .oem("JFZ1822")
                        .hsCode("85115000")
                        .volume(5168.0)
                        .weight(4.54)
                        .brand(brand)
                        .model(model)
                        .status(Status.ACTIVE)
                        .build();

        entityManager.persist(product);
    }

    @Test
    public void whenFindById_thenReturnProduct(){
        Product product = productRepository.findById(1).get();
        Assertions.assertEquals(product.getName(),"Alternator 1.0");
    }
}