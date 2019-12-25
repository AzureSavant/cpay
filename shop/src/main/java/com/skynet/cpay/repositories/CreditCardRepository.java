package com.skynet.cpay.repositories;

import com.skynet.cpay.models.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Integer> {
    CreditCard findByCreditCardNumber(String creditCardNumber);

}
