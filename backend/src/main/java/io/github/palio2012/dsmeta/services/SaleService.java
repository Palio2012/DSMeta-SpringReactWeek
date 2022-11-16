package io.github.palio2012.dsmeta.services;

import io.github.palio2012.dsmeta.entities.Sale;
import io.github.palio2012.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;


    public List<Sale> findSales () {
        return repository.findAll();
    }
}
