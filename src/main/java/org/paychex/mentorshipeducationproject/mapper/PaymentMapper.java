package org.paychex.mentorshipeducationproject.mapper;

import org.paychex.mentorshipeducationproject.Dto.PaymentDto;
import org.paychex.mentorshipeducationproject.entity.Payment;

public class PaymentMapper {
    public static PaymentDto mapToPaymentDto(Payment payment) {
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setPaymentId(payment.getPaymentId());
        paymentDto.setPaymentAmount(payment.getPaymentAmount());
        paymentDto.setIsFullPaid(payment.getIsFullPaid());
        paymentDto.setTotalBill(payment.getTotalBill());
        paymentDto.setAmountDue(payment.getAmountDue());
        paymentDto.setPaymentDate(payment.getPaymentDate());
        if(payment.getCourse() != null &&
            payment.getMentorship() == null){
                paymentDto.setCourseId(payment
                        .getCourse()
                        .getCourseId());
            }
        if(payment.getCourse() == null &&
            payment.getMentorship() != null){
                paymentDto.setMentorshipId(payment
                        .getMentorship()
                        .getMentorshipId());
            }
        return paymentDto;

    }
}
