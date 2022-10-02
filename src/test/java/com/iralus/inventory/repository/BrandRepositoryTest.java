package com.iralus.inventory.repository;

import com.iralus.inventory.entity.Brand;
import com.iralus.inventory.entity.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
class BrandRepositoryTest {

    private final BrandRepository brandRepository;
    private final TestEntityManager entityManager;

    @Autowired
    BrandRepositoryTest(BrandRepository brandRepository, TestEntityManager entityManager) {
        this.brandRepository = brandRepository;
        this.entityManager = entityManager;
    }

    @BeforeEach
    void setUp() {
        Brand brand =
                Brand.builder()
                        .name("Geely")
                        .status(Status.ACTIVE)
                        .build();
        entityManager.persist(brand);
    }

    @Test
    public void whenFindById_thenReturnBrand(){
        Brand brand = brandRepository.findById(1).get();
        Assertions.assertEquals(brand.getName(), "Geely");
    }
}