package com.repository;

import com.entity.ChungNhan;
import com.entity.ChuyenBay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.util.List;

public interface ChungNhanRepository extends JpaRepository<ChungNhan, String> {
    @Override
    public <S extends ChungNhan> List<S> saveAll(Iterable<S> entities);

}
