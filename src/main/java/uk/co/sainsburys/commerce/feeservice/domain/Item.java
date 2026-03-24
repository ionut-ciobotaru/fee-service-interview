package uk.co.sainsburys.commerce.feeservice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Item {
    @Id
    private String code;

    private Double amount;

    private String description;
}
