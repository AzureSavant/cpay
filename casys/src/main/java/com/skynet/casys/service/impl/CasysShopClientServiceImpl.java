package com.skynet.casys.service.impl;


import com.skynet.casys.models.CasysShopClient;
import com.skynet.casys.repositories.CasysShopClientRepository;
import com.skynet.casys.service.CasysShopClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CasysShopClientServiceImpl implements CasysShopClientService {

    public CasysShopClientServiceImpl() {
    }

    private CasysShopClientRepository casysShopClientRepository;

    @Autowired
    public CasysShopClientServiceImpl(CasysShopClientRepository casysShopClientRepository) {
        this.casysShopClientRepository = casysShopClientRepository;
    }


    @Override
    public CasysShopClient getByShopLinkLike(String link) {
        return this.casysShopClientRepository.getByShopLinkLike(link);
    }

    @Override
    public CasysShopClient getById(int id) {
        return this.casysShopClientRepository.getById(id);
    }

    @Override
    public CasysShopClient getByShopLink(String link) {
        return this.casysShopClientRepository.getByShopLink(link);
    }



}
