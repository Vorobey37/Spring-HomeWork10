package ru.gb.SpringHomeWork3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.SpringHomeWork3.entity.IssueEntity;

public interface JpaIssueRepository extends JpaRepository<IssueEntity, Long> {
}
