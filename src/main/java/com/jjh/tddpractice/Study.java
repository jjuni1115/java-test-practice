package com.jjh.tddpractice;



public class Study {

    private StudyStatus status=StudyStatus.DRAFT;

    private int limit = -1;

    public Study(int limit){
        if(limit<0){
            throw new IllegalArgumentException("참석인원은 0명 이상이어야 합니다");
        }
        this.limit=limit;
    }


    public StudyStatus getStatus(){
        return this.status;
    }

    public int getLimit(){
        return this.limit;
    }


}
