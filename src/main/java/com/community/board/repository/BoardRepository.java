package com.community.board.repository;

import com.community.board.domain.Board;
import com.community.board.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    public Optional<Board> findByUser(User user);
}
