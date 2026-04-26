package com.p2p.service;

import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class LoanServiceTest {

    private static final Logger logger = LogManager.getLogger(LoanServiceTest.class);
    private LoanService service;

    // Dijalankan sebelum setiap test dimulai
    @BeforeEach
    void setUp() {
        service = new LoanService();
    }
    
    @Test
    void shouldRejectLoanWhenBorrowerNotVerified() {
        logger.info("TC-01: shouldRejectLoanWhenBorrowerNotVerified");
        // ==========================
        // SCENARIO:
        // Borrower tidak terverifikasi (KYC = false)
        // Ketika borrower mengajukan pinjaman
        // Maka sistem harus menolak dengan melempar exception
        // ==========================

        // ==========================
        // Arrange (Initial Condition)
        // ==========================
        // Borrower belum lolos proses KYC
        Borrower borrower = new Borrower(false, 700);
        
        // Service yang akan diuji
        LoanService service = new LoanService();
        
        // Jumlah pinjaman valid
        BigDecimal amount = BigDecimal.valueOf(1000);

        // ==========================
        // ACTION & ASSERT (Act & Assert)
        // ==========================
        // Ketika borrower mengajukan loan,
        // sistem harus MENOLAK dengan melempar exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.createLoan(borrower, amount);
        });
        logger.info("TC-01 Berhasil: Exception ditangkap dengan pesan '{}'", exception.getMessage());
        
        // ==========================
        // CATATAN TDD
        // ==========================
    }


    //TC-02
    @Test
    void shouldRejectLoanWhenAmountIsZeroOrNegative() {
        logger.info("TC-02: shouldRejectLoanWhenAmountIsZeroOrNegative");

        Borrower validBorrower = new Borrower(true, 700);
        
        LoanService service = new LoanService();
        
        // Amount tidak valid (0 atau negatif)
        BigDecimal invalidAmount = BigDecimal.ZERO; 
        // BigDecimal invalidAmount = BigDecimal.valueOf(-100); 


        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.createLoan(validBorrower, invalidAmount);
        });

        logger.info("TC-02 Berhasil: Exception ditangkap dengan pesan '{}'", exception.getMessage());
    }

    //TC-03
    @Test
    void shouldApproveLoanWhenCreditScoreHigh() {
        logger.info("TC-03: shouldApproveLoanWhenCreditScoreHigh");
        Borrower validBorrower = new Borrower(true, 700);
        
        LoanService service = new LoanService();
        
        // Amount valid (> 0)
        BigDecimal validAmount = BigDecimal.valueOf(5000); 

        Loan resultLoan = service.createLoan(validBorrower, validAmount);

        assertEquals(Loan.Status.APPROVED, resultLoan.getStatus(), "Status pinjaman harus APPROVED karena credit score tinggi");
        logger.info("TC-03 Berhasil: Status pinjaman dipastikan APPROVED");
    }

    //TC-04
    @Test
    void shouldRejectLoanWhenCreditScoreLow() {
        logger.info("TC-04: shouldRejectLoanWhenCreditScoreLow");
        Borrower validBorrower = new Borrower(true, 500);
        
        LoanService service = new LoanService();
        
        // Amount valid (> 0)
        BigDecimal validAmount = BigDecimal.valueOf(2000); 

        Loan resultLoan = service.createLoan(validBorrower, validAmount);

        // Memastikan status loan adalah REJECTED
        assertEquals(Loan.Status.REJECTED, resultLoan.getStatus(), "Status pinjaman harus REJECTED karena credit score di bawah 600");
        logger.info("TC-04 Berhasil: Status pinjaman dipastikan REJECTED");
    }
}