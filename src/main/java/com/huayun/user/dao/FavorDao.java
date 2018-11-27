package com.huayun.user.dao;

import com.huayun.user.domain.Article_;
import com.huayun.user.domain.Favor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FavorDao  extends JpaRepository<Favor,String> {

    @Transactional
    void deleteFavorByUserIdAndArticleId(String userId,String articleId);

    //查询该用户是否收藏该文章；
    Favor queryFirstByUserIdAndArticleId(String userId,String articleId);

    @Query("select new com.huayun.user.domain.Article_(art.id,art.title,art.img,favor.modifyDatetime) from Article art,Favor favor where art.id= favor.articleId and favor.userId=:userId  order by favor.modifyDatetime desc")
    List<Article_> queryFavorList(@Param("userId") String userId);
}
