package com.community.board;

import com.community.board.domain.Board;
import com.community.board.domain.User;
import com.community.board.domain.enums.BoardType;
import com.community.board.repository.BoardRepository;
import com.community.board.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class BoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardApplication.class, args);
	}


	/**
	 * App이 실행되고 실행되는 method
	 * DB에 정보를 넣는다.
	 * @param userRepository
	 * @param boardRepository
	 * @return
	 */
	@Bean
	public CommandLineRunner commandLineRunner(UserRepository userRepository, BoardRepository boardRepository) {
		return (args) -> {
			User chris = userRepository.save(User.builder()
					.name("Chris")
					.password("test1234!@")
					.email("chris@naver.com")
					.createdDate(LocalDateTime.now())
					.build());

			// Paging을 위해 200개의 데이터를 넣는다.
			IntStream.rangeClosed(1, 200).forEach(index -> {
				boardRepository.save(Board.builder()
						.title("게시글" + index)
						.subTitle("순서" + index)
						.content("테스트" + index)
						.boardType(BoardType.free)
						.createdDate(LocalDateTime.now())
						.updatedDate(LocalDateTime.now())
						.user(chris)
						.build());
			});

		};
	}
}
