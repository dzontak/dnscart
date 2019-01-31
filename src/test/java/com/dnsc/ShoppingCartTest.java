package com.dnsc;

import com.dnsc.domain.DomainType;
import com.dnsc.validation.ValidationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCartTest {

    @Autowired
    Order domainOrder;

    @Before
    public void setUp() {
        /*
            TLD     PRICE
            ------ ----------------------------------------------------
            .com    $15.99 each or 3 for $45.99
            .net    $9.99 each or 10 for $79.99
            .org    $11.25 each or 3 for $29.99
            .info   $1.00 (no volume pricing)
         */


        domainOrder.setPrice(DomainType.COM, BigDecimal.valueOf(15.99),
                BigDecimal.valueOf(45.99), 3);
        domainOrder.setPrice(DomainType.NET, BigDecimal.valueOf(9.99),
                BigDecimal.valueOf(79.99), 10);
        domainOrder.setPrice(DomainType.ORG, BigDecimal.valueOf(11.25),
                BigDecimal.valueOf(29.99), 3);
        domainOrder.setPrice(DomainType.INFO, BigDecimal.valueOf(1.00),
                null, 0);
    }


    @Test
    public void shouldAddPrice() {

        domainOrder.setPrice(DomainType.COM, BigDecimal.valueOf(15.99),
                BigDecimal.valueOf(45.99), 3);

        Assert.assertEquals(domainOrder.getPrice(DomainType.COM).
                getFixedPrice(), BigDecimal.valueOf(15.99));

        Assert.assertEquals(domainOrder.getPrice(DomainType.COM).
                getVolumePrice(), BigDecimal.valueOf(45.99));

        Assert.assertEquals(domainOrder.getPrice(DomainType.COM).
                getVolume(), 3);
    }

    @Test
    public void shouldAddDomainToCart() {

        Cart shoppingCart = domainOrder.newShoppingCart();
        shoppingCart.addItem("google.com");
        Assert.assertEquals(1, shoppingCart.getItems().size());
    }

    @Test(expected = ValidationException.class)
    public void shouldFailToAddInvalidDomain() {

        Cart shoppingCart = domainOrder.newShoppingCart();
        shoppingCart.addItem("google.c");
    }

    @Test
    public void shouldAddDomainAndCalculateCartFixedPrices() {

        Cart shoppingCart = domainOrder.newShoppingCart();
        shoppingCart.addItem("google.com");
        shoppingCart.addItem("google.net");
        shoppingCart.addItem("google.info");
        shoppingCart.addItem("google.org");
        Assert.assertEquals(4, shoppingCart.getItems().size());
        // test fix price calculation
                /*
            TLD     PRICE
            ------ ----------------------------------------------------
            .com    $15.99 each or 3 for $45.99
            .net    $9.99 each or 10 for $79.99
            .org    $11.25 each or 3 for $29.99
            .info   $1.00 (no volume pricing)
         */

        BigDecimal expectedTotal = BigDecimal.valueOf(15.99 + 9.99 + 11.25 + 1.00)
                .setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal calculatedCart = shoppingCart.calculate();
        Assert.assertEquals(expectedTotal, calculatedCart);
    }
    @Test
    public void shouldAddDomainAndCalculateCartVolumePrice() {

        Cart shoppingCart = domainOrder.newShoppingCart();

        // volume price price $45.99
        shoppingCart.addItem("google.com");
        shoppingCart.addItem("happy.com");
        shoppingCart.addItem("java-flavor.com");

         // fixed price  $15.99
        shoppingCart.addItem("google.com");

        // volume price $79.99
        shoppingCart.addItem("domain1.net");
        shoppingCart.addItem("domain2.net");
        shoppingCart.addItem("domain3.net");
        shoppingCart.addItem("domain4.net");
        shoppingCart.addItem("domain5.net");
        shoppingCart.addItem("domain6.net");
        shoppingCart.addItem("domain7.net");
        shoppingCart.addItem("domain8.net");
        shoppingCart.addItem("domain9.net");
        shoppingCart.addItem("domain10.net");

        // volume price $29.99
        shoppingCart.addItem("domain1.org");
        shoppingCart.addItem("domain2.org");
        shoppingCart.addItem("domain3.org");

        // fixed price $3
        shoppingCart.addItem("domain1.info");
        shoppingCart.addItem("domain2.info");
        shoppingCart.addItem("domain3.info");

        ;
        // test fix price calculation
                /*
            TLD     PRICE
            ------ ----------------------------------------------------
            .com    $15.99 each or 3 for $45.99
            .net    $9.99 each or 10 for $79.99
            .org    $11.25 each or 3 for $29.99
            .info   $1.00 (no volume pricing)
         */

        BigDecimal expectedTotal = BigDecimal.valueOf(45.99 + 15.99 + 79.99 + 29.99+ 3.00)
                .setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal calculatedCart = shoppingCart.calculate();
        Assert.assertEquals(expectedTotal, calculatedCart);


    }
}
