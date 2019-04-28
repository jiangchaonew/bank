package com.airwallex.test.bank;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author CHAOJ
 */

@Data
@Component
public class BankDetails {

    @SerializedName("payment_method")
    private String paymentMethod;

    @SerializedName("bank_country_code")
    private String bankCountryCode;

    @SerializedName("account_name")
    private String accountName;

    @SerializedName("account_number")
    private String accountNumber;

    @SerializedName("swift_code")
    private String swiftCode;

    private String bsb;

    private String aba;

}
