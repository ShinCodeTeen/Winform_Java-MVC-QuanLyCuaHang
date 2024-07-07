/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DonHang;
import DTO.HoaDon;
import DTO.KhachHang;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Duoc Shin
 */
public class PrintExcelFile {

    public void XuatHoaDon(String mahd) {
        HoaDon hd = new DAO.DAO_HoaDon().getHD(mahd);
        KhachHang kh = new DAO.DAO_KhachHang().getKH(hd.makh);
        ArrayList<DonHang> listdh = new DAO.DAO_HoaDon().get_TTHD(mahd);

        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet("HD_ " + mahd);

            XSSFRow row = null;
            Cell cell = null;

            // Dòng 1: Thông tin hóa đơn
            row = spreadsheet.createRow(0);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("THÔNG TIN HÓA ĐƠN");
            spreadsheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
            cell.setCellStyle(createStyleForHeader(workbook));

            // Dòng 2: Tên khách hàng
            row = spreadsheet.createRow(1);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Tên Khách Hàng:");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(kh.tenkh);

            // Dòng 3: Tên nhân viên
          
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Tên Nhân Viên:");
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Duoc Shin"); 

            // Dòng 4: Bảng đơn hàng
            row = spreadsheet.createRow(3);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Tên Sản Phẩm");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Số Lượng");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Thành Tiền");

            // Dòng dữ liệu đơn hàng
            for (int i = 0; i < listdh.size(); i++) {
                DonHang dh = listdh.get(i);
                String tensp = new DAO.DAO_SanPham().get_Tensp(dh.masp);
                String sl = dh.sl + "";
                String thanhtien = dh.thanhtien + "";

                row = spreadsheet.createRow(i + 4);
                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i + 1);
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(tensp);
                cell = row.createCell(2, CellType.NUMERIC);
                cell.setCellValue(Double.parseDouble(sl));
                cell = row.createCell(3, CellType.NUMERIC);
                cell.setCellValue(Double.parseDouble(thanhtien));
            }
             for (int i = 0; i < 5; i++) {
                spreadsheet.autoSizeColumn(i);
            }
            // Lưu file Excel
            FileOutputStream out = new FileOutputStream(new File("D:/ThongtinHoaDon.xlsx"));
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private XSSFCellStyle createStyleForHeader(XSSFWorkbook workbook) {
        XSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        
        return style;
    }
}