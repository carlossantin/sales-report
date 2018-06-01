package com.techchallenge.watcher;

import java.nio.file.WatchService;
import java.nio.file.WatchKey;
import java.nio.file.FileSystems;
import java.nio.file.FileSystem;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.PathMatcher;

import java.io.IOException;

import java.util.List;

import com.techchallenge.reader.FileInputReader;
import com.techchallenge.reader.FileData;
import com.techchallenge.writer.FileOutputWriter;

public class SalesWatcherService {  

  public void watch(final String directoryToWatch, final String fileDelimiter, final String outputDirectory, final String... extensionsToWatch) throws InterruptedException, IOException {
    final FileSystem fileSystem = FileSystems.getDefault();
    final WatchService watchService = fileSystem.newWatchService();

    final Path path = Paths.get(directoryToWatch);
    final String delimitedExtensionsToWatch = String.join(",", extensionsToWatch);
    final PathMatcher pathMatcher = fileSystem.getPathMatcher(String.format("glob:**.{%s}", delimitedExtensionsToWatch));
    
    path.register(watchService, 
                StandardWatchEventKinds.ENTRY_CREATE);

    WatchKey key;
    while ((key = watchService.take()) != null) {
      for (WatchEvent<?> event: key.pollEvents()) {
        final Path filePath = (Path)event.context();

        //Check if the file has the extension being watched
        if (pathMatcher.matches(filePath)) {
          final Path fullPath = path.resolve(filePath);

          try {
            Thread.sleep(500); // Without this line a concurrent access to file occurs
          } catch(InterruptedException e) {
            e.printStackTrace();
          }

          final FileData fileData = FileInputReader.readFileData(fullPath.toString(), fileDelimiter);
          
          String outputFilename = filePath.toString();
          if (outputFilename.indexOf(".") > 0) {
            outputFilename = outputFilename.substring(0, outputFilename.lastIndexOf("."));
          }

          FileOutputWriter.writeSummarizedData(fileData, outputDirectory, outputFilename);

        }
      }
      key.reset();
    }
  }

}
