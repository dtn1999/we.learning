package com.we.elearning.workspacemanager.utils;

import com.we.elearning.workspacemanager.exceptions.GitException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.api.Git;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

@UtilityClass
@Slf4j
public class GitUtils {
    private AtomicInteger counter = new AtomicInteger(0);
    public void cloneRepository(String url, String path) {
        log.info("Cloning repository from {} to {}", url, path);
        try {
            Git call = Git.cloneRepository()
                    .setURI(url)
                    .setDirectory(new File(path))
                    .call();
            log.info("Repository cloned successfully. {}", call);
        } catch (Exception e) {
            log.error("Error while cloning repository from {} to {}", url, path);
            if(e.getMessage().contains("already exists and is not an empty directory")){
                FileUtils.deleteQuietly(new File(path));
                if(counter.get() < 3) {
                    cloneRepository(url, path);
                    counter.incrementAndGet();
                }else {
                   counter.set(0);
                }
                return;
            }
            throw new GitException(String.format("The repository %s could not be cloned. Failed with the following " +
                    "error message %s", url, e.getMessage()));
        }
    }

    public String getRepositoryName(String url) {
        return url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf("."));
    }
}
