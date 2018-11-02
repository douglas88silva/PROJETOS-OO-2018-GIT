/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokedexjavaoo;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**

 *
 * @author douglas.silva
 */
public class PlanilhaDAO {

   private String path= "C:\\Users\\jessi\\Desktop\\Douglas\\DESENVOLVIMENTO\\PROJETOS-OO-2018-GIT\\Trabalho OO - PokedexJava\\xlsx\\planilhas\\planilhaDaAula.xlsx";
    private FileInputStream fisPlanilha = null;
     private XSSFSheet sheet;
     private XSSFSheet sheet2;
     private XSSFSheet sheet3;

	public PlanilhaDAO() {
	
        		try {
			// Leitura
			fisPlanilha = new FileInputStream(this.path);

			// Carregando workbook
			XSSFWorkbook wb = new XSSFWorkbook(fisPlanilha);

			// Selecionando a primeira aba
			this.sheet = wb.getSheetAt(0);

//			// Caso queira pegar valor por referencia
//			CellReference cellReference = new CellReference("B1");
//			Row row = sheet1.getRow(cellReference.getRow());
//			Cell cell = row.getCell(cellReference.getCol());
//                        System.out.println("Valor Refe:" + cell.getNumericCellValue());
                        

                        

                        
			// Fazendo um loop em todas as linhas
//			for (Row rowFor : s) {
//                            
//				// FAzendo loop em todas as colunas
//				for (Cell cellFor : rowFor) {
//					try {
//						// Verifica o tipo de dado
//						if (cellFor.getCellType() == Cell.CELL_TYPE_NUMERIC) {
//							// Na coluna 6 tenho um formato de data
//							if (cellFor.getColumnIndex() == 6) {
//								// Se estiver no formato de data
//								if (DateUtil.isCellDateFormatted(cellFor)) {
//									// Formatar para o padrao brasileiro
//									Date d = cellFor.getDateCellValue();
//									DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//									System.out.println(df.format(d));
//								}
//							} else {
//								// Mostrar numerico
//								System.out.println(cellFor.getNumericCellValue());
//							}
//						} else {
//							// Mostrar String
//							System.out.println(cellFor.getStringCellValue());
//						}
//					} catch (Exception e) {
//						// Mostrar Erro
//						System.out.println(e.getMessage());
//					}
//				}
//				// Mostrar pulo de linha
//				System.out.println("------------------------");
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}
        
        
        
        }

        
        public int getIntColuna (int coluna,int dust)
        {
            Iterator<Row> linhas = this.sheet.iterator();
                        
                while (linhas.hasNext())
                {
                       Row linha = linhas.next();
                       Cell cell = linha.getCell(coluna);
                    if(dust == (int) cell.getNumericCellValue()){                             
                                 return (int) cell.getNumericCellValue();
                    }
                }
                
              return 0;
        }
        
        public String getStringColuna (int coluna, String nome)
        {
            Iterator<Row> linhas = this.sheet.iterator();
                        
                while (linhas.hasNext())
                {
                       Row linha = linhas.next();
                       Cell cell = linha.getCell(coluna);
                         
                       if(nome.equalsIgnoreCase(cell.getStringCellValue())){
                            switch (cell.getCellType()) {

                            case Cell.CELL_TYPE_STRING:
                                return cell.getStringCellValue();
                            
                            default:
                                System.out.println("Erro de tipo de Celula");
                            break;
                            } 
                         }                        
         
                }
                return "-1";
        }
        


        
}