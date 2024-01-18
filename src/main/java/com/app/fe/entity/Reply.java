package com.app.fe.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_REPLY")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reply {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    @NotNull
    private Member member;

    @ManyToOne @NotNull
    private Community community;

    @NotNull
    private String replyContent;

    @CreationTimestamp
    private LocalDateTime replyRegisterDate;

    @UpdateTimestamp
    private LocalDateTime replyUpdateDate;


    @Builder
    public Reply(Member member, Community community, String replyContent) {
        this.member = member;
        this.community = community;
        this.replyContent = replyContent;
    }

}
