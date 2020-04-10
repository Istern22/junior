package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<String> sources, File target, String directory) throws FileNotFoundException {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (var item : sources) {
                var str = item.replace(directory + "\\", "");
                zip.putNextEntry(new ZipEntry(str));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(item))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getFiles(String directory, String exclusion) throws IOException {
        var filter = new ZipFiles(exclusion);
        Files.walkFileTree(Paths.get(directory), filter);
        return filter.getFiles();
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        var zip = new ArgZip(args);
        if (!zip.isValid()) {
            for (var error : zip.getErrors()) {
                System.out.println(error);
            }
            return;
        }
        var archive = new Zip();
        var files = archive.getFiles(zip.directory(), zip.exclude());
        archive.packFiles(files, new File(zip.output()), zip.directory());
    }
}
