package fishclub.ru.fishclubserver.service.fishermen;

import fishclub.ru.fishclubserver.data.fishermen.entity.FishermenJournalEntity;
import fishclub.ru.fishclubserver.data.fishermen.enums.FishermenReportHeaders;
import fishclub.ru.fishclubserver.entity.Fish;
import fishclub.ru.fishclubserver.entity.Fishermen;
import fishclub.ru.fishclubserver.repository.fishermen.FishermenJournalRepository;
import fishclub.ru.fishclubserver.repository.fishermen.FishermenRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class FishermenReportService {

    @Autowired
    private FishermenJournalRepository fishermenJournalRepository;

    @Autowired
    private FishermenRepository fishermenRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public Resource getFishermenReport() {
        Workbook report = null;
        try {
            report = new XSSFWorkbook();
            createFileStructure(report);
            Sheet dataSheet = report.getSheetAt(0);
            List<FishermenJournalEntity> fishermen = fishermenJournalRepository.getJournalList();
            for (FishermenJournalEntity fisherman : fishermen) {
                Row currentRow = dataSheet.createRow(dataSheet.getLastRowNum() + 1);
                Cell name = currentRow.createCell(0);
                name.setCellValue(fisherman.getName());
                Cell age = currentRow.createCell(1);
                age.setCellValue(fisherman.getAge());
                Cell experience = currentRow.createCell(2);
                experience.setCellValue(fisherman.getExperience());
                Fishermen fishermenById = fishermenRepository.getEntity(Long.parseLong(fisherman.getFishermenId()));
                StringBuilder resultFishes = new StringBuilder();
                for (Fish fish : fishermenById.getPreferencesFishes()) {
                    resultFishes.append(fish.getFishName()).append("\n");
                }
                if (!resultFishes.isEmpty()) {
                    resultFishes.deleteCharAt(resultFishes.length() - 1);
                }
                Cell preferencesFishes = currentRow.createCell(3);
                preferencesFishes.setCellValue(resultFishes.toString());
            }
            ByteArrayOutputStream fileOut = new ByteArrayOutputStream();
            report.write(fileOut);
            return new ByteArrayResource(fileOut.toByteArray());
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        } finally {
            IOUtils.closeQuietly(report);
        }
    }

    private void createFileStructure(Workbook report) {
        Sheet dataSheet = report.createSheet();

        XSSFFont headerFont = (XSSFFont) report.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 18);
        XSSFCellStyle headerStyle = (XSSFCellStyle) report.createCellStyle();
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setFont(headerFont);

        Row currentRow = dataSheet.createRow(dataSheet.getLastRowNum() + 1);
        for(FishermenReportHeaders header : FishermenReportHeaders.values()) {
            Cell headerCell = currentRow.createCell(header.getColumnIndex() - 1);
            headerCell.setCellStyle(headerStyle);
            headerCell.setCellValue(header.getColumnName());
        }
    }
}
