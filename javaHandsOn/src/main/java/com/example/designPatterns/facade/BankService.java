package com.example.designPatterns.facade;

import com.example.designPatterns.facade.subsystem.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class BankService {

    @EJB
    CreditRatingService creditRatingService;

    @EJB
    InternalBankPolicyService internalBankPolicyService;

    @EJB
    RepaymentAbilityService repaymentAbilityService;

    @EJB
    TransferService transferService;

    public boolean processLoanApplication(Customer c, double principle, double income, int months){

        // call the different services to perform the respective function to:
        // 1) analyse customer ability
        // 2) perform the required action

        return true;
    }
}
