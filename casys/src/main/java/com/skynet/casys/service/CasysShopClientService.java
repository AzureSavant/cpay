package com.skynet.casys.service;

import com.skynet.casys.models.CasysShopClient;
import org.springframework.stereotype.Repository;

@Repository
public interface CasysShopClientService {
    CasysShopClient getByShopLinkLike(String link);
    CasysShopClient getById(int id);
    CasysShopClient getByShopLink(String link);

}
