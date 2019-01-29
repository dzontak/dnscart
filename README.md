# dnscart
```
        static Order domainOrder = new DomainOrder();
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
                
               Cart shoppingCart = domainOrder.newShoppingCart();
        shoppingCart.addItem("google.com");
        shoppingCart.addItem("google.net");
        shoppingCart.addItem("google.info");
        shoppingCart.addItem("google.org");

        BigDecimal expectedTotal = BigDecimal.valueOf(15.99 + 9.99 + 11.25 + 1.00)
                .setScale(2, RoundingMode.HALF_EVEN);
                
        BigDecimal calculatedCart = shoppingCart.calculate();         
```
