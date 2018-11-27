package com.huayun.menu.dao;

import com.huayun.article.domain.Article;
import com.huayun.menu.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuDao extends JpaRepository<Menu,String> {
    List<Menu> findAllByOrderBySeqAsc();
}
