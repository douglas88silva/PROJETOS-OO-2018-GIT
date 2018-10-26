/*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pokedexjavaoo;
//
//import java.io.File;
//import java.io.FileInputStream;
//import javax.swing.JFileChooser;
////import jxl.*;
//
///**
// *
// * @author douglas.silva
// */
//public class PlanilhaDAO {
//    
//    //FileInputStream 
//    private Workbook wb;
//    private Sheet st;
//  
//    public void iniciar()
//    {
//       try
//       {
////          JFileChooser fopen = new JFileChooser( );
//////          fopen.showOpenDialog(null);
//           File file = new File("C:\\Users\\douglas.silva\\Documents\\PROJETOS-OO-2018-GIT\\Trabalho OO - PokedexJava\\PokedexJavaOO\\Dados\\teste.xlsx");
//                     
//        wb= Workbook.getWorkbook(file);
//        
//        // se não usar o JFileChooser poderia abri a planilha
//        //passando o nome do arquivo diretamente ex:
//        // wb= Workbook.getWorkbook("Teste.xls");
//         
//        
//        }catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//       
//    }
//    
//    public void setSheets(int x){
//
//        st = wb.getSheet(x);
//
//    }
//    
//    public Object [ ][ ] lerArquivo( )
//    {
//        Cell c;
//
//        int numlinha =st.getRows( ) ;
//        int numcol = st.getColumns( ) ;
//
//            Object [ ][ ]resultado = new Object[numlinha][numcol];
//               for(int linha = 0 ; linha < numlinha ; linha++){
//                   for(int coluna = 0 ; coluna < numcol ; coluna ++){
//
//                       c=st.getCell(coluna,linha);
//
//                       if (c.getType() == CellType.NUMBER)
//                               {
//                                 NumberCell nc = (NumberCell) c;
//                                resultado[linha][coluna]=(Double)nc.getValue();
//                               }
//                       if (c.getType() == CellType.EMPTY)
//                               {
//
//                               }
//                       if (c.getType() == CellType.LABEL)
//                               {
//                                 LabelCell lc = (LabelCell) c;
//                                  resultado[linha][coluna] = lc.getString( );
//                              }
//                   }
//
//               }
//
//        return resultado;
//    }
//    public void finalizar( )
//    {
//        wb.close( );
//    }
//    
//    
//}
