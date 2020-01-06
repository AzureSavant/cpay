package com.skynet.casys.controllers;

import com.skynet.casys.models.CasysShopClient;
import com.skynet.casys.models.CreditCard;
import com.skynet.casys.models.Transaction;
import com.skynet.casys.repositories.CreditCardRepository;
import com.skynet.casys.service.impl.CasysShopClientServiceImpl;
import com.skynet.casys.service.impl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.util.Objects;

@Controller
public class TransactionController {

    private final CreditCardRepository creditCardRepository;
    private Transaction transaction;
    private final TransactionServiceImpl transactionService;
    private CasysShopClientServiceImpl casysShopClientService;

    @Autowired
    public TransactionController(CreditCardRepository creditCardRepository, TransactionServiceImpl transactionService,
                                 CasysShopClientServiceImpl casysShopClientService) {
        this.creditCardRepository = creditCardRepository;
        this.transactionService = transactionService;
        this.casysShopClientService = casysShopClientService;
    }

    @RequestMapping(value = "/casys/transaction",method = RequestMethod.POST, params = "confirm")
    public String transaction(Model model,
                              @RequestParam("name") String name,
                              @RequestParam("creditCardNumber") String creditCardNumber,
                              @RequestParam("creditCardType") String creditCardType,
                              @RequestParam("expirationMonth") int expirationMonth,
                              @RequestParam("expirationYear") int expirationYear,
                              @RequestParam("securityCode") String securityCode,
                              @RequestParam("Sproduct") String product,
                              @RequestParam("price")Double price,
                              @RequestParam("baseUrl") String baseUrl,
                              HttpServletRequest request){

        String errorMessage="";

        int securityCodeInteger = Integer.parseInt(securityCode);
        boolean isValid=true;
        CreditCard creditCard = creditCardRepository.findByCreditCardNumber(creditCardNumber);

        if (creditCard == null) {
            final String currUrl= product+"?baseUrl="+baseUrl+"&price="+price;
            model.addAttribute("baseUrl",currUrl);
            model.addAttribute("errorMessage", "Invalid credit card number! Credit Card does not exist.");
            return "failure.html";
        }

        int currentMonth = LocalDate.now().getMonthValue();
        int currentYear = LocalDate.now().getYear();

        if (creditCard.getExpirationYear() < currentYear) {
            isValid=false;
            errorMessage=errorMessage+" Renew your Credit Card";

        }
        if (currentYear == creditCard.getExpirationYear()) {
            if (creditCard.getExpirationMonth() < currentMonth) {
                isValid=false;
                errorMessage= errorMessage+" Renew your Credit Card";

            }
        }
        if (securityCodeInteger != creditCard.getSecurityCode()) {
            isValid=false;
            errorMessage=errorMessage+" Invalid Security Code! Try again";

        }
        if(!Objects.equals(creditCardType, creditCard.getCreditCardType())){
            isValid=false;
            errorMessage=errorMessage+" Invalid Credit Card Type";

        }
        if(!Objects.equals(name,creditCard.getName())){
            isValid=false;
            errorMessage=errorMessage+" invalid user";
        }

        if (isValid){

            CasysShopClient shopClient= casysShopClientService.getByShopLinkLike(baseUrl);
            transaction = new Transaction(product, creditCard, price,baseUrl);
            transactionService.saveTransaction(transaction);
            String dataToSend= transaction.getProduct()+" From:"
                    +transaction.getCreditCard().getName()+" Cost:"+transaction.getCost();
            sendTransactionInfo(dataToSend, shopClient.getShopLinkRef());
            model.addAttribute("baseUrl",baseUrl);
            model.addAttribute("Message", "Transaction: "+ transaction.toString());
            return "success.html";
        }
        else {
            final String currUrl= product+"?baseUrl="+baseUrl+"&price="+price;
            model.addAttribute("baseUrl",currUrl);
            model.addAttribute("errorMessage", errorMessage);
            return "failure.html";
        }
    }

    @RequestMapping(value = "casys/transaction",method = RequestMethod.POST,params = "cancel")
    public String cancelTransaction(@RequestParam("baseUrl")String baseUrl){
        return "redirect:"+ baseUrl;
    }

    private  void sendTransactionInfo(String info,String url){
        RestTemplate template= new RestTemplate();
        template.postForLocation(url,info);
    }                                                   


}
