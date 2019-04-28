package com.airwallex.test.bank;

/**
 * @author CHAOJ
 */

public class ConstantString {

    public static final String LOCAL = "LOCAL";

    public static final String SWIFT = "SWIFT";

    public static final String BANK_DETAILS_SAVED = "Bank details saved";

    public static final String REQUIRED_ACCOUNT_NAME = "'account_name' is required";

    public static final String LENGTH_ACCOUNT_NAME = "Length of account_name should be between 2 and 10";

    public static final String REQUIRED_ACCOUNT_NUMBER = "'account_number' is required";

    public static final String US_ACCOUNT_NUMBER = "Length of account_number should be between 7 and 11 when bank_country_code is 'US'";

    public static final String AU_ACCOUNT_NUMBER = "Length of account_number should be between 6 and 9 when bank_country_code is 'AU'";

    public static final String CN_ACCOUNT_NUMBER = "Length of account_number should be between 8 and 20 when bank_country_code is 'US'";

    public static final String BANK_COUNTRY_CODE = "'bank_country_code' is required, and should be one of 'US', 'AU', or 'CN'";

    public static final String REQUIRED_ABA = "'aba' is required when bank country code is 'US'";

    public static final String LENGTH_ABA = "Length of 'aba' should be 9";

    public static final String REQUIRED_BSB = "'bsb' is required when bank country code is 'AU'";

    public static final String LENGTH_BSB = "Length of 'bsb' should be 6";

    public static final String REQUIRED_SWIFT_CODE = "'swift_code' is required when payment method is 'SWIFT'";

    public static final String LENGTH_SWIFT_CODE = "Length of 'swift_code' should be either 8 or 11";

    public static final String REQUIRED_PAYMENT_METHOD = "'payment_method' field required, the value should be either 'LOCAL' or 'SWIFT'";
}
