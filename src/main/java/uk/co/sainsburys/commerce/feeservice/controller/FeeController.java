package uk.co.sainsburys.commerce.feeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uk.co.sainsburys.commerce.feeservice.service.FeeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fees")
public class FeeController {

    @Autowired
    private FeeService feeService;

    @PostMapping("/calculate")
    public String calculate(@RequestBody List<String> chargeCodes) {

        Double total = feeService.calculateSubTotal(chargeCodes);

        if (total > 20) {
            total = total * 0.5;
        } else if (total > 10) {
            total = total * 0.2;
        } else if (total > 5) {
            total = total * 0.1;
        }

        return "Total fees: " + total + ", codes: " + chargeCodes;

    }
}
