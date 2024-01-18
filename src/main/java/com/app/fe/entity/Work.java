package com.app.fe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_WORK")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Work {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;


    @NotNull
    private String workDay;

}
