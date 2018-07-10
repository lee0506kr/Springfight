package service;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface BoardService {
	
	//전체 목록 보기 위한 메서드 
	public List<Map<String, Object>> boardList();
	//페이징 처리 항목 포함해서 게시판 목록 가져오기 
	//게시글 페이지,검색어, 검색타입 등등
//	getBoardList(Map<Strinng,Object> param,int page): Map<String,Object>
	public Map<String, Object> getBoardList(Map<String, Object> param,int page);	
//	readBoard(int num) : Map<String,Object> : 게시글 하나 정보 가져오기,readCount 증가
	public Map<String, Object> readBoard(int num);
//	getBoard(int num) : Map<String,Object> : 게시글 하나 정보 조회
	public Map<String, Object> getBoard(int num);
//	게시글 등록
	public boolean writeBoard(Map<String,Object> board,MultipartFile file);
//	게시글 수정
	public boolean modifyBoard(Map<String,Object> board);
//	게시글 삭제
	public boolean removeBoard(int num);
//	게시글 비밀번호 확인(수정,삭제시)
	public boolean checkPass(Map<String,Object> param);
//	첨부파일 다운로드
	public File getAttachFile(int num);
//  첨부파일 저장 및, 파일 이름 만들어 내기
	public String writeFile(MultipartFile file);
	
	
	
	
	
	
	
}
