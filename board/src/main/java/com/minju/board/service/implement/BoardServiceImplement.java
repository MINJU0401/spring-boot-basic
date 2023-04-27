package com.minju.board.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.minju.board.dto.request.board.PatchBoardRequestDto;
import com.minju.board.dto.request.board.PostBoardRequestDto;
import com.minju.board.dto.response.ResponseDto;
import com.minju.board.dto.response.board.GetBoardListResponseDto;
import com.minju.board.dto.response.board.GetBoardResponseDto;
import com.minju.board.entity.BoardEntity;
import com.minju.board.repository.BoardRepository;
import com.minju.board.repository.UserRepository;

@Service
public class BoardServiceImplement implements BoardService {

    private UserRepository userRepository;
    private BoardRepository boardRepository;

    @Autowired
    public BoardServiceImplement(
        UserRepository userRepository,
        BoardRepository boardRepository
    ) {
        this.userRepository = userRepository;
        this.boardRepository = boardRepository;
    }

    @Override
    public ResponseEntity<ResponseDto> postBoard(PostBoardRequestDto dto) {
        
        ResponseDto body = null; 

        String boardWriterEmail = dto.getBoardWriterEmail();

        try {
            //* 존재하지 않는 유저 오류 반환 //
            boolean existedUserEmail = userRepository.existsByEmail(boardWriterEmail);
            if (!existedUserEmail) {
                ResponseDto errorbody = new ResponseDto("NU", "Non-Existent User Email");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorbody);
            }

            BoardEntity boardEntity = new BoardEntity(dto);
            boardRepository.save(boardEntity);

            body = new ResponseDto("SU", "Success");

        } catch (Exception exception) {
            //* 데이터베이스 오류 반환 //
            exception.printStackTrace();
            ResponseDto errorBody = new ResponseDto("DE", "Database Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorBody);
        }
        //* 성공 반환 //
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @Override
    public ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoard'");
    }

    @Override
    public ResponseEntity<? super GetBoardListResponseDto> getBoardList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoardList'");
    }

    @Override
    public ResponseEntity<? super GetBoardListResponseDto> getBoardTop3() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoardTop3'");
    }

    @Override
    public ResponseEntity<ResponseDto> patchBoard(PatchBoardRequestDto dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'patchBoard'");
    }

    @Override
    public ResponseEntity<ResponseDto> deleteBoard(String userEmail, Integer boardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBoard'");
    }
    
}
