package com.skynet.casys.repositories;

import com.skynet.casys.models.CasysShopClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CasysShopClientRepository extends JpaRepository <CasysShopClient,Integer> {
    CasysShopClient getById(int id);
    CasysShopClient getByShopLinkLike(String link);
    CasysShopClient getByShopLink(String link);
}
