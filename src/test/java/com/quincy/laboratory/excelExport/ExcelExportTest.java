package com.quincy.laboratory.excelExport;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.quincy.laboratory.common.Constants;
import com.quincy.laboratory.entity.ExportEntity;
import com.quincy.laboratory.entity.LaboratoryUserDto;
import com.quincy.laboratory.service.LaboratoryUserService;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
// 仅仅 导入 静态变量
import static com.quincy.laboratory.common.Constants.*;

@SpringBootTest
public class ExcelExportTest {
    private static final int MAX_LENGTH = 1000000;

    @Resource
    private LaboratoryUserService userService;


    @Test
    public static void main(String[] argv) {
        //定义文件输出位置
        FileOutputStream outputStream;
        try {
            List<ExportEntity> excelList = new ArrayList<>();
            for (int i = 0; i < MAX_LENGTH; i++) {
                ExportEntity exportEntity = new ExportEntity();
                exportEntity.setUsername("nihao-" + i);
                exportEntity.setAge(20 + i);
                exportEntity.setTime(new Date(System.currentTimeMillis() + i));
                excelList.add(exportEntity);
            }
            outputStream = new FileOutputStream(RELATIVE_PATH_DOC + "easy-excel-export-user1.xlsx");
            EasyExcel.write(outputStream, ExportEntity.class).sheet("用户信息").doWrite(excelList);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void countAllUsersTest() {
        System.out.println(userService.countAllUsers());
    }

    @Test
    public void findAllUsersPageTest() {
        //获取开始时间
        long startTime, endTime;
        List<LaboratoryUserDto> userDtos;
        for (int i = 0; i < 1; i++) {

            startTime = System.nanoTime();
            userDtos = userService.findAllUsersPageFetchSize(0, 100000);
            endTime = System.nanoTime();

            System.out.printf(String.format("1-程序运行时间：%d - %f ms  %d%n", i, (double) (endTime - startTime) / 1000000, userDtos.size()));

            startTime = System.nanoTime();
            userDtos = userService.findAllUsersPage(100000, 100000);
            endTime = System.nanoTime();

            System.out.printf(String.format("1-程序运行时间：%d - %f ms  %d%n", i, (double) (endTime - startTime) / 1000000, userDtos.size()));
        }

    }

    @Test
    public void findAllUsersPageTest1() {
        //获取开始时间
        long startTime = System.nanoTime();

        List<LaboratoryUserDto> userDtos = userService.findAllUsersPage(0, 50000);

        //获取结束时间s
        long endTime = System.nanoTime();

        System.out.printf(String.format("0-程序运行时间：%f ms%n", (double) (endTime - startTime) / 1000000));
        userDtos.clear();
    }

    @Test
    public void findAllUsersPageFetchSizeTest() {
        //获取开始时间
        long startTime = System.nanoTime();

        List<LaboratoryUserDto> userDtos = userService.findAllUsersPageFetchSize(49999, 50000);

        //获取结束时间s
        long endTime = System.nanoTime();

        System.out.printf(String.format("FetchSize-程序运行时间：%f ms%n", (double) (endTime - startTime) / 1000000));
        userDtos.clear();
    }


    // 软件分页导入
    public void easyExcelExecute01(int... pageSizePara) {
        //定义文件输出位置
        FileOutputStream outputStream;
        try {
            int pageSize = pageSizePara.length == 0 ? DEFAULT_PAGE_SIZE : pageSizePara[0];

            outputStream = new FileOutputStream(RELATIVE_PATH_DOC + String.format("easy-excel-export-user-00%d.xlsx", pageSize));

            ExcelWriter excelWriter = EasyExcel.write(outputStream, LaboratoryUserDto.class).build();
            WriteSheet writeSheet = EasyExcel.writerSheet("用户信息").build();

            int total = userService.countAllUsers();

            final long startTime = System.currentTimeMillis();

            for (int curPage = 0; curPage <= total / pageSize; curPage++) {
                List<LaboratoryUserDto> userDtoList = userService.findAllUsersPage(curPage * pageSize, pageSize);

                if (CollectionUtils.isNotEmpty(userDtoList)) {
                    // 第一次会生成表头，后续追加写入文件中
                    excelWriter.write(userDtoList, writeSheet);
                }
                if (curPage == total / pageSize - 1) {
                    System.out.println("====== Export data to excel, it  has spent " + (System.currentTimeMillis() - startTime) + "  ms, pageSize:" + pageSize);
                }
            }
            excelWriter.finish();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void executeTest01() {
        List<Integer> pageList = Arrays.asList(1000000, 100000, 10000, 1000);
        for (int pageSize : pageList) {
            easyExcelExecute01(pageSize);
        }
    }

    /**
     * 多线程，生成多个excel文件
     */
    @Test
    public void exportExcelsByThreadPool() {
        int pageSize = 100000;
        int total = userService.countAllUsers();
        int totalPage = total / pageSize + 1;
        // 多线程
        ExecutorService pool = Executors.newFixedThreadPool(50);

        final long startTime = System.currentTimeMillis();
        for (int curPage = 0; curPage <= totalPage; curPage++) {

            int curPageSize = curPage == totalPage ? total % pageSize : pageSize;

            // 第一次会生成表头，后续追加写入文件中
            int finalCurPage = curPage;

            List<LaboratoryUserDto> userDtoList = userService.findAllUsersPage(curPage * pageSize, curPageSize);

            if (CollectionUtils.isNotEmpty(userDtoList)) {
                Runnable run = () -> {
                    FileOutputStream outputStream;
                    try {
                        outputStream = new FileOutputStream(RELATIVE_PATH_DOC + "pool/" + String.format("easy-excel-pool-export-%d-.xlsx", finalCurPage));

                        ExcelWriter excelWriter = EasyExcel.write(outputStream, LaboratoryUserDto.class).build();
                        WriteSheet writeSheet = EasyExcel.writerSheet("用户信息").build();
                        // 第一次会生成表头，后续追加写入文件中
                        excelWriter.write(userDtoList, writeSheet);

                        excelWriter.finish();
                        outputStream.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                };
                pool.execute(run);
            }
        }
        pool.shutdown();
        while (true) {
            if (pool.isTerminated()) {
                System.out.println("====== Export data to excel, it  has spent " + (System.currentTimeMillis() - startTime) + "  ms, pageSize:" + pageSize);
                break;
            }
        }
    }

    /**
     * 多线程
     */
    @Test
    public void exportSheetsByThreadPool() {
        try {

            int pageSize = 100000;
            int total = userService.countAllUsers();
            int totalPage = total / pageSize + 1;
            // 多线程
            ExecutorService pool = Executors.newFixedThreadPool(50);

            FileOutputStream outputStream = new FileOutputStream(RELATIVE_PATH_DOC + "pool/" + "easy-excel-pool-sheets-.xlsx");
            ExcelWriter excelWriter = EasyExcel.write(outputStream, LaboratoryUserDto.class).build();

            final long startTime = System.currentTimeMillis();
            for (int curPage = 0; curPage <= totalPage; curPage++) {
                int curPageSize = curPage == totalPage ? total % pageSize : pageSize;

                List<LaboratoryUserDto> userDtoList = userService.findAllUsersPage(curPage * pageSize, curPageSize);

                if (CollectionUtils.isNotEmpty(userDtoList)) {
                    int finalCurPage = curPage;
                    Runnable run = () -> {
                        // 第一次会生成表头，后续追加写入文件中
                        excelWriter.write(userDtoList, EasyExcel.writerSheet("sheet-" + finalCurPage).build());
                    };
                    pool.execute(run);
                }
            }
            pool.shutdown();
            while (true) {
                if (pool.isTerminated()) {
                    System.out.println("====== Export data to excel, it  has spent " + (System.currentTimeMillis() - startTime) + "  ms, pageSize:" + pageSize);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
