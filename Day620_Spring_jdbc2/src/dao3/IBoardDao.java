package dao3;

import java.util.List;

import model.Board;

public interface IBoardDao {
	public int insertBoard(Board board);
	public int updaetBoard(Board board);
	public int deleteBoard(int num);
	public Board selectOne(int num);
	public List<Board> selectAll();
}
