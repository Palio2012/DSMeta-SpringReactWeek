package io.github.palio2012.dsmeta.controllers;

import io.github.palio2012.dsmeta.entities.Sale;
import io.github.palio2012.dsmeta.services.SaleService;
import io.github.palio2012.dsmeta.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService service;
    @Autowired
    private SmsService smsService;

    @GetMapping
    public Page <Sale> findSales (
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        return service.findSales(minDate, maxDate, pageable);
    }

    @GetMapping("/{id}/notification")
    public void notifySms (@PathVariable Long id) {
        smsService.sendSms(id);
    }
}

