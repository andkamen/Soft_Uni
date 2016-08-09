package main.bg.softuni.network.contracts;

public interface AsynchDownloader extends Downloader {

    void downloadOnNewThread(String fileUrl);

}
