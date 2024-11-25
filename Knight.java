package com.chess.engine.pieces;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;
import java.util.ArrayList;
import java.util.List;


public class Knight extends Piece { //(constructor) الخاص بالفارس.

    
    private final static int [] CANDIDATE_MOVE_COORDINATES = { -17 ,-15,-10,-6,6,10,15,17}; //مصفوفة تحتوي على كل التحركات الممكنة للفارس
    
    
    
    Knight(final int piecePosition, final Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public List<Move> calculatelegalMoves(Board board) { //حساب الحركات المسموحة
        
        int candidateDestinationCoordinate;
       final List<Move> legalMoves = new ArrayList<>(); //متغير لتحديد المواقع
        for(final int currectCandidate : CANDIDATE_MOVE_COORDINATES ){  // التكرار عبر التحركات الممكنة
            
            candidateDestinationCoordinate = this.piecePosition + currectCandidate ;
            
            if(true/*isValidTileCoordinate */){ //هذا شرط للتحقق مما إذا كان الموقع الجديد صالح .
            
               final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate); //إذا كانت الخانة غير مشغولة (!candidateDestinationTile.isTileOccupied())، يتم اعتبار الحركة مسموحه
            
               if (!candidateDestinationTile.isTileOccupied()){
                   legalMoves.add(new Move ());
               
               
                 } else{
                     final Alliance pieceAtDestination = candidateDestinationTile.getPiece();
                   final Alliance PieceAlliance = pieceAtDestination.getPieceAlliance();
                    if (this.pieceAlliance != pieceAllegiance){
                    legalMoves.add(new Move());
                    
                    /*
                   (Alliance) إذا كانت الخانة مشغولة،
                    يتم التحقق من التحالف  للقطعة الموجودة.
                   إذا كانت قطعة العدو (التحالف مختلف)، 
                   تعتبر الحركة قانونية لأنها ستكون عملية "أخذ" للقطعة
                    */
                    
                    
                    }
                      }
               
            }
            
        } 
     return Immutablelist.copyOf(legalMoves);
    }
    
}
