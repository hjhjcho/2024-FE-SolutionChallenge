package com.app.fe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "TBL_INCOME")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Income {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    @NotNull
    private Work work;

    @ManyToOne
    private Member member;

    @NotNull
    private String office;

    @NotNull
    private String incomeDay;

    @NotNull
    private int salary;

    @NotNull
    private int workHour;

    @NotNull
    private boolean tax;

    @Builder
    public Income(Work work, Member member, String office, String incomeDay, int salary, int workHour, boolean tax){
        this.work=work;
        this.member=member;
        this.office=office;
        this.incomeDay=incomeDay;
        this.salary=salary;
        this.workHour=workHour;
        this.tax=tax;
    }

}
