package com.iralus.inventory.repository;

import com.iralus.inventory.entity.FreightRate;
import com.iralus.inventory.entity.ShipmentType;
import com.iralus.inventory.entity.Stakeholder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreightRateRepository extends JpaRepository<FreightRate, Integer> {
    FreightRate findByShippingAgentAndType(Stakeholder shippingAgent, ShipmentType type);
}
