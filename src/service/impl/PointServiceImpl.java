package service.impl;

import config.GlobalConfig;
import dao.PointDao;
import domain.Chapter;
import domain.Point;
import exception.ServiceException;
import service.ChapterService;
import service.PointService;
import util.FileUtil;

import java.util.List;

public class PointServiceImpl implements PointService {
    private PointDao pointDao;

    private PointServiceImpl() {
        pointDao = PointDao.getInstance();
    }

    private static class SingletonFactory{
        private static PointServiceImpl singleton = new PointServiceImpl();
    }

    public static PointServiceImpl getInstance(){
        return SingletonFactory.singleton;
    }

    @Override
    public int createPoint(String name, String description, int chapterId) throws ServiceException {
        Chapter chapter = ChapterService.getInstance().getChapterById(chapterId);

        if(chapter == null)
            throw new ServiceException("知识点对应的章节不存在");

        return pointDao.create(new Point(0, name, description, chapter));
    }


    @Override
    public List<Point> getPoints(int chapterId) throws ServiceException {
        Chapter chapter = ChapterService.getInstance().getChapterById(chapterId);

        if(chapter == null)
            throw new ServiceException("知识点对应的章节不存在");

        return pointDao.getByChapter(chapter);
    }

    @Override
    public String getVideoFolderURL(int pointId) {
        return String.format("/asserts/point/%d/video/", pointId);
    }

    @Override
    public String getDocumentFolderURL(int pointId) {
        return String.format("/asserts/point/%d/document/", pointId);
    }


    @Override
    public List<String> getListOfVideoFilename(int pointId) {
        return FileUtil.walkThroughFolder(String.format("%s/point/%d/video", GlobalConfig.assertPath, pointId));
    }

    @Override
    public List<String> getListOfDocumentFilename(int pointId) {
        return FileUtil.walkThroughFolder(String.format("%s/point/%d/document", GlobalConfig.assertPath, pointId));
    }


    @Override
    public Point getPointById(int id) {
        return pointDao.getById(id);
    }
}
