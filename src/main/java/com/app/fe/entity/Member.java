package com.app.fe.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_MEMBER")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull
    @Column(unique = true)
    private String googleEmail;

    @Column(name = "USER_STATUS", columnDefinition = "CHAR(1) DEFAULT '1' CHECK (USER_STATUS IN ('0', '1'))")
    private boolean userStatus;

    @CreationTimestamp
    private LocalDateTime userRegisterDate;

    @UpdateTimestamp
    private LocalDateTime userUpdateDate;

    private String profile_image;

    @OneToOne
    private Nation nation;

    @Builder
    public Member(String googleEmail, String profile_image, Nation nation){
        this.googleEmail=googleEmail;
        this.profile_image=profile_image;
        this.nation=nation;
    }
}
