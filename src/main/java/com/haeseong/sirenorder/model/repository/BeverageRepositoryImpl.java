package com.haeseong.sirenorder.model.repository;

import com.haeseong.sirenorder.model.entity.Beverage;

import java.util.Arrays;
import java.util.List;

public class BeverageRepositoryImpl extends AbstractInmemoryRepository<Beverage, Integer> implements BeverageRepository {
    public BeverageRepositoryImpl() {
        // 기본 데이터 추가
        final List<Beverage> baseBeverages = Arrays.asList(
                Beverage.builder()
                        .id(1)
                        .categoryId(1)
                        .name("에스프레소")
                        .price(1000)
                        .imageUrl("/images/7cd5c5a9-17e7-46a2-b997-6a17211d7f80.png")
                        .build(),
                Beverage.builder()
                        .id(2)
                        .categoryId(1)
                        .name("아메리카노")
                        .price(1500)
                        .imageUrl("/images/dc92e2be-af30-4950-9365-7a1de07c8442.png")
                        .build(),
                Beverage.builder()
                        .id(3)
                        .categoryId(1)
                        .name("카페라떼")
                        .price(2000)
                        .imageUrl("/images/d5cf3311-c5f0-4a12-b8cc-f6ce92bebd69.png")
                        .build(),
                Beverage.builder()
                        .id(4)
                        .categoryId(1)
                        .name("카푸치노")
                        .price(2500)
                        .imageUrl("/images/318f59a6-64de-4bbb-bc46-1c51f3a85009.png")
                        .build(),
                Beverage.builder()
                        .id(5)
                        .categoryId(1)
                        .name("돌체라떼")
                        .price(3000)
                        .imageUrl("/images/66c987a6-0cdf-47b4-86e4-49c6dfabdd8b.png")
                        .build(),
                Beverage.builder()
                        .id(6)
                        .categoryId(1)
                        .name("카라멜마끼아또")
                        .price(3500)
                        .imageUrl("/images/d968db66-a7e0-4e3e-9f61-55e4179bbfbe.png")
                        .build(),
                Beverage.builder()
                        .id(7)
                        .categoryId(2)
                        .name("얼그레이")
                        .price(4000)
                        .imageUrl("/images/a4cfaa5d-6c31-4c41-acec-0fb1b6a0e46e.png")
                        .build(),
                Beverage.builder()
                        .id(8)
                        .categoryId(2)
                        .name("레몬민트")
                        .price(4500)
                        .imageUrl("/images/228fd07b-9b17-42f7-9e9c-74b8dada06fe.png")
                        .build(),
                Beverage.builder()
                        .id(9)
                        .categoryId(2)
                        .name("그린티라떼")
                        .price(5000)
                        .imageUrl("/images/085089dc-0d40-45de-b7f4-f9702182b880.png")
                        .build(),
                Beverage.builder()
                        .id(10)
                        .categoryId(2)
                        .name("차이티라떼")
                        .price(5500)
                        .imageUrl("/images/f81af166-a1f1-4192-9d70-454712cb08ac.png")
                        .build()
        );
        baseBeverages.forEach(beverage -> map.put(beverage.getId(), beverage));
    }
}
