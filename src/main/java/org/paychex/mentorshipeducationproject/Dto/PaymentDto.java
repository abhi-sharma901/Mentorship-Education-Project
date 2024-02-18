package org.paychex.mentorshipeducationproject.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    private Long paymentId;
    private Double paymentAmount;
    private Boolean isFullPaid;
    private Double totalBill;
    private Double amountDue;
    private LocalDate paymentDate;
    private Long courseId;
    private Long mentorshipId;
}
