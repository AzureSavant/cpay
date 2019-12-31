package com.skynet.casys.repositories;

import com.skynet.casys.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository <Client,Integer> {

}
