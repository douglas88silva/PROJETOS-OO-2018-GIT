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

   private String path;

	public PlanilhaDAO() {
		// Caminho do arquivo
		this.setPath("C:\\Users\\jessi\\Desktop\\Douglas\\DESENVOLVIMENTO\\PROJETOS-OO-2018-GIT\\Trabalho OO - PokedexJava\\xlsx\\planilhas\\planilhaDaAula.xlsx");
	}

	public void processAll() {
		try {
			// Leitura
			FileInputStream fi = new FileInputStream(new File(getPath()));

			// Carregando workbook
			XSSFWorkbook wb = new XSSFWorkbook(fi);

			// Selecionando a primeira aba
			XSSFSheet s = wb.getSheetAt(0);

//			// Caso queira pegar valor por referencia
//			CellReference cellReference = new CellReference("B1");
//			Row row = s.getRow(cellReference.getRow());
//			Cell cell = row.getCell(cellReference.getCol());
//                        System.out.println("Valor Refe:" + cell.getNumericCellValue());
                        
                        Iterator<Row> linhas = s.iterator();
                        
                        while (linhas.hasNext()) {
                            Row linha = linhas.next();
                             Cell cellFor = linha.getCell(3);
                                                 
//                            if (linha.getRowNum() == 1)
//                            {
                                cellType(cellFor);
//                            }
                            
                        }
                        

                        
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

	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}
        
        public void cellType(Cell cell)
        {
                       switch (cell.getCellType()) {

                        case Cell.CELL_TYPE_STRING:
                            System.out.println("TIPO STRING: " + cell.getStringCellValue());
                            break;

                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.println("TIPO NUMERICO: " + cell.getNumericCellValue());
                            break;
                            
                        case Cell.CELL_TYPE_FORMULA:
                            System.out.println("TIPO FORMULA: " + cell.getCellFormula());
                    }
        }
}