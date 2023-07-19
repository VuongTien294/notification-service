package tien.baseproject.notificationservice.constant;

import lombok.Getter;

import java.util.Arrays;

public class MailConstant {

    public static final String SENDER = "Cyberium";

    public interface Subject {
        String SIGNUP = "signup.subject";
        String FORGOT_PASSWORD = "forgot_password.subject";
        String CONTACT_US = "contact_us.subject";
        String VERIFY_CODE = "verify_code.subject";
    }

    public enum SymbolUrl {
        //@formatter:off
        UNKNOWN("-"),
        ADA("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/ADA.png"),
        ATOM("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/ATOM.png"),
        BAND("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/BAND.png"),
        BAT("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/BAT.png"),
        BCH("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/BCH.png"),
        BEL("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/BEL.png"),
        BNB("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/BNB.png"),
        BTC("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/BTC.png"),
        BTCB("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/BTCB.png"),
        BUSD("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/BUSD.png"),
        BUSDT("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/BUSD-T.png"),
        COMP("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/COMP.png"),
        DAI("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/DAI.png"),
        DFY("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/DFY.png"),
        DOT("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/DOT.png"),
        ELF("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/ELF.png"),
        EOS("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/EOS.png"),
        ETC("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/ETC.png"),
        ETH("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/ETH.png"),
        FIL("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/FIL.png"),
        INJ("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/INJ.png"),
        IOTX("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/IOTX.png"),
        LINK("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/LINK.png"),
        LTC("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/LTC.png"),
        MKR("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/MKR.png"),
        NEAR("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/NEAR.png"),
        ONT("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/ONT.png"),
        PAX("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/PAX.png"),
        SNX("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/SNX.png"),
        SXP("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/SXP.png"),
        TCT("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/TCT.png"),
        UNI("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/UNI.png"),
        USDC("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/USDC.png"),
        USDT("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/USDT.png"),
        WBNB("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/WBNB.png"),
        XRP("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/XRP.png"),
        XTZ("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/XTZ.png"),
        YFI("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/YFI.png"),
        YFII("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/YFII.png"),
        ZEC("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/ZEC.png"),
        ALPACA("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/ALPACA.png"),
        AVA("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/AVA.png"),
        BABY("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/BABY.png"),
        BLS("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/BLS.png"),
        BSW("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/BSW.png"),
        CAKE("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/CAKE.png"),
        EFUN("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/EFUN.png"),
        NFTD("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/NFTD.png"),
        TRVL("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/TRVL.png"),
        UNO("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/UNO.png"),
        WST("https://s3.ap-southeast-1.amazonaws.com/beta-storage-dfy/upload/WST.png");
        //@formatter:on

        @Getter
        private final String url;

        private SymbolUrl(String url) {
            this.url = url;
        }

        public static String getUrlFromSymbol(String symbol) {
            return Arrays.stream(SymbolUrl.values())
                    .filter(s -> s.name().equals(symbol))
                    .findFirst()
                    .orElse(UNKNOWN)
                    .getUrl();
        }
    }

    public enum Template {
        //@formatter:off
        COLLATERAL_CREATE_BORROWER("collateral-create-borrower", "/inventory/collateral/{collateralId}", "Collateral Package Created"),
        COLLATERAL_CANCEL_BORROWER("collateral-cancel-borrower", "/inventory/collateral/", "Collateral Package Withdrawn"),
        COLLATERAL_REJECT_PAWNSHOP_TO_BORROWER("collateral-reject-pawnshop-to-borrower", "/inventory/collateral/{collateralId}", "/profile?type={type-id}&walletAddress={lenderWallet}", "Collateral Rejected"),
        COLLATERAL_REJECT_LENDER_TO_BORROWER("collateral-reject-lender-to-borrower", "/inventory/collateral/", "/profile?type={type-id}&walletAddress={lenderWallet}", "Collateral Rejected"),
        COLLATERAL_REJECT_PAWNSHOP("collateral-reject-pawnshop-and-lender", "/inventory/loan-package/{loanPackageId}", "Collateral Successfully Rejected"),
        COLLATERAL_REJECT_LENDER("collateral-reject-pawnshop-and-lender", "/inventory/loan-package/{loanPackageId}", "Collateral Successfully Rejected"),
        COLLATERAL_SEND_LENDER_TO_BORROWER("collateral-send-lender-to-borrower", "/inventory/collateral/{collateralId}", "/profile?type={typeId}&walletAddress={lenderWallet}", "Loan Request Sent"),
        COLLATERAL_SEND_PAWNSHOP_TO_BORROWER("collateral-send-pawnshop-to-borrower", "/inventory/collateral/{collateralId}", "/profile?type={typeId}&walletAddress={lenderWallet}", "Collateral Sent"),
        COLLATERAL_SEND_LENDER("collateral-send-lender", "/pawn/lender/{collateralId}", "Loan Request Received"),
        COLLATERAL_SEND_PAWNSHOP("collateral-send-pawnshop", "/pawn/lender/{collateralId}", "Collateral Received"),
        LOAN_PACKAGE_CANCEL_AUTO_PAWNSHOP("loan-package-cancel-auto-pawnshop", "/inventory/loan-package/{loanPackageId}", "Successfully Cancelled Loan Package"),
        LOAN_PACKAGE_CANCEL_NEGOTIATION_PAWNSHOP("loan-package-cancel-negotiation-pawnshop", "/inventory/loan-package/{loanPackageId}", "Successfully Cancelled Loan Package"),
        LOAN_PACKAGE_CANCEL_SEMIAUTO_PAWNSHOP("loan-package-cancel-semiauto-pawnshop", "/inventory/loan-package/{loanPackageId}", "Successfully Cancelled Loan Package"),
        LOAN_PACKAGE_CREATE_AUTO_PAWNSHOP("loan-package-create-auto-pawnshop", "/inventory/loan-package/{loanPackageId}", "Successfully Created Loan Package"),
        LOAN_PACKAGE_CREATE_NEGOTIATION_PAWNSHOP("loan-package-create-negotiation-pawnshop", "/inventory/loan-package/{loanPackageId}", "Successfully Created Loan Package"),
        LOAN_PACKAGE_CREATE_SEMIAUTO_PAWNSHOP("loan-package-create-semiauto-pawnshop", "/inventory/loan-package/{loanPackageId}", "Successfully Created Loan Package"),
        LOAN_PACKAGE_REOPEN_AUTO_PAWNSHOP("loan-package-reopen-auto-pawnshop", "/inventory/loan-package/{loanPackageId}", "Successfully Reopened Loan Package"),
        LOAN_PACKAGE_REOPEN_NEGOTIATION_PAWNSHOP("loan-package-reopen-negotiation-pawnshop", "/inventory/loan-package/{loanPackageId}", "Successfully Reopened Loan Package"),
        LOAN_PACKAGE_REOPEN_SEMIAUTO_PAWNSHOP("loan-package-reopen-semiauto-pawnshop", "/inventory/loan-package/{loanPackageId}", "Successfully Reopened Loan Package"),
        OFFER_CANCEL_LENDER("offer-cancel-lender", "/inventory/offer/{offerId}", "Offer Cancellation Successful"),
        OFFER_CREATE_BORROWER("offer-create-borrower", "/inventory/collateral/{collateralId}", "Loan Offer Received"),
        OFFER_CREATE_LENDER("offer-create-lender", "/inventory/offer/{offerId}", "Offer Creation Successful"),
        OFFER_REJECT_BORROWER("offer-reject-borrower", "/inventory/collateral/{collateralId}", "Offer Rejection Successful"),
        OFFER_REJECT_LENDER("offer-reject-lender", "/inventory/offer/{offerId}", "Offer Rejected"),
        NEW_CONTRACT_BORROWER("new-contract-borrower", "/inventory/contract/borrow/{contractId}", "/inventory/contract/borrow/{contractId}", "New Smart Contract Generated"),
        NEW_CONTRACT_LENDER("new-contract-lender", "/inventory/contract/loan/{contractId}", "New Smart Contract Generated"),
        GENERATE_PERIOD_INTEREST_BORROWER("generate-period-interest-borrower", "/inventory/contract/borrow/{contractId}", "Your Loan is Due Soon"),
        GENERATE_PERIOD_LOAN_BORROWER("generate-period-loan-borrower", "/inventory/contract/borrow/{contractId}", "Your Loan is Due Soon"),
        GENERATE_PERIOD_PENALTY_BORROWER("generate-period-penalty-borrower", "/inventory/contract/borrow/{contractId}", "Your Loan is Due Soon"),
        REPAYMENT_BORROWER("repayment-borrower", "/inventory/contract/borrow/{contractId}", "Repayment Confirmation"),
        REPAYMENT_LENDER("repayment-lender", "/inventory/contract/lend/{contractId}", "Confirmation of Payment Received"),
        ALERT_LTV_LIQUIDATION_THRESHOLD_BORROWER("alert-ltv-liquidation-threshold-borrower", "/inventory/contract/borrow/{contractId}", "Urgent_ LTV Has Reached Liquidation Threshold"),
        COMPLETE_CONTRACT_BORROWER("complete-contract-borrower", "/inventory/contract/borrow/{contractId}", "Contract Successfully Completed"),
        NFT_COMPLETE_CONTRACT_BORROWER("nft-complete-contract-borrower", "/inventory/contract/borrow/{contractId}", "Contract Successfully Completed"),
        NFT_COMPLETE_CONTRACT_LENDER("nft-complete-contract-lender", "/inventory/contract/lend/{contractId}", "Your Contract is Completed"),
        DEFAULT_CONTRACT_LTV_LIQUIDATION_THRESHOLD_BORROWER("default-contract-ltv-liquidation-threshold-borrower", "/inventory/contract/borrow/", "Collateral Liquidation"),
        DEFAULT_CONTRACT_LTV_LIQUIDATION_THRESHOLD_LENDER("default-contract-ltv-liquidation-threshold-borrower", "/inventory/contract/borrow/", "Your Borrower's Collateral Was Liquidated"),
        LOAN_REPAYMENT_BORROWER("loan-repayment-borrower", "/inventory/loan-package/{loanPackageId}", "Collateral Liquidation"),
        NFT_LOAN_REPAYMENT_BORROWER("nft-loan-repayment-borrower", "/inventory/loan-package/{loanPackageId}", "Collateral Liquidation"),
        LOAN_REPAYMENT_LENDER("loan-repayment-borrower", "/inventory/loan-package/{loanPackageId}", "Your Borrower's Collateral Was Liquidated"),
        NFT_LOAN_REPAYMENT_LENDER("nft-loan-repayment-borrower", "/inventory/loan-package/{loanPackageId}", "Your Borrower's Collateral Was Liquidated"),
        DEFAULT_CONTRACT_MAX_LATE_PAYMENT_BORROWER("default-contract-max-late-payment-borrower", "/inventory/contract/lend/", "Collateral Liquidation"),
        DEFAULT_NFT_CONTRACT_MAX_LATE_PAYMENT_BORROWER("default-nft-contract-max-late-payment-borrower", "/inventory/contract/lend/", "Collateral Liquidation"),
        DEFAULT_CONTRACT_MAX_LATE_PAYMENT_LENDER("default-contract-max-late-payment-lender", "/inventory/contract/lend/", "Your Borrower's Collateral Was Liquidated"),
        DEFAULT_NFT_CONTRACT_MAX_LATE_PAYMENT_LENDER("default-nft-contract-max-late-payment-lender", "/inventory/contract/lend/", "Your Borrower's Collateral Was Liquidated"),
        WITHDRAW_COLLATERAL_NFT("collateral-withdraw-successfully", null, "Withdraw Collateral");
        //@formatter:on

        @Getter
        private final String templateName;

        @Getter
        private final String link1;

        @Getter
        private String link2 = null;

        @Getter
        private String subject;

        private Template(String templateName, String link, String subjectMail) {
            this.templateName = templateName;
            this.link1 = link;
            this.subject = subjectMail;
        }

        private Template(String templateName, String link1, String link2, String subjectMail) {
            this.templateName = templateName;
            this.link1 = link1;
            this.link2 = link2;
            this.subject = subjectMail;
        }
    }

    public enum Type {
        NOTIFICATION_EMAIL(0),
        ACTIVITIES_EMAIL(1),
        OTHER_USER_EMAIL(2);

        @Getter
        int code;

        Type(int code) {
            this.code = code;
        }
    }
}
