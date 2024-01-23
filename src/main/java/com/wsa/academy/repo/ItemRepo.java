package com.wsa.academy.repo;

import com.wsa.academy.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item, Integer> {

    List<Item> findAllByItemNameEqualsAndActiveEquals(String itemName, boolean b);


    List<Item> findAllItemsByActiveEquals(boolean activeState);


    Page<Item> findAllItemsByActiveEquals(boolean activeState, PageRequest of);
}
