package com.lms.repository;

import com.lms.dto.StudentCourseHisDto;
import com.lms.entity.CourseApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseApplicationRepository extends JpaRepository<CourseApplication, Long> {

    CourseApplication findByApplicationId(Long applicationId);

}
