package com.lms.entity;

import com.lms.constant.Completion_status;
import com.lms.constant.Enrollment_status;
import com.lms.constant.Test_status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "student_course")
@Getter
@Setter
public class StudentCourse extends BaseEntity {
    // 수강생 관리 테이블
    // 신청내역 '신청완료' 인 회원은 해당 엔티티에서 수강내역 관리

    @Id
    @Column(name = "student_course_id")
    @GeneratedValue(strategy = GenerationType.AUTO) /*자동증가*/
    private Long studentCourseId;

    private LocalDateTime courseStarDateTime; //수강 시작일

    private LocalDateTime completionDateTime; //학습 수료일

    @Column(columnDefinition = "bigint default 0")
    private double ProgressRate; // 진도율

    //수강상태(수강신청, 학습중, 학습완료)
    @Enumerated(EnumType.STRING)
    private Enrollment_status enrollmentStatus;

    //시험응시상태(미응시, 합격, 불합격)
    @Enumerated(EnumType.STRING)
    private Test_status testStatus;

    //수료상태(수료, 미수료)
    @Enumerated(EnumType.STRING)
    private Completion_status completionStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "application_id")
    private CourseApplication courseApplication;

}