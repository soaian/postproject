package org.example.postproject.repository;

import org.example.postproject.domain.Board;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BoardRepository extends CrudRepository<Board,Long>, PagingAndSortingRepository<Board,Long> {
}
