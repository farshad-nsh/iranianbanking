package com.farshad.banking.iranian.model.domain;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Embeddable
public class RialTransaction {


    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @org.hibernate.annotations.UpdateTimestamp
    private Date date;

    private String description;
    private String type;
    private String status;

    @Nullable
    private BigDecimal amount;


    //private BigDecimal availableBalance;


}
