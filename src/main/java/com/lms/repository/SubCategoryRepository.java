package com.lms.repository;

import com.lms.entity.Category;
import com.lms.entity.SubCategory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    /*
//    /* JPQL문법 */
//    @Query("select o from Order o " +
//            "where o.member.email = :email " +
//            "order by o.orderDate desc")
//    List<Order> findOrders(@Param("email") String email, Pageable pageable);
//    /* 현재 로그인한 사용자의 주문 데이터를 페이징 조건에 맞춰서 조회 */*/

    @Query("SELECT s " +
            "FROM SubCategory s " +
            "WHERE s.categories.categoryId = :categoryId")
    List<SubCategory> findSubCategoriesByCategoryId(@Param("categoryId") Long categoryId);
}