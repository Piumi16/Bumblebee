package com.bumblebee.assmnt.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bumblebee.assmnt.dao.loanManager;
import com.bumblebee.assmnt.model.Loan;

public class LoanService {
	private static LoanService loanServiceObject;
	private LoanService() {}
	
	public static synchronized LoanService getLoanService() {
		if(loanServiceObject == null) {
			loanServiceObject = new LoanService();
		}		
		return loanServiceObject;
	}
	private loanManager getLoanManager(){
		return new loanManager();
	}

	public boolean registerLoan(Loan loan) throws ClassNotFoundException, SQLException {
		return false;
	}	
	public Loan getSpecificLoan(int loan_id) throws ClassNotFoundException, SQLException {
		return getLoanManager().getSpecificLoan(loan_id);
	}	
	public List<Loan> getAllLoan() throws ClassNotFoundException, SQLException{
		return new ArrayList<Loan>();
	}
	public boolean editTheLoan(Loan loan) throws ClassNotFoundException, SQLException {
		return false;
	}
	public boolean deleteTheLoan(int loan_id) throws ClassNotFoundException, SQLException {
		return false;
	}

}
