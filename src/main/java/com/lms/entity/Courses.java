package com.lms.entity;

import com.lms.constant.Course_status;
import com.lms.constant.Recruitment_status;
import com.lms.constant.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
public class Courses extends BaseEntity {

    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.AUTO) /*자동증가*/
    private Long courseId;

    @Column(nullable = false, length = 100)
    private String title; /* 교육과정 명 */

    @Column(nullable = false, length = 500)
    private String description; /* 교육소개 */

    /* 모집상태 */
    @Enumerated(EnumType.STRING)
    private Recruitment_status recruitment_status; //모집상태
    private LocalDate recruitment_start_date; //모집시작일(선택)
    private LocalDate recruitment_end_date; //모집종료일(선택)

    /* 교육상태 */
    @Enumerated(EnumType.STRING) //
    private Course_status course_status; //교육상태
    private LocalDate course_start_date; //교육시작일(선택)
    private LocalDate course_end_date; //교육종료일(선택)
    
    /* 해시태그 보류 */

    @Column(nullable = false, length = 500)
    private String completionCriteria; /* 수료기준 */

    private String imgName; /* 영상 파일명 */

    private String oriImgName; /* 썸네일 원본 이름 */

    private String imgUrl; /* 썸네일 조회 경로 */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_category_id")
    private SubCategory subCategory;

    /* 교육과정에 해당하는 영상목록  */
    @OneToMany(mappedBy = "courses", cascade = CascadeType.ALL)
    private List<CourseVideo> courseVideoList = new ArrayList<CourseVideo>();

    public void addCourseVideo(CourseVideo courseVideo) {
        this.courseVideoList.add(courseVideo);
        courseVideo.setCourses(this);
    }

    public void removeCourseVideo(CourseVideo courseVideo) {
        this.courseVideoList.remove(courseVideo);
        courseVideo.setCourses(null);
    }


    /* 원본명, 업데이트 이미지명, 이미지 경로를 파라미터로 입력받아 이미지 정보를 업데이트하는 메서드 */
    public void updateImg(String oriImgName, String imgName, String imgUrl){
        this.oriImgName = oriImgName;
        this.imgName = imgName;
        this.imgUrl = imgUrl;
    }


}
