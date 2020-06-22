package com.springboot.challenge.domain.item;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@Rollback(false)
@SpringBootTest
public class ItemRepositoryTest {
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void Item_등록_확인() {
        //given
        Item item = Item.builder()
                .name("오프화이트신발")
                .price(1000000)
                .category(Category.SHOES)
                .stockQuantity(5)
                .thumbnailUrl("helloWorld")
                .build();
        itemRepository.save(item);

        //when
        List<Item> findItem = itemRepository.findAll();
        Item savedItem = findItem.get(0);
        System.out.println(savedItem.getSales());

        //then
        assertThat(item.equals(savedItem)).isTrue();
    }
}