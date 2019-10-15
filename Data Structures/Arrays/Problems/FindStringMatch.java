//package com.shubh.array;
//
//public class FindStringMatch {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		FindStringMatch  match = new FindStringMatch();
//		char board [] [] =
//			{
//					{'A','B','C','E'},
//					{'S','F','C','S'},
//					{'A','D','E','E'}
//			};
//		match.exist(board, "BF");
//	}
//	
//public boolean exist(char[][] board, String word) {
//        
//        for(int i=0;i<board.length;i++)
//        {
//            for(int j=0;j<board[0].length;j++)
//            {
//                if(board[i][j]==word.charAt(0))
//                {
//                    if(findAdjacent(board,i,j,word,0,word.length()))
//                    {return true;}
//                }
//            }
//        }
//        return false;
//    }
//    
//       public boolean findAdjacent(char[][] board,int i, int j, String word, int c, int l )
//        {
//           
//            if(i>=0 || i<board.length || j>=0 || j<board[0].length)
//            {if(c<word.length()&&board[i][j]==word.charAt(c))
//            {
//                findAdjacent(board,i+1,j,word,c+1,l);
//                findAdjacent(board,i-1,j,word,c+1,l);
//                findAdjacent(board,i,j+1,word,c+1,l);
//                findAdjacent(board,i,j-1,word,c+1,l);
//                
//            }
//             else if(c>=word.length())
//                 return true;
//             else if(board[i][j]!=word.charAt(c))
//                 return false;
//            }
//            
//           boolean found = true;
//            
//        }
//
//}
