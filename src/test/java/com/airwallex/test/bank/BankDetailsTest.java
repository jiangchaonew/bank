package com.airwallex.test.bank;

import com.airwallex.test.utils.GenerateRadom;
import com.airwallex.test.utils.HttpUtils;
import com.airwallex.test.utils.JsonUtils;
import com.mashape.unirest.http.HttpResponse;
import com.neovisionaries.i18n.CountryCode;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

@ContextConfiguration(locations = "classpath:spring-context.xml")
public class BankDetailsTest extends AbstractTestNGSpringContextTests {

    @Value("${url}")
    private String url;

    @Autowired
    private BankDetails bankDetails;

    @Test(groups = { "positive" }, description = "LOCAL US-正常场景")
    public void bankDetailsTestCase1() {

        Random random = new Random();
        bankDetails.setPaymentMethod(ConstantString.LOCAL);
        bankDetails.setBankCountryCode(CountryCode.US.name());
        bankDetails.setAccountName(GenerateRadom.getRandomString(9));
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(9));
        bankDetails.setSwiftCode(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setBsb(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setAba(GenerateRadom.getRandomStringAndNumber(9));

        HttpResponse<String> response = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response.getStatus(), HttpStatus.SC_OK, "响应状态码");
        String message = JsonUtils.parse(response.getBody()).get("success").toString();
        Assert.assertTrue(message.contains(ConstantString.BANK_DETAILS_SAVED), "消息内容");
    }

    @Test(groups = { "positive" }, description = "LOCAL AU-正常场景")
    public void bankDetailsTestCase2() {

        Random random = new Random();
        bankDetails.setPaymentMethod(ConstantString.LOCAL);
        bankDetails.setBankCountryCode(CountryCode.AU.name());
        bankDetails.setAccountName(GenerateRadom.getRandomString(9));
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(9));
        bankDetails.setSwiftCode(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setBsb(GenerateRadom.getRandomStringAndNumber(6));
        bankDetails.setAba(random.nextInt(2) % 2 == 0 ? "" : null);

        HttpResponse<String> response = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response.getStatus(), HttpStatus.SC_OK, "响应状态码");
        String message = JsonUtils.parse(response.getBody()).get("success").toString();
        Assert.assertTrue(message.contains(ConstantString.BANK_DETAILS_SAVED), "消息内容");
    }

    @Test(groups = { "positive" }, description = "LOCAL CN-正常场景")
    public void bankDetailsTestCase3() {

        Random random = new Random();
        bankDetails.setPaymentMethod(ConstantString.LOCAL);
        bankDetails.setBankCountryCode(CountryCode.CN.name());
        bankDetails.setAccountName(GenerateRadom.getRandomChinese(9));
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(9));
        bankDetails.setSwiftCode(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setBsb(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setAba(random.nextInt(2) % 2 == 0 ? "" : null);

        HttpResponse<String> response = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response.getStatus(), HttpStatus.SC_OK, "响应状态码");
        String message = JsonUtils.parse(response.getBody()).get("success").toString();
        Assert.assertTrue(message.contains(ConstantString.BANK_DETAILS_SAVED), "消息内容");
    }

    @Test(groups = { "positive" }, description = "SWIFT US-正常场景")
    public void bankDetailsTestCase4() {

        Random random = new Random();
        bankDetails.setPaymentMethod(ConstantString.SWIFT);
        bankDetails.setBankCountryCode(CountryCode.US.name());
        bankDetails.setAccountName(GenerateRadom.getRandomString(9));
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(9));
        bankDetails.setSwiftCode("BOFAUS3N");
        bankDetails.setBsb(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setAba(GenerateRadom.getRandomStringAndNumber(9));

        HttpResponse<String> response = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response.getStatus(), HttpStatus.SC_OK, "响应状态码");
        String message = JsonUtils.parse(response.getBody()).get("success").toString();
        Assert.assertTrue(message.contains(ConstantString.BANK_DETAILS_SAVED), "消息内容");
    }

    @Test(groups = { "positive" }, description = "SWIFT AU-正常场景")
    public void bankDetailsTestCase5() {

        Random random = new Random();
        bankDetails.setPaymentMethod(ConstantString.SWIFT);
        bankDetails.setBankCountryCode(CountryCode.AU.name());
        bankDetails.setAccountName(GenerateRadom.getRandomString(9));
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(9));
        bankDetails.setSwiftCode("CTBAAU2S");
        bankDetails.setBsb(GenerateRadom.getRandomStringAndNumber(6));
        bankDetails.setAba(random.nextInt(2) % 2 == 0 ? "" : null);

        HttpResponse<String> response = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response.getStatus(), HttpStatus.SC_OK, "响应状态码");
        String message = JsonUtils.parse(response.getBody()).get("success").toString();
        Assert.assertTrue(message.contains(ConstantString.BANK_DETAILS_SAVED), "消息内容");
    }

    @Test(groups = { "positive" }, description = "SWIFT CN-正常场景")
    public void bankDetailsTestCase6() {

        Random random = new Random();
        bankDetails.setPaymentMethod(ConstantString.SWIFT);
        bankDetails.setBankCountryCode(CountryCode.CN.name());
        bankDetails.setAccountName(GenerateRadom.getRandomChinese(9));
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(9));
        bankDetails.setSwiftCode("ICBKCNBJ");
        bankDetails.setBsb(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setAba(random.nextInt(2) % 2 == 0 ? "" : null);

        HttpResponse<String> response = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response.getStatus(), HttpStatus.SC_OK, "响应状态码");
        String message = JsonUtils.parse(response.getBody()).get("success").toString();
        Assert.assertTrue(message.contains(ConstantString.BANK_DETAILS_SAVED), "消息内容");
    }

    @Test(groups = { "negative" }, description = "通用-支付方式为随机数")
    public void bankDetailsTestCase7() {

        Random random = new Random();
        bankDetails.setPaymentMethod(GenerateRadom.getRandomString(6));
        bankDetails.setBankCountryCode(CountryCode.US.name());
        bankDetails.setAccountName(GenerateRadom.getRandomString(9));
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(9));
        bankDetails.setSwiftCode(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setBsb(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setAba(GenerateRadom.getRandomStringAndNumber(9));

        HttpResponse<String> response = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response.getStatus(), HttpStatus.SC_BAD_REQUEST, "响应状态码");
        String message = JsonUtils.parse(response.getBody()).get("error").toString();
        Assert.assertTrue(message.contains(ConstantString.REQUIRED_PAYMENT_METHOD), "消息内容");
    }

    @Test(groups = { "negative" }, description = "通用-支付方式为空")
    public void bankDetailsTestCase8() {

        Random random = new Random();
        bankDetails.setPaymentMethod(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setBankCountryCode(CountryCode.US.name());
        bankDetails.setAccountName(GenerateRadom.getRandomString(9));
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(9));
        bankDetails.setSwiftCode(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setBsb(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setAba(GenerateRadom.getRandomStringAndNumber(9));

        HttpResponse<String> response = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response.getStatus(), HttpStatus.SC_BAD_REQUEST, "响应状态码");
        String message = JsonUtils.parse(response.getBody()).get("error").toString();
        Assert.assertTrue(message.contains(ConstantString.REQUIRED_PAYMENT_METHOD), "消息内容");
    }

    @Test(groups = { "negative" }, description = "通用-银行国家代码为随机数")
    public void bankDetailsTestCase9() {

        Random random = new Random();
        bankDetails.setPaymentMethod(ConstantString.LOCAL);
        bankDetails.setBankCountryCode(GenerateRadom.getRandomString(3));
        bankDetails.setAccountName(GenerateRadom.getRandomString(9));
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(9));
        bankDetails.setSwiftCode(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setBsb(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setAba(GenerateRadom.getRandomStringAndNumber(9));

        HttpResponse<String> response = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response.getStatus(), HttpStatus.SC_BAD_REQUEST, "响应状态码");
        String message = JsonUtils.parse(response.getBody()).get("error").toString();
        Assert.assertTrue(message.contains(ConstantString.BANK_COUNTRY_CODE), "消息内容");
    }

    @Test(groups = { "negative" }, description = "通用-银行国家代码为空")
    public void bankDetailsTestCase10() {

        Random random = new Random();
        bankDetails.setPaymentMethod(ConstantString.LOCAL);
        bankDetails.setBankCountryCode(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setAccountName(GenerateRadom.getRandomString(9));
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(9));
        bankDetails.setSwiftCode(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setBsb(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setAba(GenerateRadom.getRandomStringAndNumber(9));

        HttpResponse<String> response = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response.getStatus(), HttpStatus.SC_BAD_REQUEST, "响应状态码");
        String message = JsonUtils.parse(response.getBody()).get("error").toString();
        Assert.assertTrue(message.contains(ConstantString.BANK_COUNTRY_CODE), "消息内容");
    }

    @Test(groups = { "negative" }, description = "通用-账户名称不符合字符限制")
    public void bankDetailsTestCase11() {

        Random random = new Random();
        bankDetails.setPaymentMethod(ConstantString.LOCAL);
        bankDetails.setBankCountryCode(CountryCode.US.name());
        bankDetails.setAccountName(GenerateRadom.getRandomString(11));
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(9));
        bankDetails.setSwiftCode(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setBsb(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setAba(GenerateRadom.getRandomStringAndNumber(9));

        HttpResponse<String> response = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response.getStatus(), HttpStatus.SC_BAD_REQUEST, "响应状态码");
        String message = JsonUtils.parse(response.getBody()).get("error").toString();
        Assert.assertTrue(message.contains(ConstantString.LENGTH_ACCOUNT_NAME), "消息内容");
    }

    @Test(groups = { "negative" }, description = "通用-账户名称为空")
    public void bankDetailsTestCase12() {

        Random random = new Random();
        bankDetails.setPaymentMethod(ConstantString.LOCAL);
        bankDetails.setBankCountryCode(CountryCode.US.name());
        bankDetails.setAccountName(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(9));
        bankDetails.setSwiftCode(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setBsb(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setAba(GenerateRadom.getRandomStringAndNumber(9));

        HttpResponse<String> response = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response.getStatus(), HttpStatus.SC_BAD_REQUEST, "响应状态码");
        String message = JsonUtils.parse(response.getBody()).get("error").toString();
        Assert.assertTrue(message.contains(ConstantString.REQUIRED_ACCOUNT_NAME), "消息内容");
    }

    @Test(groups = { "negative" }, description = "通用-账号为空")
    public void bankDetailsTestCase13() {

        Random random = new Random();
        bankDetails.setPaymentMethod(ConstantString.LOCAL);
        bankDetails.setBankCountryCode(CountryCode.US.name());
        bankDetails.setAccountName(GenerateRadom.getRandomString(9));
        bankDetails.setAccountNumber(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setSwiftCode(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setBsb(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setAba(GenerateRadom.getRandomStringAndNumber(9));

        HttpResponse<String> response = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response.getStatus(), HttpStatus.SC_BAD_REQUEST, "响应状态码");
        String message = JsonUtils.parse(response.getBody()).get("error").toString();
        Assert.assertTrue(message.contains(ConstantString.REQUIRED_ACCOUNT_NUMBER), "消息内容");
    }

    @Test(groups = { "negative" }, description = "LOCAL US-aba为空")
    public void bankDetailsTestCase14() {

        Random random = new Random();
        bankDetails.setPaymentMethod(ConstantString.LOCAL);
        bankDetails.setBankCountryCode(CountryCode.US.name());
        bankDetails.setAccountName(GenerateRadom.getRandomString(9));
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(9));
        bankDetails.setSwiftCode(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setBsb(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setAba(random.nextInt(2) % 2 == 0 ? "" : null);

        HttpResponse<String> response = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response.getStatus(), HttpStatus.SC_BAD_REQUEST, "响应状态码");
        String message = JsonUtils.parse(response.getBody()).get("error").toString();
        Assert.assertTrue(message.contains(ConstantString.REQUIRED_ABA), "消息内容");
    }

    @Test(groups = { "negative" }, description = "LOCAL US-aba不符合字符限制")
    public void bankDetailsTestCase15() {

        Random random = new Random();
        bankDetails.setPaymentMethod(ConstantString.LOCAL);
        bankDetails.setBankCountryCode(CountryCode.US.name());
        bankDetails.setAccountName(GenerateRadom.getRandomString(9));
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(9));
        bankDetails.setSwiftCode(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setBsb(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setAba(GenerateRadom.getRandomStringAndNumber(10));

        HttpResponse<String> response = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response.getStatus(), HttpStatus.SC_BAD_REQUEST, "响应状态码");
        String message = JsonUtils.parse(response.getBody()).get("error").toString();
        Assert.assertTrue(message.contains(ConstantString.LENGTH_ABA), "消息内容");
    }

    @Test(groups = { "negative" }, description = "LOCAL US-账号不符合字符限制")
    public void bankDetailsTestCase16() {

        Random random = new Random();
        bankDetails.setPaymentMethod(ConstantString.LOCAL);
        bankDetails.setBankCountryCode(CountryCode.US.name());
        bankDetails.setAccountName(GenerateRadom.getRandomString(9));
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(18));
        bankDetails.setSwiftCode(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setBsb(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setAba(GenerateRadom.getRandomStringAndNumber(9));

        HttpResponse<String> response = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response.getStatus(), HttpStatus.SC_BAD_REQUEST, "响应状态码");
        String message = JsonUtils.parse(response.getBody()).get("error").toString();
        Assert.assertTrue(message.contains(ConstantString.US_ACCOUNT_NUMBER), "消息内容");
    }

    @Test(groups = { "negative" }, description = "LOCAL AU-bsb为空")
    public void bankDetailsTestCase17() {

        Random random = new Random();
        bankDetails.setPaymentMethod(ConstantString.LOCAL);
        bankDetails.setBankCountryCode(CountryCode.AU.name());
        bankDetails.setAccountName(GenerateRadom.getRandomString(9));
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(9));
        bankDetails.setSwiftCode(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setBsb(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setAba(random.nextInt(2) % 2 == 0 ? "" : null);

        HttpResponse<String> response = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response.getStatus(), HttpStatus.SC_BAD_REQUEST, "响应状态码");
        String message = JsonUtils.parse(response.getBody()).get("error").toString();
        Assert.assertTrue(message.contains(ConstantString.REQUIRED_BSB), "消息内容");
    }

    @Test(groups = { "negative" }, description = "LOCAL AU-bsb不符合字符限制")
    public void bankDetailsTestCase18() {

        Random random = new Random();
        bankDetails.setPaymentMethod(ConstantString.LOCAL);
        bankDetails.setBankCountryCode(CountryCode.AU.name());
        bankDetails.setAccountName(GenerateRadom.getRandomString(9));
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(9));
        bankDetails.setSwiftCode(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setBsb(GenerateRadom.getRandomStringAndNumber(5));
        bankDetails.setAba(random.nextInt(2) % 2 == 0 ? "" : null);

        HttpResponse<String> response = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response.getStatus(), HttpStatus.SC_BAD_REQUEST, "响应状态码");
        String message = JsonUtils.parse(response.getBody()).get("error").toString();
        Assert.assertTrue(message.contains(ConstantString.LENGTH_BSB), "消息内容");
    }

    @Test(groups = { "negative" }, description = "LOCAL AU-账号不符合字符限制")
    public void bankDetailsTestCase19() {

        Random random = new Random();
        bankDetails.setPaymentMethod(ConstantString.LOCAL);
        bankDetails.setBankCountryCode(CountryCode.AU.name());
        bankDetails.setAccountName(GenerateRadom.getRandomString(9));
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(10));
        bankDetails.setSwiftCode(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setBsb(GenerateRadom.getRandomStringAndNumber(6));
        bankDetails.setAba(random.nextInt(2) % 2 == 0 ? "" : null);

        HttpResponse<String> response = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response.getStatus(), HttpStatus.SC_BAD_REQUEST, "响应状态码");
        String message = JsonUtils.parse(response.getBody()).get("error").toString();
        Assert.assertTrue(message.contains(ConstantString.AU_ACCOUNT_NUMBER), "消息内容");
    }

    @Test(groups = { "negative" }, description = "LOCAL CN-账号不符合字符限制")
    public void bankDetailsTestCas20() {

        Random random = new Random();
        bankDetails.setPaymentMethod(ConstantString.LOCAL);
        bankDetails.setBankCountryCode(CountryCode.CN.name());
        bankDetails.setAccountName(GenerateRadom.getRandomChinese(9));
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(21));
        bankDetails.setSwiftCode(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setBsb(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setAba(random.nextInt(2) % 2 == 0 ? "" : null);

        HttpResponse<String> response = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response.getStatus(), HttpStatus.SC_BAD_REQUEST, "响应状态码");
        String message = JsonUtils.parse(response.getBody()).get("error").toString();
        Assert.assertTrue(message.contains(ConstantString.CN_ACCOUNT_NUMBER), "消息内容");
    }

    @Test(groups = { "negative" }, description = "SWIFT US-aba为空")
    public void bankDetailsTestCase21() {

        Random random = new Random();
        bankDetails.setPaymentMethod(ConstantString.SWIFT);
        bankDetails.setBankCountryCode(CountryCode.US.name());
        bankDetails.setAccountName(GenerateRadom.getRandomString(9));
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(9));
        bankDetails.setSwiftCode("BOFAUS3N");
        bankDetails.setBsb(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setAba(random.nextInt(2) % 2 == 0 ? "" : null);

        HttpResponse<String> response = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response.getStatus(), HttpStatus.SC_BAD_REQUEST, "响应状态码");
        String message = JsonUtils.parse(response.getBody()).get("error").toString();
        Assert.assertTrue(message.contains(ConstantString.REQUIRED_ABA), "消息内容");
    }

    @Test(groups = { "negative" }, description = "SWIFT US-银行国际代码为空")
    public void bankDetailsTestCase22() {

        Random random = new Random();
        bankDetails.setPaymentMethod(ConstantString.SWIFT);
        bankDetails.setBankCountryCode(CountryCode.US.name());
        bankDetails.setAccountName(GenerateRadom.getRandomString(9));
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(9));
        bankDetails.setSwiftCode(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setBsb(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setAba(GenerateRadom.getRandomStringAndNumber(9));

        HttpResponse<String> response = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response.getStatus(), HttpStatus.SC_BAD_REQUEST, "响应状态码");
        String message = JsonUtils.parse(response.getBody()).get("error").toString();
        Assert.assertTrue(message.contains(ConstantString.REQUIRED_SWIFT_CODE), "消息内容");
    }

    @Test(groups = { "negative" }, description = "SWIFT US-银行国际代码不存在")
    public void bankDetailsTestCase23() {

        Random random = new Random();
        bankDetails.setPaymentMethod(ConstantString.SWIFT);
        bankDetails.setBankCountryCode(CountryCode.US.name());
        bankDetails.setAccountName(GenerateRadom.getRandomString(9));
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(9));
        bankDetails.setSwiftCode(GenerateRadom.getRandomStringAndNumber(12));
        bankDetails.setBsb(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setAba(GenerateRadom.getRandomStringAndNumber(9));

        HttpResponse<String> response = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response.getStatus(), HttpStatus.SC_BAD_REQUEST, "响应状态码");
        String message = JsonUtils.parse(response.getBody()).get("error").toString();
        Assert.assertTrue(message.contains(ConstantString.LENGTH_SWIFT_CODE), "消息内容");
    }

    @Test(groups = { "negative" }, description = "SWIFT AU-bsb为空")
    public void bankDetailsTestCase24() {

        Random random = new Random();
        bankDetails.setPaymentMethod(ConstantString.SWIFT);
        bankDetails.setBankCountryCode(CountryCode.AU.name());
        bankDetails.setAccountName(GenerateRadom.getRandomString(9));
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(9));
        bankDetails.setSwiftCode("CTBAAU2S");
        bankDetails.setBsb(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setAba(random.nextInt(2) % 2 == 0 ? "" : null);

        HttpResponse<String> response = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response.getStatus(), HttpStatus.SC_BAD_REQUEST, "响应状态码");
        String message = JsonUtils.parse(response.getBody()).get("error").toString();
        Assert.assertTrue(message.contains(ConstantString.REQUIRED_BSB), "消息内容");
    }

    @Test(groups = { "negative" }, description = "SWIFT AU-银行国际代码为空")
    public void bankDetailsTestCase25() {

        Random random = new Random();
        bankDetails.setPaymentMethod(ConstantString.SWIFT);
        bankDetails.setBankCountryCode(CountryCode.AU.name());
        bankDetails.setAccountName(GenerateRadom.getRandomString(9));
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(9));
        bankDetails.setSwiftCode(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setBsb(GenerateRadom.getRandomStringAndNumber(6));
        bankDetails.setAba(random.nextInt(2) % 2 == 0 ? "" : null);

        HttpResponse<String> response = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response.getStatus(), HttpStatus.SC_BAD_REQUEST, "响应状态码");
        String message = JsonUtils.parse(response.getBody()).get("error").toString();
        Assert.assertTrue(message.contains(ConstantString.REQUIRED_SWIFT_CODE), "消息内容");
    }

    @Test(groups = { "negative" }, description = "SWIFT AU-银行国际代码不存在")
    public void bankDetailsTestCase26() {

        Random random = new Random();
        bankDetails.setPaymentMethod(ConstantString.SWIFT);
        bankDetails.setBankCountryCode(CountryCode.AU.name());
        bankDetails.setAccountName(GenerateRadom.getRandomString(9));
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(9));
        bankDetails.setSwiftCode(GenerateRadom.getRandomStringAndNumber(12));
        bankDetails.setBsb(GenerateRadom.getRandomStringAndNumber(6));
        bankDetails.setAba(random.nextInt(2) % 2 == 0 ? "" : null);

        HttpResponse<String> response = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response.getStatus(), HttpStatus.SC_BAD_REQUEST, "响应状态码");
        String message = JsonUtils.parse(response.getBody()).get("error").toString();
        Assert.assertTrue(message.contains(ConstantString.LENGTH_SWIFT_CODE), "消息内容");
    }

    @Test(groups = { "negative" }, description = "SWIFT CN-银行国际代码为空")
    public void bankDetailsTestCase27() {

        Random random = new Random();
        bankDetails.setPaymentMethod(ConstantString.SWIFT);
        bankDetails.setBankCountryCode(CountryCode.CN.name());
        bankDetails.setAccountName(GenerateRadom.getRandomChinese(9));
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(9));
        bankDetails.setSwiftCode(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setBsb(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setAba(random.nextInt(2) % 2 == 0 ? "" : null);

        HttpResponse<String> response = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response.getStatus(), HttpStatus.SC_BAD_REQUEST, "响应状态码");
        String message = JsonUtils.parse(response.getBody()).get("error").toString();
        Assert.assertTrue(message.contains(ConstantString.REQUIRED_SWIFT_CODE), "消息内容");
    }

    @Test(groups = { "negative" }, description = "SWIFT CN-银行国际代码不存在")
    public void bankDetailsTestCase28() {

        Random random = new Random();
        bankDetails.setPaymentMethod(ConstantString.SWIFT);
        bankDetails.setBankCountryCode(CountryCode.CN.name());
        bankDetails.setAccountName(GenerateRadom.getRandomChinese(9));
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(9));
        bankDetails.setSwiftCode(GenerateRadom.getRandomStringAndNumber(12));
        bankDetails.setBsb(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setAba(random.nextInt(2) % 2 == 0 ? "" : null);

        HttpResponse<String> response = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response.getStatus(), HttpStatus.SC_BAD_REQUEST, "响应状态码");
        String message = JsonUtils.parse(response.getBody()).get("error").toString();
        Assert.assertTrue(message.contains(ConstantString.LENGTH_SWIFT_CODE), "消息内容");
    }

    @Test(groups = { "negative" }, description = "LOCAL-账户和账号重复")
    public void bankDetailsTestCase29() {

        Random random = new Random();
        bankDetails.setPaymentMethod(ConstantString.LOCAL);
        bankDetails.setBankCountryCode(CountryCode.US.name());
        bankDetails.setAccountName(GenerateRadom.getRandomString(9));
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(9));
        bankDetails.setSwiftCode(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setBsb(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setAba(GenerateRadom.getRandomStringAndNumber(9));

        HttpResponse<String> response1 = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response1.getStatus(), HttpStatus.SC_OK, "响应状态码");
        String message1 = JsonUtils.parse(response1.getBody()).get("success").toString();
        Assert.assertTrue(message1.contains(ConstantString.BANK_DETAILS_SAVED), "消息内容");

        //重复请求相同参数
        HttpResponse<String> response2 = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response2.getStatus(), HttpStatus.SC_BAD_REQUEST, "响应状态码");
    }

    @Test(groups = { "negative" }, description = "SWIFT-账户和账号重复")
    public void bankDetailsTestCase30() {

        Random random = new Random();
        bankDetails.setPaymentMethod(ConstantString.SWIFT);
        bankDetails.setBankCountryCode(CountryCode.US.name());
        bankDetails.setAccountName(GenerateRadom.getRandomString(9));
        bankDetails.setAccountNumber(GenerateRadom.getRandomNumber(9));
        bankDetails.setSwiftCode("BOFAUS3N");
        bankDetails.setBsb(random.nextInt(2) % 2 == 0 ? "" : null);
        bankDetails.setAba(GenerateRadom.getRandomStringAndNumber(9));

        HttpResponse<String> response1 = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response1.getStatus(), HttpStatus.SC_OK, "响应状态码");
        String message1 = JsonUtils.parse(response1.getBody()).get("success").toString();
        Assert.assertTrue(message1.contains(ConstantString.BANK_DETAILS_SAVED), "消息内容");

        //重复请求相同参数
        HttpResponse<String> response2 = HttpUtils.postJson(url, JsonUtils.toJson(bankDetails));

        Assert.assertEquals(response2.getStatus(), HttpStatus.SC_BAD_REQUEST, "响应状态码");
    }

}
