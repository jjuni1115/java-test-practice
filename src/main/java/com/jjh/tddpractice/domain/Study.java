package com.jjh.tddpractice.domain;


import com.jjh.tddpractice.StudyStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Study {

    @Id
    private Long id;

    private StudyStatus status=StudyStatus.DRAFT;

    @OneToOne
    private Member member;

    private int limit = -1;

    private Boolean openYn=false;

    public void open(){

        this.openYn=true;

    }


}
