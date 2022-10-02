package com.iralus.inventory.repository;

import com.iralus.inventory.entity.Brand;
import com.iralus.inventory.entity.Model;
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
class ModelRepositoryTest {

    private final ModelRepository modelRepository;
    private final TestEntityManager entityManager;

    @Autowired
    ModelRepositoryTest(ModelRepository modelRepository, TestEntityManager entityManager) {
        this.modelRepository = modelRepository;
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

        entityManager.persist(model);
    }

    @Test
    public void whenFindById_thenReturnModel(){
        Model model = modelRepository.findById(1).get();
        Assertions.assertEquals(model.getName(), "Panda 1.0");
    }
}