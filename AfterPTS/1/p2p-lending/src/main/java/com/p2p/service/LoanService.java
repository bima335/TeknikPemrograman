package com.p2p.service;

import com.p2p.domain.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.math.BigDecimal;

public class LoanService {
    private static final Logger logger = LogManager.getLogger(LoanService.class);

    public Loan createLoan(Borrower borrower, BigDecimal amount) {
        logger.info("Memulai proses createLoan. Amount diajukan: {}", amount);
        // =======
        // VALIDASI (delegasi ke domain)
        // =======
        validateBorrower(borrower);
        validateAmount(amount);

        // =========================
        // CREATE LOAN (domain object)
        // =========================
        Loan loan = new Loan();

        // =========================
        // BUSINESS ACTION (domain behavior)
        // =========================
        if (borrower.getCreditScore() >= 600) {
            loan.approve();
            logger.info("Loan APPROVED. Credit score borrower ({} >= 600).", borrower.getCreditScore());
        } else {
            loan.reject();
            logger.info("Loan REJECTED. Credit score borrower ({} < 600).", borrower.getCreditScore());
        }

        return loan;
    }

    // ====
    // PRIVATE VALIDATION METHOD
    // =========================
    private void validateBorrower(Borrower borrower) {
        if (!borrower.canApplyLoan()) {
            logger.error("Validasi gagal: Borrower belum terverifikasi (KYC)!");
            throw new IllegalArgumentException("Borrower not verified");
        }
    }

    private void validateAmount(BigDecimal amount) {
        // Jika amount <= 0 (compareTo mengembalikan 0 jika sama, dan -1 jika lebih kecil)
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            logger.error("Validasi gagal: Nominal pengajuan tidak valid ({} <= 0)!", amount);
            throw new IllegalArgumentException("Loan amount must be greater than zero");
        }
    }

}