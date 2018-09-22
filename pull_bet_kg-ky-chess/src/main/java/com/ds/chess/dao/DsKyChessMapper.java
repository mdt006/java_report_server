package com.ds.chess.dao;

import com.ds.chess.entity.DsKyChess;

public interface DsKyChessMapper {
	
    int insert(DsKyChess record);

    DsKyChess selectByPrimaryKey(Long id);

    int updateByPrimaryKey(DsKyChess record);
    
    DsKyChess selectByGameId(String gameId);
    
    
}