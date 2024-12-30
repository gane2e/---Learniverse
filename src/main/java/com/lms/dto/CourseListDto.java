package com.lms.dto;

import com.lms.constant.Course_status;
import com.lms.constant.Recruitment_status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class CourseListDto {

    //사용자 페이지 교육 전체리스트 + 카테고리 불러오는 dto
    private Long courseId; //교육과정 ID
    private String title; // 교육과정 제목
    private String description; // 교육 소개

    /* 모집상태 */
    private Recruitment_status recruitment_status; //모집상태
    private LocalDate recruitment_start_date; //모집시작일(선택)
    private LocalDate recruitment_end_date; //모집종료일(선택)

    /* 교육상태 */
    private Course_status course_status; //교육상태
    private LocalDate course_start_date; //교육시작일(선택)
    private LocalDate course_end_date; //교육종료일(선택)

    private String completionCriteria; //수료기준

    private LocalDateTime regTime;
    private LocalDateTime updateTime;
    private String createdBy;
    private String modifiedBy;

    /* 썸네일처리 */
    private String imgUrl; /* 썸네일 조회 경로 */
    private String oriImgName; /* 썸네일 원본 이름 */


    private Long categoryId; //해당 교육과정의 서브카테고리
    private String categoryName; //해당 교육과정의 서브카테고리

    private Long subCategoryId; //해당 교육과정의 서브카테고리
    private String subCategoryName; //해당 교육과정의 서브카테고리


    public CourseListDto(Long courseId, String title, String description,
                         Recruitment_status recruitment_status, LocalDate recruitment_start_date,
                         LocalDate recruitment_end_date, Course_status course_status,
                         LocalDate course_start_date, LocalDate course_end_date, String completionCriteria,
                         LocalDateTime regTime, LocalDateTime updateTime, String createdBy, String modifiedBy,
                         String imgUrl, String oriImgName, Long categoryId, String categoryName,
                         Long subCategoryId, String subCategoryName) {
        this.courseId = courseId;
        this.title = title;
        this.description = description;
        this.recruitment_status = recruitment_status;
        this.recruitment_start_date = recruitment_start_date;
        this.recruitment_end_date = recruitment_end_date;
        this.course_status = course_status;
        this.course_start_date = course_start_date;
        this.course_end_date = course_end_date;
        this.completionCriteria = completionCriteria;
        this.regTime = regTime;
        this.updateTime = updateTime;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.imgUrl = imgUrl;
        this.oriImgName = oriImgName;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.subCategoryId = subCategoryId;
        this.subCategoryName = subCategoryName;
    }
}