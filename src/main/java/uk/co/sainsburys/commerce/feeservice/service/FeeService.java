package uk.co.sainsburys.commerce.feeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.sainsburys.commerce.feeservice.domain.Item;
import uk.co.sainsburys.commerce.feeservice.repository.ItemRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FeeService {

    @Autowired
    private ItemRepository repo;

    private final Map<String, Double> feeCache = new HashMap<>();

    public Double calculateSubTotal(List<String> chargeCodes) {
        double total = 0.0;

        for (String chargeCode : chargeCodes) {
            total += lookupFee(chargeCode);
        }

        return total;
    }

    public Double lookupFee(String chargeCode) {
        if (!feeCache.containsKey(chargeCode)) {
            try {
                Optional<Item> item = repo.findById(chargeCode);
                Double amount = item.map(Item::getAmount).orElse(0.0);
                feeCache.put(chargeCode, amount);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return feeCache.get(chargeCode);
    }
}
