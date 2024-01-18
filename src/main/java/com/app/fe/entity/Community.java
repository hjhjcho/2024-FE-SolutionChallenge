package com.app.fe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_COMMNUITY")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Community {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    @NotNull
    private Member member;

    @ManyToOne
    @NotNull
    private Reply reply;

    @NotNull
    private String communityTitle;

    @NotNull
    private String communityContent;

    @NotNull
    private String communityType;

    @CreationTimestamp
    private LocalDateTime communityRegisterDates;

    @UpdateTimestamp
    private LocalDateTime communityUpdateDates;


    @Builder
    public Community(Member member, String communityType, String communityTitle, String communityContent) {
        this.member = member;
        this.communityType=communityType;
        this.communityTitle = communityTitle;
        this.communityContent = communityContent;
    }


}
