package com.khaithumc.shopme_backend.repository;

import com.khaithumc.shopme_backend.model.ShippingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingInfoRepository extends JpaRepository<ShippingInfo, Integer> {
    ShippingInfo findShippingInfoById(int id);
}
